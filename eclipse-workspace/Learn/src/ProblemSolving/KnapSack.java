//https://www.youtube.com/watch?v=xOlhR_2QCXY


package ProblemSolving;
import java.util.*;
public class KnapSack {
	public static int solve(int[][] arr, int i,int total) {
		int num = 0;
		if(i<0) return 0;
		else if(total<0) return 0;
		else if (total > arr[i][0]) {
			num = Math.max(solve(arr, i-1,total),
					arr[i][1]+solve(arr, i-1,total-arr[i][0]));
		}else {
			num = solve(arr, i-1,total);
		}
		return num;
	}
	public static void main(String[] args) {
		
		int [][] arr = {{1,5},{2,3},{4,5},{2,3},{5,2}};
		System.out.println(arr.length);
		System.out.println(solve(arr, arr.length-1,6));
		//HashMap<String, Integer> lookup = new HashMap<String, Integer>();	
		//System.out.println(solve(arr.length,16));
		//System.out.println(solve(arr,lookup,4-1,-9));
	}

}
