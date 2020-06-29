package ProblemSolving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CastleRock4{
	// create hash map with start as -2, everything else as integer max and goal as 0 value. put -1 for all the x.
	// start from goal and find all the possible moves (within the range,value !=-1, and new value smaller than existing (except for less than -2)
	// for each cell 
	// if value != -2 then get the minimum
	// do the same things
    static boolean check(String [] grid, int x, int y, HashMap<String,Integer[]> visited) {
    	String key = x+":"+y;
    	if(x<0 || y<0 || x>grid.length-1 || y>grid.length-1) return false;
    	else if (visited.containsKey(key)) return false;
    	else if(grid[x].charAt(y)!='.') return false;
    	else return true;
    }

    static Queue<Integer[]> getValidMoves(String [] grid, int x, int y, HashMap<String,Integer[]> visited) {
        Queue<Integer[]> q = new LinkedList();
        if (check(grid, x-1, y, visited )) q.add(new Integer[] {x-1, y});
        if (check(grid, x+1, y, visited )) q.add(new Integer[] {x+1, y});
        if (check(grid, x, y-1, visited )) q.add(new Integer[] {x, y-1});
        if (check(grid, x, y+1, visited )) q.add(new Integer[] {x, y+1});
        return q;
    }
    

    static int traverse(String [] grid, int goalX, int goalY, Queue<String> q, HashMap<String, Integer[]> visited) {
    	while(!q.isEmpty()) {
    		String key = q.poll();
    		int currentI = Integer.parseInt(key.split(":")[0]);
    		int currentJ = Integer.parseInt(key.split(":")[1]);
    		int depth = visited.get(key)[0];
    		int gPX = visited.get(key)[1];
    		int gPY = visited.get(key)[2];;
    		
    		Queue<Integer[]> newQ = getValidMoves(grid, currentI, currentJ, visited);
    		while(!newQ.isEmpty()) {
    			Integer[] newKey = newQ.poll();
    			int newI = newKey[0];
        		int newJ = newKey[1];
        		int newDepth = depth+1;
        		String newKeyString = newKey[0]+":"+newKey[1];
        		if(newI == gPX || newJ == gPY) // relax edge, grandparent, or edge didn't bend
        			newDepth--;
        		
        		if(newI == goalX && newJ == goalY) return newDepth;
        		else {
        			q.add(newKeyString);
        			visited.put(newKeyString,new Integer[] {newDepth, currentI,currentJ});
        		}
    		}
    		
    	}
    	
    	return Integer.MIN_VALUE;
    }

    static void print_matrix(HashMap<String,Integer[]> visited, String [] grid) {
    	Iterator it = visited.keySet().iterator();
    	int [][] arr = new int[grid.length][grid.length];
    	
    	while(it.hasNext()) {
    		String item = (String)it.next();
    		Integer i = Integer.parseInt(item.split(":")[0]);
    		Integer j = Integer.parseInt(item.split(":")[1]);
    		if(i>=0 && j>=0)
    			arr[i][j]= visited.get(item)[0];
    	}
    	for(int i = 0;i<grid.length;i++) {
        	for(int j = 0;j<grid.length;j++) {
        		System.out.print(arr[i][j]+ " ");
        	}
    	System.out.println("");}
    	
    }
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY)     {
    	HashMap<String, Integer[]> lookup = new HashMap();
    	Queue<String> q = new LinkedList();
    	String key = startX+":"+startY;
        q.add(key);
        lookup.put("-1:-1",new Integer[] {0,-2,-2});
        lookup.put(key,new Integer[] {0,-1,-1});
        int val = traverse(grid, goalX, goalY, q, lookup);
        print_matrix(lookup,grid);
        
        return val; 
         
    } 

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}

