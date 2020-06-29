package DataStructure;
import java.util.*;
public class StackQueueExample {

	public static void main (String [] args) {
		// Stack example
		Stack<Integer> stk = new Stack();
		stk.push(1);
		stk.push(5);
		stk.push(2);
		System.out.println(stk);
		System.out.println(stk.peek());
		System.out.println(stk.pop());
		System.out.println(stk);
		stk.
	
		
		
		PriorityQueue<Integer> q = new PriorityQueue();
		q.add(10);
		q.add(5);
		q.add(2);
		q.add(4);
		System.out.println(q);
		stk.addAll(q);
		System.out.println(stk);
		
		Queue<Integer> qq = new LinkedList();
		Integer min = 0;
		stk.forEach(s->{
			System.out.println(s);

		} );
		q.
		
		qq.add(1);
		qq.add(3);
		System.out.println(qq);
		
		
		//DQueue<Integer> qq = new DQueue();
		
		
	}
	
}
