package oop;

class MyFirstClass{
	int x = 1;
	public MyFirstClass() { // Constructor can't be static such as public static MyFirstClass
		this.x = 10;
	}
	public MyFirstClass(int x ) { // Can have multiple constructor with method overload
		this.x = x;
	}
}