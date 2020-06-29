package ProblemSolving;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MergingCommunities {
    static int getSize(int i,int [] nw, int [] size ) {
        return size[nw[i]];
    }
    static void merge(int personI, int personJ, int [] nw, int [] size) {
        int n = nw.length;
        if(nw[personI] != nw[personJ]){
            // Optimize by merge small into big.


            //update size
            size[nw[personI]] += size[nw[personJ]];
            size[nw[personJ]] = 0;

            //update commmunity for J and all them meber of J's community.

            int oldC = nw[personJ];
            for (int i = 1; i<n ; i++) 
                if(nw[i] == oldC) nw[i] = nw[personI];
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // 11:48
        //get input
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        in.nextLine();
        
        int [] nw = new int[n+1];
        int [] size = new int[n+1];

        // Initialize comminuty and size
        for (int i = 0; i<n ; i++) {
            nw[i] = i;
            size[i] = 1;
        }

        //getting input and computing.
        for (int i = 0 ; i<q; i++) {
            String [] qArr = in.nextLine().split(" ");
            if (qArr.length ==3)
                merge(Integer.parseInt(qArr[1]), Integer.parseInt(qArr[2]), nw, size);
                //System.out.println(qArr[0]+qArr[1]+qArr[2]);
            else
                System.out.println(getSize(Integer.parseInt(qArr[1]), nw, size));
                //System.out.println(qArr[0]+qArr[1]);
        }
    }
}

