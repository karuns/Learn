package oop;


class MyFirstOop {
	public static void main(String[] args) {
		MyFirstClass m = new MyFirstClass();
		System.out.println(m.x);
		m.x = 2;
		System.out.println(m.x);
		//m.main(args); this will give stack overflow
		
		// Multiple objects
		MyFirstClass m2 = new MyFirstClass();
		System.out.println(m2.x);
		
		// Multiple constructor
		MyFirstClass m3 = new MyFirstClass(100);
		System.out.println(m3.x);
		
		
	}
}
