package DataStructure;
import java.util.*;


// 11:45 - 17 minutes
public class MaxStack {
	Stack<Integer> stk = new Stack();
	Stack<Integer> mxStk = new Stack();
	
	MaxStack(){	
	}
	
	void push(int n ) {
		stk.push(n);
		if(mxStk.isEmpty() || (n >= mxStk.peek())) {
			mxStk.push(n);
		}
	}
	
	int pop() {
		if(!stk.isEmpty()) {
			if(stk.peek() == mxStk.peek())
				mxStk.pop();
			return stk.pop();
		}
		return -1;
	}
	
	
	int peek() {
		return stk.peek();
	}
	
	int maxPeek() {
		return mxStk.peek();
	}
	
	void print() {
		System.out.println("Stack:" + stk);
		System.out.println("Max Stack:" + mxStk);
		
	}
	
	public static void main(String[] args) {
		MaxStack ms = new MaxStack();
		ms.push(50);
		ms.push(40);
		ms.push(35);
		System.out.println(ms.maxPeek());
		ms.push(55);
		ms.push(55);
		ms.push(37);
		ms.push(20);
		System.out.println(ms.maxPeek());
		System.out.println(ms.pop());
		System.out.println(ms.pop());
		System.out.println(ms.maxPeek());
		System.out.println(ms.pop());
		System.out.println(ms.maxPeek());
		ms.push(60);
		System.out.println(ms.maxPeek());
		System.out.println(ms.pop());
		ms.push(10);
		ms.print();
		System.out.println("Hello world");
	}
}
