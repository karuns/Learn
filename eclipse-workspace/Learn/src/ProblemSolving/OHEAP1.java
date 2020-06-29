package ProblemSolving;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class OHEAP1 {
    public static void swap(ArrayList<Long> heap, int ii, int j){
        for(int i = 0 ; i<heap.size(); i++) System.out.print(heap.get(i)+ " ");
        System.out.println("Before");
        
        long temp = heap.get(ii);
        heap.set(ii, heap.get(j));
        heap.set(j, temp);
        for(int i = 0 ; i<heap.size(); i++) System.out.print(heap.get(i)+ " ");
        System.out.println("After");
        
    }
    public static void heapifyUp(ArrayList<Long> heap , int size) {
        System.out.println(heap+":" +size);
        int n = size -1;
        int p = (n-1)/2;
        int s = p*2+1;
        if(p>=0) {
            int smallest = p;
            if((s<=n) && (heap.get(s)<heap.get(smallest))) smallest = s;
            if(heap.get(n)<heap.get(smallest)) smallest = n;
            //System.out.println(p+":" +smallest);
            if (p!=smallest){
                swap(heap, smallest, p);
                heapifyUp(heap, p);
            }
        }
    }

    public static void heapifyDown(ArrayList<Long> heap , int i,  int size) {
        int n = size -1;
        int s1 = 2*i+1;
        int s2 = 2*i+2;
        int smallest = i;
        if(s1 <=n && heap.get(s1)<heap.get(smallest)) smallest = s1;
        if(s2 <=n && heap.get(s2)<heap.get(smallest)) smallest = s2;
        if (i!=smallest){
            swap(heap, smallest, i);
            heapifyDown(heap, smallest, size);
        }
    }

    public static  int normalizeDel(ArrayList<Long> heap , int size, long val,  HashSet<Long> deleted ){
        while(!heap.isEmpty() && deleted.contains(heap.get(0))){
            deleted.remove(heap.get(0));
            swap(heap, 0, size-1);
            size--;
            heapifyDown(heap, 0, size);
        }
        return size;
    }

    public static  int insert(ArrayList<Long> heap , int size, long val,  HashSet<Long> deleted ){
        //Maintaining delete set
        if (deleted.contains(val)) deleted.remove(val);
        
        heap.add(size, val);
        System.out.println("Added:"+ val+" at "+ size+ "Heap="+heap);
        size++;
        heapifyUp(heap, size);
        // remove deleted items from top; reduce size an
        size = normalizeDel(heap, size, val, deleted);
        return size;
    }

    public static  int remove(ArrayList<Long> heap , int size, long val,  HashSet<Long> deleted ){
        if(!deleted.contains(val)) {
            deleted.add(val);
            size = normalizeDel(heap, size, val, deleted);
        }
    return size;

    }
    public static long getTop(ArrayList<Long> heap , int size){
        if(size !=0) return heap.get(0);
        else return 0;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in) ;
        int size = 0;
        ArrayList<Long> heap = new ArrayList();
        HashSet<Long> deleted = new HashSet();
        int n = in.nextInt();
        
        for (int i = 0 ; i< n ; i++) {
            in.nextLine();
            int qType = in.nextInt();
            switch (qType) {
                case 1: size = insert(heap, size, in.nextLong(), deleted);
                    break;
                case 2: size = remove(heap, size, in.nextLong(), deleted);
                    break;
                case 3:System.out.println(getTop(heap, size));
            }
        }
    }
}


