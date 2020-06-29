package ProblemSolving;

import java.util.ArrayList;

//11:53
public class TSP2 {
	static int TSP(int currentNode, int startNode, ArrayList<Integer> nextNodes, int[][] cost) {
		if(nextNodes.isEmpty()) 
			return cost[currentNode][startNode];
		else {
			int min = Integer.MAX_VALUE;
			for(Integer node: nextNodes) {
				ArrayList<Integer> newNextNodes = new ArrayList(nextNodes);
				newNextNodes.remove(node);
				min = Math.min(min, cost[currentNode][node]+TSP(node, startNode, newNextNodes, cost));
			}
			return min;
		}
	}
	public static void main(String[] args) {
		int[][] cost = new int [][] {{0,10,15,20}, {5,0,9,10}, {6,13,0,12},{8,8,9,0}};
		
		ArrayList<Integer> nextNodes = new ArrayList();
		for(int i = 0; i<cost.length; i++)
			nextNodes.add(i);
		int startNode = 0;
		nextNodes.remove(startNode);
		System.out.println(TSP(startNode, startNode, nextNodes, cost));
	}

}
