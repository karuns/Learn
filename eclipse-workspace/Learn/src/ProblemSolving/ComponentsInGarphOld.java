package ProblemSolving;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class ComponentsInGarphOld {

    /*
     * Complete the componentsInGraph function below.
     */
    public static int traverse (int count, 
                         int indx, 
                         int sideOfArray,
                         int[][] gb, 
                         HashSet<String> visited) {
        visited.add(gb[indx][0]+":"+gb[indx][1]);
        visited.add(gb[indx][1]+":"+gb[indx][0]);
        //boolean exist = false;
        for (int i = 0 ; i < gb.length; i++) {
            if((i != indx) && !visited.contains(gb[i][0]+":"+gb[i][1])) {
                if (gb[i][sideOfArray] == gb[indx][sideOfArray]) {
                    if(sideOfArray == 1) sideOfArray=0;
                    else sideOfArray =1;
                    count = traverse(count+1, i, sideOfArray, gb, visited);
                } 
            }
        }
        return count;
    }

    public static int[] componentsInGraph(int[][] gb) {
        /*
         * Write your code here.
         */
        HashSet<String> visited = new HashSet();
        Integer max = Integer.MIN_VALUE;
        Integer min = Integer.MAX_VALUE;
        for (int i = 0 ; i<gb.length ; i++) {
            if (!visited.contains(gb[i][0]+":"+gb[i][1])) {
                int num = traverse(2, i, 1, gb, visited);
                num += traverse(0, i, 0, gb, visited);
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
        }
        return new int[]{min, max};
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] gb = new int[n][2];

        for (int gbRowItr = 0; gbRowItr < n; gbRowItr++) {
            String[] gbRowItems = scanner.nextLine().split(" ");

            for (int gbColumnItr = 0; gbColumnItr < 2; gbColumnItr++) {
                int gbItem = Integer.parseInt(gbRowItems[gbColumnItr].trim());
                gb[gbRowItr][gbColumnItr] = gbItem;
            }
        }

        int[] SPACE = componentsInGraph(gb);
        
        for (int SPACEItr = 0; SPACEItr < SPACE.length; SPACEItr++) {
            bufferedWriter.write(String.valueOf(SPACE[SPACEItr]));

            if (SPACEItr != SPACE.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

