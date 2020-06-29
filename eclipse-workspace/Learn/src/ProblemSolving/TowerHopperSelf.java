package ProblemSolving;

public class TowerHopperSelf {
	public static Boolean isTowerHoppable(int[] arr, Boolean[] lookup, int n) {
		if(lookup[n]!=null) return lookup[n];
		else {
			Boolean bFound = false;
			for(int i=n+1;((i<=n+arr[n]) && !bFound);i++) {
				if (lookup[i] == null) {
					lookup[i] = isTowerHoppable(arr, lookup, i);
				}
				bFound = bFound || lookup[i];
			}
			lookup[n] = bFound;
			return bFound;
		}
	}
	public static void main(String[] args) {
		//int [] arr = {4,2,0,0,2,0};
		int [] arr = {1,3,5,3,1};
		//int [] arr = {4,2,0,0,2,0};
		//int [] arr = {4,2,0,0,2,0};
		
		Boolean [] lookup = new Boolean[arr.length+1];
		for (int i = 0;i<lookup.length;i++) lookup[i] = null;
		lookup[arr.length-1] = true;
		System.out.println(isTowerHoppable(arr,lookup, 0));
	}
}
