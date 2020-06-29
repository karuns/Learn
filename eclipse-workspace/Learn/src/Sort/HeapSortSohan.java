//https://www.youtube.com/watch?v=HqPJF2L5h9U
package Sort;

public class HeapSortSohan {

	public static int [] arr = {10,16,8,12,15,6,3,9,5};
	
	public static void swap(int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j]= temp;
	}
	
	public static void adjustHeap(int i, int j) {	
		int index = biggestindex(i,j);
		if (index==i) return;
		else {
			swap(i,index);
			adjustHeap(index,j);
		}
	}
	
	public static void adjustHeapFromBottom(int i) {
		if(i/2 >0){
			if(arr[i]>arr[i/2]) {
				swap(i,i/2);
				adjustHeapFromBottom(i/2);
			}
		}
	}
	
	public static void heapify(int end) {
		for (int i = end; i>=0 ;i--) {
			adjustHeap(i, end);
		}
	}
	
	public static int biggestindex(int i, int j) {
		int index = i;
		
		if(2*i > j) return i;
		if(2*i+1 >j) {
			if(arr[2*i]>arr[i]) {
				return 2*i;
			}
		}else {
			if(arr[2*i]>arr[2*i+1]) {
				index = 2*i;
			}
			else index = 2*i+1;
			
			if(arr[i]>arr[index]) index=i;
		}
		return index;
		
	}
	
	public static void main (String[] args) {
		System.out.println("Hello world");
		for(int i =0 ; i<arr.length-1;i++) {
			adjustHeapFromBottom(i);
		}
		
		//heapify(arr.length-1); //Heapify takes log N time however above n;
		
		int j = arr.length-1;
		while(j!=0) {
			swap(0,j);
			j--;
			adjustHeap(0,j);
		}
		for(int i = 0; i<arr.length-1;i++) {
			System.out.println(arr[i]);
		}
		
	}
}
