package DataStructure;
import java.util.*;
import java.util.Map.Entry;


/* Approach, same could be used for top view as well
 * pre order traversal 
 * with passing, width (vertical ). increase this width when going left, decrease when going right.
 * instead of printing,  putting in hash map with width (vertical)
 * https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
 */

public class  VerticalOrderTraversal {
	public static void vOrderTraversal(Node1 root, int width, TreeMap<Integer, ArrayList<Integer>> hm) {
		if (root != null) {
			ArrayList<Integer> ls = new ArrayList();
			if(hm.containsKey(width)) {
				ls.addAll(hm.get(width));
				ls.add(root.val());
			}
			else ls.add(root.val());
			hm.put(width,ls);
			vOrderTraversal(root.left, width-1, hm);
			vOrderTraversal(root.right,width+1,hm);
			
		}

	}
	
	public static void main (String [] args) {
		
		// Construct input tree
		Node1 n = new Node1(1);
		n.left = new Node1(2);
		n.left.left = new Node1(4);
		n.left.right = new Node1(5);
		n.right = new Node1(3);
		n.right.right = new Node1(7);
		n.right.left = new Node1(6);
		n.right.right.right = new Node1(9);
		n.right.right.left = new Node1(8);
		
				
		        
		// Construct a Tree
		
		TreeMap<Integer, ArrayList<Integer>> hm = new TreeMap();
		vOrderTraversal(n, 0, hm);
		System.out.println(hm);
		
		for (Entry<Integer, ArrayList<Integer>> i: hm.entrySet()) {
			System.out.println(i.getValue());
			
		}
	}	
}

