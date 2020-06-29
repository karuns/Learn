package Sort;

public class MergeSort{
	public static void merge(int l, int m, int h, int [] arr) {
		int [] lArray = new int [m-l+1];
		int [] rArray = new int [h-(m+1)+1];
		
		// Copy elemts to respective arrays
		for(int i=0;i<=m-l ;i++) lArray[i] = arr[l+i];
		for(int i=0;i<=h-(m+1) ;i++) rArray[i] = arr[m+1+i];
		
		int la = 0;
		int ra = 0;
		while((la<lArray.length)&&(ra<rArray.length)) {
			if(lArray[la]<rArray[ra]) arr[l++] = lArray[la++];
			else  arr[l++] = rArray[ra++];		
		}
		//remaining from left and right array 
		while(la<lArray.length) arr[l++] = lArray[la++];
		while(ra<rArray.length) arr[l++] = rArray[ra++];
	}
	
	public static void mergeSort(int l, int h, int[] arr) {
		if(l<h) {
			int m = (l+h)/2;
			mergeSort(l,m,arr);
			mergeSort(m+1,h, arr);
			merge(l,m,h,arr);
		}
	}
	
	public static void main (String[]  args) {
		int [] arr = {9,3,7,5,6,4,8,2};
		mergeSort(0,arr.length-1, arr);
		for(int i = 0 ; i<arr.length;i++) System.out.println(arr[i]);
	}
}

