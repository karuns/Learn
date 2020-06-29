package ProblemSolving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CastleRock2{
    static boolean check(String [] grid, int x, int y, HashMap<String,Integer> visited, int depth) {
    	String key = x+":"+y;
    	if(visited.containsKey(key)) {
    		if(visited.get(key)==0) return true;
    		else if(visited.get(key)<=-9 && visited.get(key)*-1 >-9+-1*depth) return true;
    		else return false;
    	}
        else if(x<0 || y<0 || x>grid.length-1 || y>grid.length-1) return false; // Had bug 2
        else return true;
    }

    static ArrayList<Integer[]> getValidMoves(String [] grid, int x, int y, HashMap<String,Integer> visited, int depth) {
        ArrayList<Integer[]> q = new ArrayList();
        if (check(grid, x-1, y, visited, depth)) q.add(new Integer[] {x-1, y});
        if (check(grid, x+1, y, visited, depth)) q.add(new Integer[] {x+1, y});
        if (check(grid, x, y-1, visited, depth)) q.add(new Integer[] {x, y-1});
        if (check(grid, x, y+1, visited, depth)) q.add(new Integer[] {x, y+1});
        return q;
    }

    static int traverse(String [] grid, int x, int y, HashMap<String, Integer> visited, int gx, int gy, int depth) {
    	String key = x+":"+y;
    	if(visited.containsKey(key) && (visited.get(key)>=0)) return visited.get(key);
    	else {
	        // find all the possible moves, relax edges, get the minimum travel  and return that.
            visited.put(key,-9+-1*depth);
            ArrayList<Integer[]> q = getValidMoves(grid, x, y,visited, depth);
            System.out.print("queue for ("+x+","+y+")");
            for(int ii= 0; ii<q.size();ii++)  System.out.print("["+q.get(ii)[0]+","+q.get(ii)[1]+"]" );
            System.out.println("");
            Integer min = Integer.MAX_VALUE;
            if(q.isEmpty()) visited.put(key,-3);
            else {
                for (Integer[] p: q) {
                	int temp = traverse(grid, p[0], p[1], visited, x,y, depth+1);
                	if(temp >=0 ) { 
	            		if((p[0] == gx) || (p[1]==gy))
	                        min = 1+Math.min(min, temp);
	                    else
	                        min = 1+Math.min(min, temp);
                	}
                    
                }
            	
            }
            if(min>=Integer.MAX_VALUE)  visited.put(key,-3);
            else visited.put(key,min);
        
           // System.out.println();
             System.out.println(x+" i:j "+y+" min="+min+" return"+visited.get(key));
             System.out.println("");
            //if(min==Integer.MAX_VALUE || min==Integer.MAX_VALUE+1) {
            //visited.put(key,min);
            return visited.get(key);
        }
    }
    static void print_matrix(HashMap<String,Integer> visited, String [] grid) {
    	Iterator it = visited.keySet().iterator();
    	int [][] arr = new int[grid.length][grid.length];
    	
    	while(it.hasNext()) {
    		String item = (String)it.next();
    		Integer i = Integer.parseInt(item.split(":")[0]);
    		Integer j = Integer.parseInt(item.split(":")[1]);
    		arr[i][j]= visited.get(item);
    	}
    	for(int i = 0;i<grid.length;i++) {
        	for(int j = 0;j<grid.length;j++) {
        		System.out.print(arr[i][j]+ " ");
        	}
    	System.out.println("");}
    	
    }
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY)     {
        HashMap<String,Integer> visited = new HashMap();
        
        for(int i = 0;i<grid.length;i++)
        	for(int j = 0;j<grid.length;j++) {
        		String key = i+":"+j;
        		if(grid[i].charAt(j)=='X') visited.put(key, -1);
        	}
		visited.put(startX+":"+startY, -2);
		visited.put(goalX+":"+goalY, 0);
	
        if(startX==goalX && startY==goalY) return 0;
        else {
            int val = traverse(grid, startX, startY, visited, -1, -1,0);
            print_matrix(visited, grid);
            if (val >=Integer.MAX_VALUE)
                return -1;
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

