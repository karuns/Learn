package ProblemSolving;

public class StepsWays {
	public static int count = 0;
	public static void solveSteps(int [] arr, int n) {
		for(int i=0; i<=arr.length-1; i++) {
			int steps = arr[i];
			if(steps<=n) {
				if(steps == n) {
					count++;
				}
				else {
					solveSteps(arr, n-steps);
				}
			}

		}
	}
	public static void main (String [] args) {
		int[] arr = {1,2,3,5};
		int n = 4;
		solveSteps(arr,n);
		System.out.println(count);
	}

}
