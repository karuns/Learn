package concurrency;
import java.util.*;

public class ReadWriteLock extends Thread {
	String readWrite;
	String threadName;
	int waitSecond;
	static int threadCount = 0;
	static int readLock = 1;
	static int writeLock = 1;
	
	public static void main(String[] args) throws InterruptedException {
		String[][] tasks = {
				{"w", "Write 1", "4000"},
				{"r", "Read 1", "30000"},
				{"r", "Read 2", "10000"},
				{"r", "Read 3", "1000"},
				{"w", "Write 2", "5000"},
				{"r", "Read 4", "10000"},};
		Vector<ReadWriteLock> taskList = new Vector();
		for(int i = 0; i< tasks.length; i++) {
			ReadWriteLock m = new ReadWriteLock(tasks[i][0], tasks[i][1], Integer.parseInt(tasks[i][2]));
			taskList.add(m);
		}
		
		for(ReadWriteLock m: taskList)
			m.start();
		
		for(ReadWriteLock m: taskList)
			m.join();
		
		System.out.println("Finished!!!");
	}
	
	ReadWriteLock(String readWrite, String threadName, int waitSecond) {
		this.readWrite = readWrite;
		this.threadName = threadName;
		this.waitSecond = waitSecond;
	}
	
	public static void incrementReadCount() {
		ReadWriteLock.threadCount++;
	}
	
	public static int getReadCount() {
		return ReadWriteLock.threadCount;
	}
	
	public static void decrementReadCount() {
		ReadWriteLock.threadCount--;
	}
	
	public static void lockReadLock() {
		ReadWriteLock.readLock = 0;
	}
	
	public static void lockWriteLock() {
		ReadWriteLock.writeLock = 0;
	}
	
	public static void releasekReadLock() {
		ReadWriteLock.readLock = 1;
	}
	
	public static void releasekWriteLock() {
		ReadWriteLock.writeLock = 1;
	}
	
	public static void sleeps(int mSeconds) {
		try {
			currentThread().sleep(mSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writer(int waitSecond) {
		System.out.println(currentThread().getName() + " waiting for [write] lock to be available");
		while(ReadWriteLock.writeLock != 1 || ReadWriteLock.readLock != 1)
			sleeps(waitSecond);

		lockReadLock();
		lockWriteLock();
		System.out.println(currentThread().getName() + " acquired [write] lock, writing for "+waitSecond+" secods");
		sleeps(waitSecond);
		System.out.println(currentThread().getName() + " [write] lock released");
		releasekReadLock();
		releasekWriteLock();
	}
	
	
	public static void reader(int waitSecond) {
		System.out.println(currentThread().getName() + " waiting for [read] lock to be available");
		while(ReadWriteLock.readLock != 1)
			sleeps(waitSecond);
		
		lockReadLock();
		incrementReadCount();
		if(getReadCount() == 1) 
			lockWriteLock();
		releasekReadLock();
		System.out.println(currentThread().getName() + " acquired [read] lock, reading for "+waitSecond+" secods");
		sleeps(waitSecond);
		
		System.out.println(currentThread().getName() + " [read] lock released");
		lockReadLock();
		decrementReadCount();
		if(getReadCount() == 0) 
			releasekWriteLock();
		releasekReadLock();
	}
	
	public void run() {
		this.currentThread().setName(threadName);
		if(this.readWrite == "w")
			this.writer(this.waitSecond);
		else
			this.reader(this.waitSecond);
	}
}