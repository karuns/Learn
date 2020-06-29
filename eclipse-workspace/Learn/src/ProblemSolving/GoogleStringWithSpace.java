package ProblemSolving;
//Break string with no space to space 

/* s = “HelloWorld”;
* out => Hello World
* s = “Thisisgreat”
*/

//Assumption, all the key are present i.e there is no typo and grammatical it is correct string. Special conditon for single keyword compsition etc the, etc
//Approach: There has to be a HashSet with all the possible keywords
//stat from 0 indek keep incrasing found key, put that key i

import java.util.*;
public class GoogleStringWithSpace {
	public static HashSet <String> hs = new HashSet<String>();
	public static int  findKeywordEndIndex(String s){
	int i = 0;
	for (i=0;i<s.length();i++){
		if(hs.contains(s.substring(0,i))) {
			break;
		}
	}
	return i;
}
	public static String printStringWithSpaces(String s) {
		String str = "";
		int i = findKeywordEndIndex(s); // for s return the end index starting from 0
		System.out.println(i);
        if(i==s.length()) {  //last match
                     		str = s;
               
		}else{
			str = s.substring(0,i)+" "+printStringWithSpaces(s.substring(i));
                     }
		return str;
}
	public static void main(String [] args){
		//construct assuming set 
		hs.add("This");
		hs.add("is");
		hs.add("Hello");
		hs.add("Great");
		hs.add("World");
        System.out.println(printStringWithSpaces("HelloWorld"));
        System.out.println(printStringWithSpaces("ThisisGreat"));
}
} 
