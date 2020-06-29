package ProblemSolving;

public class FindMinMaxCycle {

    static int traverse (int count, 
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

static int[] componentsInGraph(int[][] gb) {
/*
* Write your code here.
*/
HashSet<String> visited = new HashSet();
Integer max = Integer.MIN_VALUE;
Integer min = Integer.MAX_VALUE;
for (int i = 0 ; i<gb.length ; i++) {
if (!visited.contains(gb[i][0]+":"+gb[i][1])) {
   int num = traverse(2, i, 1, gb, visited);
   min = Math.min(min, num);
   max = Math.max(max, num);
}
}
return new int[]{min, max};
}
}
