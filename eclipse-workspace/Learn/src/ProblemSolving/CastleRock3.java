package ProblemSolving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CastleRock3{
	// create hash map with start as -2, everything else as integer max and goal as 0 value. put -1 for all the x.
	// start from goal and find all the possible moves (within the range,value !=-1, and new value smaller than existing (except for less than -2)
	// for each cell 
	// if value != -2 then get the minimum
	// do the same things
    static boolean check(String [] grid, int x, int y, int pVal, HashMap<String,Integer> visited) {
    	String key = x+":"+y;
    	if(x<0 || y<0 || x>grid.length-1 || y>grid.length-1) return false;
    	else if (visited.containsKey(key)) {
    		if(visited.get(key)==-1||visited.get(key)==0) return false;
    		else if(visited.get(key)<=-2) return true;
    		else if(visited.get(key)>pVal+1) return true;
    		else return false;
    	}
        else return true;
    }

    static ArrayList<Integer[]> getValidMoves(String [] grid, int x, int y, HashMap<String,Integer> visited, int pVal) {
        ArrayList<Integer[]> q = new ArrayList();
        
        if (check(grid, x-1, y, pVal, visited )) q.add(new Integer[] {x-1, y});
        if (check(grid, x+1, y, pVal, visited )) q.add(new Integer[] {x+1, y});
        if (check(grid, x, y-1, pVal, visited )) q.add(new Integer[] {x, y-1});
        if (check(grid, x, y+1, pVal, visited )) q.add(new Integer[] {x, y+1});
        return q;
    }
    

    static void traverse(String [] grid, int x, int y, HashMap<String, Integer> visited, int gx, int gy, int pVal) {
    	ArrayList<Integer[]> q = getValidMoves(grid, x, y,visited, pVal);
    	for (Integer[] p: q) {   
    		String key = p[0]+":"+p[1];
    		int val = visited.get(key);
    		int tVal = pVal;
    		if((p[0] != gx) && (p[1]!=gy)) // relaxing row
    			tVal++;
    		
    		if(val>-2) {
    			visited.put(key, tVal);
    			traverse(grid, p[0], p[1], visited, x,y,tVal);
    			
    		}else if (val == -2) {
    			tVal= tVal*-1+-2;
    			visited.put(key, tVal);
    		}else {
    			int tempVal = (val+2)*-1;
    			tVal = Math.min(tVal,tempVal)*-1+-2;
    			visited.put(key, tVal);
    			//System.out.println("tempval="+tempVal);
    		}
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
        		if(grid[i].charAt(j)=='X')
        			visited.put(key, -1);
        		else 
        			visited.put(key, Integer.MAX_VALUE);
        	}
		visited.put(startX+":"+startY, -2);
		visited.put(goalX+":"+goalY, 0);
		
		
        if(startX==goalX && startY==goalY) return 0;
        else {
        	traverse(grid, goalX, goalY, visited, -1, -1, 0);
            print_matrix(visited, grid);
            
        }
        return (visited.get(startX+":"+startY)+2)*-1;
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

