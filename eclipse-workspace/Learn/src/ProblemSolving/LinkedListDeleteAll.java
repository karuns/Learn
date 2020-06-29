package ProblemSolving;

//3:40 - 36
public class LinkedListDeleteAll {


	
	static Node deleteAll(Node root, int val) {
		root = new Node(0, root);
		Node prev = root;
		Node current = prev.next;
		
		while(current != null) {
			while(current != null && current.val == val) {
				prev.next = current.next;
				current = current.next;
			}
			prev = prev.next;
			if(current != null) current = current.next;
		}
		
		return root.next;
	}
	
	static void print(Node root) {
		while(root != null) {
			System.out.print(" " + root.val);
			root = root.next;
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(2);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(2);
		head.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next.next.next = new Node(2);
		print(head);
		head = deleteAll(head, 9);
		System.out.println();
		print(head);
	}
	
	public static class Node {
		
		int val;
		Node next;
		
		Node( int val){
			this.val = val;
		}
		
		Node(int val, Node next){
			this.val = val;
			this.next = next;
		}
	}
}
