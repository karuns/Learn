package ProblemSolving;
import java.util.*;

import DataStructure.Pair;
//12:12
/*
 * Approach
 * DS: put (Initial:final) in hash map as key and value, created a hash set to keep track of visited nodes
 * for each items in hashmap if key and value both not in [visited] set and key!=value then continue
 * else fnd cycles by 
 * 	initializing cycle counter to 1
 * 	Key j = current key
 * 	loop until for key(j) see if value is in visited (cycle). 
 * 		put key value in visited.
 * 		increment cycle
 * 		now go search in newkey which is current value
 * 
 */
public class FindCycleInArray {
	
	public static int findSwaps(int [][] arr) {
		HashMap<Integer,Integer> lookup = new HashMap();
		HashSet<Integer> visited = new HashSet();
		
		for (int i=0; i<arr.length; i++)  lookup.put(arr[i][0], arr[i][1]);
		
		Iterator it = lookup.keySet().iterator();
		int cycles = 0;
		while(it.hasNext()) {
			Integer i = (Integer) it.next();
			cycles = 1;
			if(visited.contains(lookup.get(i)) && (visited.contains(i))) continue;
			else if (lookup.get(i) == i) continue;
			else { //find the cycles
				
				int j = i;
				while (!visited.contains(lookup.get(j))) {
					visited.add(j);
					visited.add(lookup.get(j));
					cycles++;
					j = lookup.get(j);
				}
				System.out.println(cycles);
			}
		
		}
		return 1;

	}
	public static void main (String [] args ) {
		int [][] arr = {{3,0},{1,1},{0,2},{2,3},{5,4},{4,5},{8,9},{9,8}};
		
		
		
		System.out.println(findSwaps(arr));
	}
}
