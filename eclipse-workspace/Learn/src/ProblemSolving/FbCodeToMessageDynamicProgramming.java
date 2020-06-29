package ProblemSolving;
//https://www.youtube.com/watch?v=qli-JCrSwuk

import java.util.*;

public class FbCodeToMessageDynamicProgramming {
	public static int count = 0;
	public static HashMap<String, Character> hs = new HashMap<String, Character>();
	
	//Start with last k items
	public static Integer solveMessage(String s, int k, int [] lookup) {
		int n = s.length();
		int num = Integer.parseInt(Character.toString(s.charAt(n-k)));
		if (k <= 0) return 0;
		if(lookup[k]!=-1) return lookup[k];

		if(k == 1) {
			if(num == 0) lookup[k] = 0;
			else lookup[k] = 1;
			return lookup[k]; 
		} else if(k==2) {
			int num2 = Integer.parseInt(s.substring(n-k,n-1));
			if(num ==0) lookup[k] = 0;
			else if(num2>26) lookup[k] = 0;
			else lookup[k] = 1+solveMessage(s, k-1, lookup);
		} else
			lookup[k] = solveMessage(s, k-1, lookup)+solveMessage(s, k-2, lookup);
		return lookup[k];
	}
	
	
	public static void main (String [] args) {
		String s = "1231212234";
		int [] lookup = new int[s.length()+1];
		for (int i = 0; i<lookup.length ;i++) {
			lookup[i] =-1;
		}		
		solveMessage(s,s.length(),lookup);
		System.out.println(lookup[s.length()]);
	}
}
