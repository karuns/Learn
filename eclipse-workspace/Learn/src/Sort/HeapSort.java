//https://www.youtube.com/watch?v=HqPJF2L5h9U
package Sort;

public class HeapSort {
	public static void adjustHeap(int[] arr, int i, int n) {
		int largest = i;
		int l = 2*i;
		int r = 2*i+1;
		if((l<=n)&& (arr[l]>arr[largest])) largest = l;
		if((r<=n)&& (arr[r]>arr[largest])) largest = r;
		if(largest !=i) {
			swap(arr,largest, i);
			adjustHeap(arr, largest,n);
		}
	}
	
	public static void swap (int []arr, int i, int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String[] args) {
		int [] arr = {10,16,8,12,15,6,3,9,5};
		//int [] arr = {1};
		
		int n = arr.length-1;
		
		// Initial Heap
		for(int i = n/2; i>=0; i--) {
			adjustHeap(arr,i,n);
		}
		
		// Swap and adjust
		while(n>0) {
			swap(arr,n,0);
			adjustHeap(arr,0,--n);
		}
		for(int i =0; i<=arr.length-1;i++) {
			System.out.println(arr[i]);
		}
	}
}
