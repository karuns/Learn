package DataStructure;
import java.util.*;
public class DFSapplication {
	public static void printLeftView(TNode t, boolean left) {
		if(t !=null) {
			if(left) System.out.println(t.val);
			printLeftView(t.left, true);
			printLeftView(t.right, false);
			
		}
	}

	public static void preOrder(TNode t) {
		if(t!=null) {
			System.out.println(t.val);
			preOrder(t.left);
			preOrder(t.right);
		}
	}
	
	public static void postOrder(TNode t) {
		if(t!=null) {
			postOrder(t.left);
			postOrder(t.right);
			System.out.println(t.val);
		}
	}
	
	public static void inOrder(TNode t) {
		if(t!=null) {
			inOrder(t.left);
			System.out.println(t.val);
			inOrder(t.right);
		}
	}
	
	public static void BFS(TNode t) {
		/* start with queu and put the pointer of node.
		 * while q is not empty
		 * 	item = deque
		 *  print item.val
		 *  if valid item (item.l, item.r) (if not null and not revisited)
		 *  	enque ()
		 */
		Queue<TNode> q = new LinkedList();
		HashSet<Integer> hs = new HashSet();
		
		if (t!=null) q.add(t);
		while(!q.isEmpty()) {
			TNode item = q.poll();
			System.out.println(item.val);
			hs.add(item.val); // Mark as visited.
			// If items are not null and not visited then add them in the q.
			if((item.left!=null) && !hs.contains(item.left)) q.add(item.left);
			if((item.right!=null) && !hs.contains(item.right)) q.add(item.right);
			
		}
	}
	
	public static void printLevel(int eLevel, TNode t, int cLevel ) {
		if(t!=null) {
			if(cLevel < eLevel) {
				printLevel(eLevel,t.left,cLevel+1);
				printLevel(eLevel,t.right,cLevel+1);
			}
			else if(cLevel == eLevel) {
				System.out.println(t.val);
			}
		}
	}
	
	public static void BFSWithoutQueue(BinaryTree t) {
		for (int i = 1; i<= t.size();i++)
			printLevel(i, t.root, 1);
	}
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TNode(1);

		bt.root.left = new TNode(2);
		bt.root.right = new TNode(3);
		bt.root.right.right = new TNode(6);
		bt.root.left.left = new TNode(4);
		bt.root.left.right = new TNode(5);

//		// Find Size of BT
//		System.out.println(bt.size());
//		
//		// Find max
//		System.out.println(bt.max());
//		
//		// Find min
//		System.out.println(bt.min());
		
		
		//printLeftView(bt.root,true);
		System.out.println("Inorder");
		inOrder(bt.root);
		System.out.println("Preorder");
		preOrder(bt.root);
		System.out.println("Postorder");
		postOrder(bt.root);
		System.out.println("BFS");
		BFS(bt.root);
		System.out.println("BFS without Queue");
		BFSWithoutQueue(bt);
		
		
		
	}
	
}
