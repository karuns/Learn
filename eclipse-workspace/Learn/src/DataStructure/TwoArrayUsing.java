package DataStructure;
import java.util.*;
public class TwoArrayUsing {

	public static void main(String[] args) {
		int[] a = new int[]{1,3};
		int [] b = new int[]{2};
		TwoArrayDS tad = new TwoArrayDS(a, b);
		double totalElements =  a.length + b.length;
		System.out.println((int) Math.floor(totalElements/2));
		int medIndex = ((int) Math.ceil(totalElements/2))-1;
		System.out.println(medIndex);
		float val;
		
		do {
			val = tad.getNextSmallest();
			//System.out.println(val);
			medIndex--;
		}while (medIndex >= 0);
		
		if(totalElements % 2 == 0)
			val = (val + tad.getNextSmallest())/2;
		System.out.println("Median = "+ val);
		
	}
}
