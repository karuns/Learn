package DataStructure;

//2:45, 12:56

public class BinarySearch {
	static boolean binarySearchR(int [] arr, int l, int h, int key){
		if(l<=h) {
			int mid = (l+h)/2;
			if(key == arr[mid]) return true;
			else if(key<arr[mid]) return binarySearchR(arr, l, mid-1, key);
			else return binarySearchR(arr, mid+1, h, key);
		}
		else return false;
		
	}
	static boolean binarySearch(int [] arr, int key) {
		int l = 0, h = arr.length-1;
		while(l<=h) {
			int mid = (l+h)/2;
			if(key==arr[mid]) return true;
			else if (key>arr[mid]) l = mid+1;
			else h = mid - 1;
		}
		return false;
	}
	public static void main(String [] args) {
		int [] arr = {3,6,8,12,14,17,25,29,31,36,42,47,53,55,62};
		
		System.out.println(binarySearch(arr,42));
		System.out.println(binarySearch(arr,43));
		System.out.println(binarySearchR(arr,0, arr.length-1, 42));
		System.out.println(binarySearchR(arr,0, arr.length-1, 43));
		
	}

}
