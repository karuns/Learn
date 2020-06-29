package DataStructure;
import java.util.*;
public class BinaryToDecimal {
	// 5:36
	public static void main (String[] args) {
		String binary = "101011";
		Integer total = 0;
		int n = binary.length();
		
		for(int i = 0; i< n ; i++) {
			total = (int) (total+ Math.pow(2, i) * (binary.charAt(n-1-i) -'0')) ; 
		}
		System.out.println(total);
	}

}
