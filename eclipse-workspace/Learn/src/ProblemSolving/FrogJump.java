package ProblemSolving;
import java.util.*;

public class FrogJump {
	public static HashMap<Integer,HashSet> hm = new HashMap<Integer, HashSet>();
	public static int [] arr = {0,1,3,5,6,8,12,17};
	//public static int [] arr = {0,1,2,3,4,8,9,11};
	
	public static void printHm() {
		Iterator it = hm.keySet().iterator();
		while(it.hasNext()) {
			int k = Integer.parseInt(it.next().toString());
			System.out.print(k);
			System.out.print(":");
			Iterator j = hm.get(k).iterator();
			while(j.hasNext()) {
				System.out.print(Integer.parseInt(j.next().toString()));
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

	public static void fillRow(int k, int j) {
		HashSet<Integer> hs = new HashSet<Integer>();
		hs = hm.get(k+j);
		for (int i = j-1; i<=j+1;i++) hs.add(i);
		hm.put(k+j, hs);
	}
	
	public static void main(String [] args) {
		// Initialize hash map: key would be each item from row and Value will be hash set with empty, put 1 in 0th position.
		/* for hs in HashMap
		 * 	for i in hs.list()
		 *  	if (i>0 && hs haskey(hs.key+i)) 
		 *  		add to list of (hs.key+i) list [i-1 - i+1] 
		 * if last element of hs has non emptylist -> true
		 * else false;
		 */
		
		int n = arr.length;
		for (int i = 0; i<n ; i++) {
			HashSet<Integer> hs = new HashSet<Integer>();
			if (i==0) hs.add(1);
			hm.put(arr[i],hs);
		}
		
		for(int i = 0; i<n ; i++) {
			int key = arr[i];
			Iterator j =  hm.get(key).iterator();
			while(j.hasNext()) {
				int posibleJumps = Integer.parseInt(j.next().toString());
				if(posibleJumps >0 && hm.containsKey(key+posibleJumps)) fillRow(key,posibleJumps);
			}
		}
		
		printHm();
		// Final condition;
		if (hm.get(arr[arr.length-1]).isEmpty()) System.out.println("False");
		else  System.out.println("True");
	}
}
