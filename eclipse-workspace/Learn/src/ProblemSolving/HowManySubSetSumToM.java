package ProblemSolving;
import java.util.*;
public class HowManySubSetSumToM {
	public static int solve(int [] arr, HashMap<String, Integer>lookup, int i,int total) {
		String key = Integer.toString(i)+":"+Integer.toString(total);
		if(lookup.containsKey(key)) return lookup.get(key);
		{
			if(total==0) return 1;
			else if(i<0 || total < 0) return 0;
			else {
				
				lookup.put(key,solve(arr,lookup,i-1,total) + solve(arr,lookup,i-1,total-arr[i]));
				return lookup.get(key);
			}
		}
	}
	public static void main(String[] args) {
		
		int [] arr = {2,4,6,10};
		HashMap<String, Integer> lookup = new HashMap<String, Integer>();	
		System.out.println(solve(arr,lookup,4-1,16));
		System.out.println(solve(arr,lookup,4-1,-9));
	}

}
