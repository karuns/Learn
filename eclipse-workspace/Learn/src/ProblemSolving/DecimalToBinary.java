package ProblemSolving;
import java.math.*;

public class DecimalToBinary {
	// 3:19
	public static String decimalToBinary(int val) {
		String out = "";
		while(val > 1) {
			out = Integer.toString(val % 2) + out;
			val /= 2;
		}
		out = Integer.toString(val) + out;
		return out;
	}

	public static void main(String[] argos){
		System.out.println(decimalToBinary(43));
	}
}

