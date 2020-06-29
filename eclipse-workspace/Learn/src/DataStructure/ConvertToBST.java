package DataStructure;
import java.util.*;

public class ConvertToBST {
	
    public static HashSet<Integer> visited = new HashSet();
	public static int i = 0;
	public static int swaps = 0;
	
	public static void swap(int [] arr, int  i, int index) {
		int t = arr[i];
		arr[i] = arr[index];
		arr[index] = t;
	}
	
	public static void convertToBST(int [] arr, int index) {
	if (index <arr.length) {
		convertToBST(arr, 2*index+1);
		if((i != index) &&(!visited.contains(i)))  {
			swap(arr, i, index);
			System.out.println(index+":"+i);
			
//			for (int i = 0; i<arr.length;i++) System.out.print(arr[i]+" ");
//			swaps++;
		}
		visited.add(index);
		i++;
		convertToBST(arr, 2*index+2);
    }
}

	public static void main (String [] args) {
	int [] arr = {5,6,7,8,9,10,11};
	convertToBST(arr, 0);
	System.out.println(swaps);
	for (int i = 0; i<arr.length;i++) System.out.println(arr[i]);
	System.out.println(visited);
	
	
}
}

