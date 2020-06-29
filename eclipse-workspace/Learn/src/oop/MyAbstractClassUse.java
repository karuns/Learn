package oop;

public class MyAbstractClassUse extends MyAbstractClass {
	/*
	 * Abstract class can have abstract or non abstract methods
	 * when abstract class is inherited then all the abstract methods needs to be implemented (@override)
	 */

	@Override
	public void printI() {
		System.out.println(this.i);
		
	}
	
	public static void main(String [] args) {
		
		//Abstract class
		MyAbstractClassUse mac = new MyAbstractClassUse();
		mac.printI();
		mac.printJ();
	}
}
