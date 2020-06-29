package ProblemSolving;
import DataStructure.*;
import java.util.*;

public class MsLowestCommonAncestorSelf {
	public static void traverse(Node root) {
		if(root.left()!=null) traverse(root.left());
		if(root.right()!=null) traverse(root.right());
		System.out.println(root.val());		
	}
	
	public static void printStk(Stack s) {
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
	public static Stack<Integer> pathToX(Node root, int n) {
		Stack <Integer> stk = new Stack<Integer>();
		if(root!=null) {
			if(root.val()==n) stk.push(root.val());
			else {
				Stack <Integer> stkL = new Stack<Integer>();
				stkL = pathToX(root.left(),n);
				if (!stkL.isEmpty()) {
					stkL.push(root.val());
					return stkL ;
				}
				Stack <Integer> stkR = new Stack<Integer>();
				stkR = pathToX(root.right(),n);
				if (!stkR.isEmpty()) {
					stkR.push(root.val());
					return stkR;
				}
			}
		}
		return stk;		
	}
	
//	public static int pathToX(Node root, int n) {
//		int val = Integer.MIN_VALUE;
//		if(root!=null) {
//			if(root.val()==n) val = root.val();
//			else {
//				if ((pathToX(root.left(),n) !=Integer.MIN_VALUE)) val = root.val();
//				if (( pathToX (root.right(),n) !=Integer.MIN_VALUE)) val = root.val();
//			}
//		}
//		if (val != Integer.MIN_VALUE) System.out.println(val);
//		return val;		
//	}
	
	public static int find(Node root, int l, int r) {
		int count = 0;
		if(root.left()!=null) count += find(root.left(),l,r);
		if(root.right()!=null) count += find(root.right(),l,r);
		int val = root.val();
		if (val==l || val==r) count++;
		return count;
		
		
	}
	public static int lca(Node root, int l, int r) {
		int val = Integer.MIN_VALUE;
		int lFind = find(root.left(),l,r);
		int rFind = find(root.right(),l,r);
		
		if ((l==r)&&(root.val()==l)) val = l;
		else if (lFind ==2) {
			val = Math.max(val,lca(root.left(),l,r));
		}else if (rFind ==2) {
			val = Math.max(val,lca(root.right(),l,r));
		}else if ((lFind==1) || (rFind==1)){
			if ((lFind==1) && (rFind==1)) val = root.val();
			if ((root.val()==l)||(root.val()==r)) val = root.val();
			if (l==r)  val = root.val();
		}
		return val;
	}
	
	public static int lcaUsingStack(Node root, int l, int r) {
		
		Stack <Integer> stkL = new Stack<Integer>();
		stkL = pathToX(root,l);
		Stack <Integer> stkR = new Stack<Integer>();
		stkR = pathToX(root,r);
		Integer lca = Integer.MIN_VALUE;
		while(!stkL.isEmpty() && !stkR.isEmpty()) {
			if(stkL.pop() == stkR.peek()) lca = stkR.pop();
			else break;
		}
		return lca;
	}
	
	public static void main (String[] args) {
		Node root = new Node(6,new Node(5),null);
		root = new Node(3,new Node(4),root);
		root = new Node(1,root,new Node(2));
		//traverse(root);
		
//		System.out.println("LCA");
//		System.out.println(lca(root,4,5));
//		System.out.println(lca(root,3,5));
//		System.out.println(lca(root,4,2));
//		System.out.println(lca(root,6,6));
//		System.out.println(lca(root,1,1));
		
//		System.out.println("pathToX=");
//		System.out.println(pathToX(root,4));
//		System.out.println("pathToX=");
//		System.out.println(pathToX(root,6));
//		System.out.println("pathToX=");
//		System.out.println(pathToX(root,3));
//		System.out.println("pathToX=");
//		System.out.println(pathToX(root,-1));
		
//		printStk(pathToX(root,4));
//		System.out.println("pathToX Using Stack=");
//		printStk(pathToX(root,5));
//		System.out.println("pathToX Using Stack=");
//		printStk(pathToX(root,2));
//		System.out.println("pathToX Using Stack=");
//		printStk(pathToX(root,1));
//		System.out.println("pathToX Using Stack=");
//		printStk(pathToX(root,-1));
		
		System.out.println("LCA usng Stack");
		System.out.println(lcaUsingStack(root,4,5));
		System.out.println(lcaUsingStack(root,3,5));
		System.out.println(lcaUsingStack(root,4,2));
		System.out.println(lcaUsingStack(root,6,6));
		System.out.println(lcaUsingStack(root,1,9));
		
	}
}
