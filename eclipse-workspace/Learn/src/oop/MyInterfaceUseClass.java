package oop;

public class MyInterfaceUseClass extends MyAbstractClass implements MyInterfaceClassAB, MyInterfaceClassCD {
	/*
	 * Abstract class can have abstract or non abstract methods
	 * when abstract class is inherited then all the abstract methods needs to be implemented (@override)
	 */ 

	@Override
	public void printI() {
		System.out.println(this.i);
		
	}
	

	@Override
	public void methodC() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int methodD() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void methodA() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int methodB() {
		// TODO Auto-generated method stub
		return 0;
	}
}
