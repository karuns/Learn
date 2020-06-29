package JavaLearn;

public class MyRunnable implements Runnable {
	String sym;
	
	MyRunnable(String sym) {
		this.sym = sym;
	}

	@Override
	public void run() {
		for(int i =0; i<10; i++) 
			System.out.println(this.sym);
	}	
}
