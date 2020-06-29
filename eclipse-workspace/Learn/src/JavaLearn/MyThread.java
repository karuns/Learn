package JavaLearn;

public class MyThread extends Thread {
	String sym = "$";
	public void run () {
		for(int i = 0 ; i<20; i++) {
			System.out.println(this.sym);
		}
	}
	MyThread(String sym){
		this.sym = sym;
	}

}
