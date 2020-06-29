package ProblemSolving;

import java.util.*;

//11:53
public class TSP3usingDP {
	// DP will only work for leaf
	static int TSP(int currentNode, int startNode, ArrayList<Integer> nextNodes, int[][] cost, HashMap<String, Integer> dp) {
		ArrayList<Integer> keyAl  = new ArrayList(nextNodes);
		keyAl.add(currentNode);
		Collections.sort(keyAl);
		String key = keyAl.toString();	
		if(dp.containsKey(key)) return dp.get(key);
		else {
			if(nextNodes.isEmpty()) 
				dp.put(key, cost[currentNode][startNode]);
			else {
				int min = Integer.MAX_VALUE;
				for(Integer node: nextNodes) {
					ArrayList<Integer> newNextNodes = new ArrayList(nextNodes);
					newNextNodes.remove(node);
					min = Math.min(min, cost[currentNode][node]+TSP(node, startNode, newNextNodes, cost, dp));
				}
				dp.put(key, min);
			}
			return dp.get(key);
		}
	}
	public static void main(String[] args) {
		int[][] cost = new int [][] {{0,10,15,20}, {5,0,9,10}, {6,13,0,12},{8,8,9,0}};
		HashMap<String, Integer> dp = new HashMap();
		ArrayList<Integer> nextNodes = new ArrayList();
		for(int i = 0; i<cost.length; i++)
			nextNodes.add(i);
		int startNode = 0;
		nextNodes.remove(startNode);
		System.out.println(TSP(startNode, startNode, nextNodes, cost, dp));
		System.out.println(dp);
	}

}
