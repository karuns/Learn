package concurrency;

public class MyLock2 extends Thread {
	char readWrite;
	String threadName;
	int waitSecond;
	static int threadCount = 0;
	static int readLock = 1;
	static int writeLock = 1;
	
	public static void main(String[] args) throws InterruptedException {
		MyLock2 ml = new MyLock2('w', "Write 1", 4000);
		MyLock2 m2 = new MyLock2('r', "Read 1", 30000);
		MyLock2 m3 = new MyLock2('r', "Read 2", 10000);
		MyLock2 m4 = new MyLock2('r', "Read 3", 1000);
		MyLock2 m5 = new MyLock2('w', "Write 2", 5000);
		MyLock2 m6 = new MyLock2('r', "Read 4", 10000);
		ml.start();
		m2.start();
		m3.start();
		m4.start();
		m5.start();
		m6.start();		
		
		ml.join();
		m2.join();
		m3.join();
		m4.join();
		m5.join();
		m6.join();	
		
		System.out.println("Finished!!!");
	}
	
	MyLock2(char readWrite, String threadName, int waitSecond) {
		this.readWrite = readWrite;
		this.threadName = threadName;
		this.waitSecond = waitSecond;
	}
	
	public static void incrementReadCount() {
		MyLock2.threadCount++;
	}
	
	public static int getReadCount() {
		return MyLock2.threadCount;
	}
	
	public static void decrementReadCount() {
		MyLock2.threadCount--;
	}
	
	public static void lockReadLock() {
		MyLock2.readLock = 0;
	}
	
	public static void lockWriteLock() {
		MyLock2.writeLock = 0;
	}
	
	public static void releasekReadLock() {
		MyLock2.readLock = 1;
	}
	
	public static void releasekWriteLock() {
		MyLock2.writeLock = 1;
	}
	
	
	public void run() {
		this.currentThread().setName(threadName);
		if(this.readWrite == 'w') {
			System.out.println(this.currentThread().getName() + " waiting for [write] lock to be available");
			while(MyLock2.writeLock != 1 || MyLock2.readLock != 1) {
				try {
					this.sleep(this.waitSecond);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.lockReadLock();
			this.lockWriteLock();
			System.out.println(this.currentThread().getName() + " acquired [write] lock, writing for "+this.waitSecond+" secods");
			try {
				this.sleep(this.waitSecond);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.currentThread().getName() + " [write] lock released");
			this.releasekReadLock();
			this.releasekWriteLock();
		}else {
			System.out.println(this.currentThread().getName() + " waiting for [read] lock to be available");
			while(MyLock2.readLock != 1) {
				try {
					this.sleep(this.waitSecond);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.lockReadLock();
			incrementReadCount();
			if(this.getReadCount() == 1) 
				this.lockWriteLock();
			this.releasekReadLock();
			System.out.println(this.currentThread().getName() + " acquired [read] lock, reading for "+this.waitSecond+" secods");
			try {
				this.sleep(this.waitSecond);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.currentThread().getName() + " [read] lock released");
			this.lockReadLock();
			decrementReadCount();
			if(this.getReadCount() == 0) 
				this.releasekWriteLock();
			this.releasekReadLock();
			
		}
	}
}
