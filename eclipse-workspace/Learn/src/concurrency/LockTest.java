package concurrency;
import java.util.*;

public class LockTest extends Thread {
	String readWrite;
	String threadName;
	int waitSecond;
	static Lock lock = new Lock();
	
	public static void main(String[] args) throws InterruptedException {
		String[][] tasks = {
				{"w", "Write 1", "4000"},
				{"r", "Read 1", "30000"},
				{"r", "Read 2", "10000"},
				{"r", "Read 3", "1000"},
				{"w", "Write 2", "5000"},
				{"r", "Read 4", "10000"},};
		Vector<LockTest> taskList = new Vector();
		for(int i = 0; i< tasks.length; i++) {
			LockTest m = new LockTest(tasks[i][0], tasks[i][1], Integer.parseInt(tasks[i][2]));
			taskList.add(m);
		}
		
		for(LockTest m: taskList)
			m.start();
		
		for(LockTest m: taskList)
			m.join();
		
		System.out.println("Finished!!!");
	}
	
	LockTest(String readWrite, String threadName, int waitSecond) {
		this.readWrite = readWrite;
		this.threadName = threadName;
		this.waitSecond = waitSecond;
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
		System.out.print(currentThread().getName()+" ");
		lock.acquireWriteLock();
		
		System.out.println(currentThread().getName() + " writing for "+waitSecond+" secods");
		sleeps(waitSecond);
		
		System.out.print(currentThread().getName() + " ");
		lock.releaseWriteLock();
		
	}
	
	
	
	public static void reader(int waitSecond) {
		System.out.print(currentThread().getName() + " ");
		lock.acquireReadLock();
		System.out.println(currentThread().getName() + " reading for "+waitSecond+" secods");
		sleeps(waitSecond);
		
		System.out.print(currentThread().getName() + " ");
		lock.releaseReadLock();
	}
	
	public void run() {
		this.currentThread().setName(threadName);
		if(this.readWrite == "w")
			this.writer(this.waitSecond);
		else
			this.reader(this.waitSecond);
	}
}