
package ProblemSolving;
import java.util.*;

public class TSP {
	
	//Integer [] a = {1,3};
	public static int [][] cost = new int [][] {{0,10,15,20}, {5,0,9,10}, {6,13,0,12},{8,8,9,0}};
    public static HashMap<String, Integer> dp = new HashMap();

    
    
	public static int TSP(int startNode, int st, List<Integer> ls) {
	
		String key = Integer.toString(st)+":"+ls.toString();
		Integer min = Integer.MAX_VALUE;
	    if(dp.containsKey(key)) return dp.get(key);
    	else { 
			
			if(!ls.isEmpty()) {
				Iterator it = ls.iterator();
				while(it.hasNext()) {
					Integer item = (Integer) it.next();
					int newCost = cost[st][item];
					List<Integer> newLs = new ArrayList(ls);
					newLs.remove(item);
					min = Math.min(min, newCost + TSP(startNode, item, newLs));
				}
			}
			
			else min = cost[st][startNode];
			dp.put(key, min);
			return min;
    	}
	}

	public static void main(String [] args) {
		List<Integer> ls = new ArrayList();
		for(int i = 0; i<cost.length;i++) ls.add(i);
		int startNode = 1;
		ls.remove(startNode);
		System.out.println(TSP(startNode,startNode,ls));
		System.out.println(dp);
		
	}
}