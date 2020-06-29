package coding;
import java.util.*;

public class Eval{
	static Stack<Character> oprtr = new <Character> Stack();
	static Stack<Double> oprnd = new <Double> Stack();
	
	public static int priority(Character c) {
		if ((c == '+')||(c == '-')) return 1;
		if ((c == '*')||(c == '/')) return 2;
		if (c == '^') return 3;
		return 1;
	}
	public static Double compute(Double b, Double a, Character c) {
		if (c == '+') return a+b;
		if (c == '-') return a-b;
		if (c == '*') return a*b;
		if (c == '/') return a/b;
		if (c == '^') return Math.pow(a, b);
		return null;
		
	}

	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		String in = scan.next();
		System.out.println(in);
		scan.close();
		
		for(int i = 0; i<in.length();i++) {
			Character c = in.charAt(i);
			if (Character.isDigit(c)) {
				oprnd.push(Double.parseDouble(Character.toString(c)));
			}else {
				if (oprtr.isEmpty()) {
					oprtr.push(c);
				}
				else {
					if (priority(c)>priority(oprtr.peek())){
						oprtr.push(c);
					}else {
						while ((!oprtr.isEmpty())&& (priority(c)<=priority(oprtr.peek()))){
							oprnd.push(
									compute(oprnd.pop(),oprnd.pop(),oprtr.pop()));
						}
						oprtr.push(c);
					
					}
				}
			}
			
		}
		
		while (!oprtr.isEmpty()){
			oprnd.push(
					compute(oprnd.pop(),oprnd.pop(),oprtr.pop()));
		}
		System.out.println(oprnd.peek());
	}
}