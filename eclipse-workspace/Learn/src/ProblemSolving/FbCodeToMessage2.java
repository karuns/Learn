package ProblemSolving;
//https://www.youtube.com/watch?v=qli-JCrSwuk

import java.util.*;

public class FbCodeToMessage2 {
	public static int count = 0;
	public static HashMap<String, Character> hs = new HashMap<String, Character>();
	
	public static Character solveMessage(String s) {
		for(int i=0; (i<2)&&(s!=null)&&(i<s.length());i++) {
			String s1 = s.substring(0,i+1);
			if(hs.containsKey(s1)) {
				if(i+1 == s.length()) {
					count++;
					return hs.get(s1);
				} 
				else {
					solveMessage(s.substring(i+1));
				}
			}
		}
	return null;
	}
	public static void main (String [] args) {
		String s = "12";
		// Initialize set
		hs.put("1",'a');
		hs.put("2",'b');
		hs.put("3",'c');
		hs.put("4",'d');
		hs.put("5",'e');
		hs.put("6",'f');
		hs.put("7",'g');
		hs.put("8",'h');
		hs.put("9",'i');
		hs.put("10",'j');
		hs.put("11",'k');
		hs.put("12",'l');
		hs.put("13",'m');
		hs.put("14",'n');
		hs.put("15",'o');
		hs.put("16",'p');
		hs.put("17",'q');
		hs.put("18",'r');
		hs.put("19",'s');
		hs.put("20",'t');
		hs.put("21",'u');
		hs.put("22",'v');
		hs.put("23",'w');
		hs.put("24",'x');
		hs.put("25",'y');
		hs.put("26",'z');
	
		solveMessage(s);
		System.out.println(count);
	}
}
