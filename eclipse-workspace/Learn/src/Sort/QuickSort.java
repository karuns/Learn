package Sort;

public class QuickSort {
	public static int [] arr = {10,16,8,12,15,6,3,9,5}; 
	
	public static int partition(int l, int h) {
		int i = l;
		int j = h;
		int p = arr[l];
		while(i<j){
			while((arr[i]<=p)&&(i<=j)) i++;
			while((arr[j]>=p)&&(i<=j)) j--;
			if(i<j) swap(i,j);
		}
		swap(l,j); //pivot change
		return j;
	}
	public static void swap(int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j]= temp;
	}
	public static void quickSort(int l,int h) {
		if(l<h) {
			int p = partition(l,h);
			quickSort(l,p-1);
			quickSort(p+1,h);
		}
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Quick Sort");
		quickSort(0,arr.length-1);
		
		for(int i = 0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

}
