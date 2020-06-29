package ProblemSolving;
import java.util.*;

public class FrogJump2 {
	public static HashMap<Integer,HashSet> hm = new HashMap<Integer, HashSet>();
	//public static int [] arr = {0,1,3,5,6,8,12,17};
	public static int [] arr = {0,1,2,3,4,8,9,11};
	
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
	
	public static void addToMap(int k, int i) {
		int potentialK =i+k; 
		if(i>0 && hm.containsKey(potentialK)) {
			HashSet<Integer> hs = new HashSet<Integer>();
			hs = hm.get(potentialK);
			for(int j=i-1;j<=i+1;j++) {
				//if ((j > 0) && hm.containsKey(potentialK+j)) hs.add(j);
				if (j > 0) hs.add(j);
			}
			hm.put(potentialK, hs);
		}
	}
	public static void fillRow(int k, int j) {
		System.out.print("(k,j): ");
		System.out.print(k);
		System.out.print(",");
		System.out.print(j);
		for (int i = j-1; i<=j+1;i++) {
//			System.out.print(k);
//			System.out.print(",");
//			System.out.print(j);
			addToMap(k,i);
//			System.out.print(" ");
		}
		System.out.println("");
	}
	
	public static void main(String [] args) {
		//Initialize Hash Map
		int n = arr.length;
		for (int i = 0; i<n ; i++) {
			HashSet<Integer> hs = new HashSet<Integer>();
			if (i==0) hs.add(1);
			hm.put(arr[i],hs);
		}
		// Go thru each item in HashMap and fill with possible jumps
		for(int i = 0; i<n ; i++) {
			int key = arr[i];
			//System.out.println(key);
			Iterator j =  hm.get(key).iterator();
			while(j.hasNext()) {
				int posibleJumps = Integer.parseInt(j.next().toString());
				if(posibleJumps >0 && hm.containsKey(key+posibleJumps)) fillRow(key,posibleJumps);
			}
		}
		
		printHm();
		// Final condition;
		HashSet<Integer> hs1 = new HashSet<Integer>();
		hs1 = hm.get(arr[arr.length-1]);
		if (hs1.isEmpty())
			System.out.println("False");
		else  System.out.println("True");
	}
}
