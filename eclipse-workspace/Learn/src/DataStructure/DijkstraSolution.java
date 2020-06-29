package DataStructure;
import java.util.*;
//https://www.youtube.com/watch?v=XB4MIexjvY0

//1:27, 1 hour 10 minutes with 2 bugs
public class DijkstraSolution {
	
	public static int getMinNonVisited(int[] d, HashSet<Integer> set) {	
		int minIndex = 0;
		for (int i = 0; i<d.length; i++) 
			if (!set.contains(i) && (d[i] < d[minIndex])) minIndex = i; // bug #1
		return minIndex;
	}
	
	public static void relaxNodes(int node, int[] d, 
			HashMap<String, Integer> cost, 
			HashMap<Integer,ArrayList<Integer>> connection, 
			HashSet<Integer> set ){
		if(connection.containsKey(node)) {
			ArrayList<Integer> nodes = connection.get(node);
			for(Integer i: nodes) {
				int costI = Integer.MAX_VALUE;
				if(cost.containsKey(node+":"+i))
					costI = cost.get(node+":"+i);
				if(d[i] > d[node]+costI) // bug #2
					d[i] = d[node]+costI;
			}
		}
	}
			
	public static void main(String[] args) {	
		int n = 6;
		// Input
		HashMap<String, Integer> cost = new HashMap();
//		//InPUt 1
//		cost.put("1:2",2);
//		cost.put("1:3",4);
//		cost.put("2:3",1);
//		cost.put("2:4",7);
//		cost.put("3:5",3);
//		cost.put("5:4",2);
//		cost.put("4:6",1);
//		cost.put("5:6",5);
		
		//Input #2
		cost.put("1:2",50);
		cost.put("1:3",45);
		cost.put("1:4",10);
		cost.put("4:1",10);
		cost.put("4:5",15);
		cost.put("2:4",15);
		cost.put("2:3",10);
		cost.put("5:2",20);
		cost.put("5:3",35);
		cost.put("3:5",30);
		cost.put("6:5",3);
		
		HashMap<Integer,ArrayList<Integer>> connection = new HashMap();
		
		//find connection
		for(String i: cost.keySet()) {
			int key = Integer.parseInt(i.split(":")[0]);
			int val = Integer.parseInt(i.split(":")[1]);
			
			ArrayList<Integer> al = new ArrayList();
			if(connection.containsKey(key))
				al.addAll(connection.get(key));
			al.add(val);
			connection.put(key, al);
		}
		
		int[] d = new int[n+1];
		for(int i = 0;i <n+1; i++) d[i] = Integer.MAX_VALUE;
		d[1]=0;
		HashSet<Integer> set = new HashSet();
		set.add(0);
		int node = getMinNonVisited(d, set);
		while(node != 0) {
			relaxNodes(node, d, cost, connection, set);
			set.add(node);
			node = getMinNonVisited(d, set);
		}
		
		for(int i = 0; i < d.length; i++) System.out.print(d[i] + " ");
	}
}
