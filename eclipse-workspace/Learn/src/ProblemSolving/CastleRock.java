package ProblemSolving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CastleRock{
    static boolean check(String [] grid, int x, int y, int xx, int yy, HashMap<String,Integer> visited) {
        if (visited.containsKey(x+":"+y)) return false;
        else if(x<0 || y<0 || x>grid.length-1 || y>grid.length-1) return false; // Had bug 2
        else if(grid[x].charAt(y) == 'X') return false; //// Had bug
        else return true;
    }

    static Queue<Integer[]> getValidMoves(String [] grid, int x, int y, int xx, int yy, HashMap<String,Integer> visited) {
        Queue<Integer[]> q = new LinkedList();
        if (check(grid, x-1, y, xx, yy, visited)) q.add(new Integer[] {x-1, y});
        if (check(grid, x+1, y, xx, yy, visited)) q.add(new Integer[] {x+1, y});
        if (check(grid, x, y-1, xx, yy, visited)) q.add(new Integer[] {x, y-1});
        if (check(grid, x, y+1, xx, yy, visited)) q.add(new Integer[] {x, y+1});
        return q;
    }

    static int traverse(String [] grid, int x, int y, int xx, int yy, HashMap<String, Integer> visited, int gx, int gy) {
    	String key = x+":"+y;
    	if(visited.containsKey(key)) return visited.get(key);
    	else {
	        // find all the possible moves, relax edges, get the minimum travel  and return that.
	        if(x==xx && y ==yy) return 0;
	        else{
	            visited.put(key,Integer.MAX_VALUE);
	            Queue<Integer[]> q = getValidMoves(grid, x, y, xx, yy, visited);
	            Integer min = Integer.MAX_VALUE;
	            for (Integer[] p: q) {
	            	
	                if((p[0] == gx) || (p[1]==gy))
	                    min = Math.min(min, traverse(grid, p[0], p[1], xx, yy, visited, x,y));
	                else
	                    min = 1+Math.min(min, traverse(grid, p[0], p[1], xx, yy, visited, x,y));
	            }
	            System.out.println(min);
	            if(min<0) System.out.println(x+" i:j "+y+" min="+min);
	            //if(min==Integer.MAX_VALUE || min==Integer.MAX_VALUE+1) {
	            visited.put(key,min);
	            return min;
	        }
        }
    }

    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY)     {
        HashMap<String,Integer> visited = new HashMap();
        //int [][] dp = new int[grid.length+1][grid.length+1];
//        for(int i = 0;i<grid.length+1;i++)
//        	for(int j = 0;j<grid.length+1;j++) dp[i][j] = -1;
//        
        if(startX==goalX && startY==goalY) return 0;
        else {
            int val = traverse(grid, startX, startY, goalX, goalY, visited, -1, -1);
            if (val ==Integer.MAX_VALUE)
                return 0;
            else return val;
        }
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

