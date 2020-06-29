package JavaLearn;

/* Learning: in case of try and catch block. code will run either try or catch code and then can continue as it normally to rest of the code block. 
 * In case of catch user  can get details of exception. 
 * 
 */

public class TryCatchandThrows {
	
	static String formatExceptuon(String s) {
		return "{"+s+"}";
	}
	public static void main(String [] args) {
		
		
		int [] arr = {2,5};
		
		try {
			System.out.println(arr[1]);
			System.out.println("Inside try block no exception");
			throw new ArithmeticException("Custome Exception");
		
		}
		catch(Exception s) {
			System.out.println("Inside catch block after exception");
			System.out.println(formatExceptuon(s.toString()));
			throw new ArithmeticException("Custome Exception");
			
		}
		finally {
			System.out.println("Inside finally block");
		}
		//System.out.println("Code block after exception");
//		if(2<3) {
//			throw new ArithmeticException("Custome Exception");
//	
//		}
		//System.out.println("End of code");
	}
}
