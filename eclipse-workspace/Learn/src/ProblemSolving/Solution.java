package ProblemSolving;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);
    public static void rotateR(int [] arr, int r) {
        int n = arr.length;
    for(int i = 0; i<r ;i++) {
        int temp = arr[n-1];
        for(int j = n-2; j>=0 ;j--) arr[j+1] = arr[j];    
        arr[0] = temp;
        }
    }
    public static void rotateL(int [] arr, int r) {
        int n = arr.length;
    for(int i = 0; i<r ;i++) {
        int temp = arr[0];
        for(int j = 1; j<n ;j++) arr[j-1] = arr[j];    
        arr[n-1] = temp;
        }
    }

    public static void rotateRight(int [] arr, int r) {
    	if(r > 0) {
	        int n = arr.length;
	        //int newR = Math.floorMod(r, n);
	        if(r>n) r =  r % n;
	        if (r<n/2) rotateL(arr, r );
	        else rotateR(arr, n-r);
    	}
    }

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        rotateRight(a,d);
        for (int i = 0; i < n; i++) System.out.print(a[i]);
        scanner.close();
    }
}

