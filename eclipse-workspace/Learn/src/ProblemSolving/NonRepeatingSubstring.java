package ProblemSolving;

import java.util.HashSet;

public class NonRepeatingSubstring {
	public static boolean isSubstringNonRepeatingChar(String s) {
		HashSet<Character> set = new HashSet();
		char[] c = s.toCharArray();
		for(int i = 0; i<c.length; i++) {
			if(set.contains(c[i]))
				return false;
			else
				set.add(c[i]);
		}
		return true;
	}
	public static boolean foundOneNonRepeat(String s, int length) {
		int n = s.length();
		//boolean found = false;
		for(int i = 0; i + length < n; i++) {
			int j = i + length;
			if(isSubstringNonRepeatingChar(s.substring(i, j+1))) {
				//found = true;
				//break;
				return true;
			}
		}
		return false;
	}
	
	public static long solve (String s) {
		if(s == "") return 0;
		int n = s.length();
		int low = 0;
		int high = n - 1;
		
		while(low < high) {
			int length = (low + high) / 2;
			if(length == low) length = high;
			if(foundOneNonRepeat(s, length))
				low = length;
			else
				high = length - 1 ;
			
			System.out.println(low+" : "+high);
		}
		
		return low+1;
	}
	public static void main(String[] args) {
		String s = "sssssssdfwwryyyyusdffghgjdgskdlg';/kd'gs;kldsngd'skgmds'mdf'mf;hnf;khfmnkhmf;kndk;dngd'ngd;gnd;gnd;gjnd;jndndndjnd.dg;dngdn;d";
		System.out.println(solve(s));
	}

}