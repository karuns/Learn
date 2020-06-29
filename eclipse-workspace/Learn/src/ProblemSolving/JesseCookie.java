package ProblemSolving;



import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class JesseCookie {

    /*
     * Complete the cookies function below.
     */
    static void swap(int [] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

//    static void heapifyUp(int [] A, int i, int n) {
//        if(n>0){
//        //int n = A.length-1;
//        int c1 = 2*i+1;
//        int c2 = 2*i+2;
//        int smallest = i;
//        if((c1 <=n ) && (A[c1] < A[smallest])) smallest = c1;
//        if((c2 <=n ) && (A[c2] < A[smallest])) smallest = c2;
//            if(i!=smallest) {
//            	swap(A, i, smallest) ;
//            	heapifyUp(A, smallest, n);
//            }
//        }
//    }

    static void heapifyDown(int [] A, int i, int n) {
        if((n>0) &&(i<=n)){
            int c1 = 2*i+1;
            int c2 = 2*i+2;
            int smallest = i;
            if((c1 <=n ) && (A[c1] < A[smallest])) smallest = c1;
            if((c2 <=n ) && (A[c2] < A[smallest])) smallest = c2;
            if(i!=smallest){
                swap(A, i, smallest);
                heapifyDown(A, smallest,n);
            }
        }
    }
    static void createHeap(int [] A) {
        for(int i = A.length/2-1; i>=0; i--)
            heapifyDown(A, i, A.length-1);
    }

    static void heapifyUpOnAdd(int [] A, int i, int n) {
        if((n>0) &&(i>0)){
            int p = (i-1)/2;
            if(A[p] > A[i]) {
                swap(A, p, i) ;
                heapifyUpOnAdd(A, p, n);
            }
        }
    }

    static void pushHeap(int [] A, int newItem, int lastIndex) {
        A[lastIndex+1] = newItem;
        heapifyUpOnAdd(A, lastIndex+1,lastIndex+1);
    }

    static int  popHeap(int [] A, int n) {
        if(n < 0) return -1;
        else {
            swap(A, 0, n);
            heapifyDown(A, 0,n-1);
            return A[n];
        }
    }

    static int cookies (int k, int [] A) {
        createHeap(A);
        int lastIndex = A.length-1;
        int min1=0, min2=0, count = 0;
        while ((lastIndex >= 1) && (A[0] < k)){
            min1 = popHeap(A, lastIndex);       
            lastIndex--;
            min2 = popHeap(A, lastIndex);
            lastIndex--;
            pushHeap(A, min1+2*min2, lastIndex);
            lastIndex++;
            count++;
        }

        if(A[0] >= k) return count;
        else return -1;
    }
    
    static void  sort (int [] A) {
        createHeap(A);
        int lastIndex = A.length-1;
        for(int i = 0 ; i<A.length ;i++) 
        {
        	System.out.println(popHeap(A, lastIndex));       
            lastIndex--;
            //pushHeap(A, min1+2*min2, lastIndex);
//          lastIndex++;
        }
        
//            pushHeap(A, min1+2*min2, lastIndex);
//            lastIndex++;
//            count++;
//        }

//        if(A[0] >= k) return count;
//        else return -1;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);
        System.out.println(result);
//        for(int i = 0; i<A.length; i++) System.out.println(A[i]+ " ");
        //sort(A);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();
        Character c = 'a';
       

    }
}

