package ProblemSolving;

public class FbAllSubSet {
	public static int count = 0;
	public static void solveAllSubSet(int [] arr, int i, String s) {
		int n = arr.length-1;
		if(i==n) {
			System.out.println(s);
			System.out.println(s+","+arr[i]);
		} else if(i<n) {
			solveAllSubSet(arr,i+1,s+","+arr[i]);
			solveAllSubSet(arr,i+1,s);
		}
	}
	public static void main (String [] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		solveAllSubSet(arr,0,"_");
	}
}
