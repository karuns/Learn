package JavaLearn;
import java.util.*;

public class ThreadLearn {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Vector<MyThread> myThreads = new Vector();
		in.close();
		Thread.currentThread().setPriority(4);
		
		// Using abstract class Thread
		for(int i = 0; i < n; i++)
			myThreads.add(new MyThread(Character.toString(65+i)));
		
		for (MyThread t: myThreads) {
			t.setPriority(4);
			t.start();
		}
		
		// Main thread
		for(int i = 0 ; i<20; i++) {
			System.out.println('#');
		}
		
		// Thread join of Abstract
		try {
			for (MyThread t: myThreads) t.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finished thread using Extend");
		
		
		// Using Runnable
		Vector<Thread> myrunnables = new Vector();
		for(int i = 0; i < n; i++) {
			MyRunnable mr = new MyRunnable(Character.toString(65+i));
			myrunnables.add(new Thread(mr));
		}
		
		for(int i = 0; i < n; i++) myrunnables.get(i).start();
		
		// Main thread
		for(int i = 0 ; i<20; i++) {
			System.out.println('#');
		}
		
		// Thread join of Abstract
		try {
			for (Thread t: myrunnables) t.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finished thread using Runnable");

	}
}


