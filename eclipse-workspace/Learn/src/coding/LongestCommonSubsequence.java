package coding;

public class LongestCommonSubsequence {
	
	public static char [] A = {'b','d'};
	public static char [] B = {'a','b','c','d'};
	
	public static String traverseAndFindSequence(int[][] arr, int i, int j) {
		// last index
		String ret = "";
		while(i!=0 && j!=0) {
			int cur = arr[i][j];
			int rowUp = arr[i-1][j];
			int colUp = arr[i][j-1];
			int up = arr[i-1][j-1];
			if (cur == colUp) j=j-1;
			else if (cur == rowUp) i=i-1;
			else {
				i=i-1;
				j=j-1;
				ret = B[j]+ret;
			}
		}
		return ret;
	}
	
	public static void printArr(int[][] arr) {
		for (int i = 0;i<arr.length;i++) {
			for (int j = 0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
	
	public static void fillArr(int[][] arr) {
		for (int i = 0;i<arr.length;i++) {
			for (int j = 0;j<arr[0].length;j++) {
				if(i==0 ||j==0) arr[i][j] = 0;
				else {
					if(A[i-1]==B[j-1]) arr[i][j] = arr[i-1][j-1]+1;
					else {
						arr[i][j] = Math.max(arr[i-1][j],arr[i][j-1]);
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		int [][]arr = new int[A.length+1][B.length+1];
		//System.out.println(arr[0].length-1);
		int i = arr.length-1;
		int j = arr[0].length-1;
		fillArr(arr);
		//printArr(arr);

		System.out.println(traverseAndFindSequence(arr,i,j));
	}
}
