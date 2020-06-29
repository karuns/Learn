package JavaLearn;
import java.util.*;
import java.io.*;
public class UsingScanner {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		//sc.next();
		String s = "";
		for (int i = 0 ; i<n; i++) {
			s += sc.nextLine() + "\n";
			
		}
		//s += sc.nextLine();
		System.out.println(s);
	}

}
