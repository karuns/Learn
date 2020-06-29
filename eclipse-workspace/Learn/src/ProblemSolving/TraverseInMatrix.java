package ProblemSolving;
import java.util.*;
import DataStructure.Pair;

//Traverse in Matrix (6:28) 35 minutes
/*
[0, 0, -1, -2
-3,-1,0,  0
0, -1, 0, 0
0, 0, 0, 0]
*/
public class TraverseInMatrix {
	public static int [][] arr = {{0, 0, -1, -2}, {-3,-1,0,  0},{0, -1, 0, 0},{0, 0, 0, 0} };
	public static boolean foundExit = false;
	public static void printMatrix() {
		int maxI = arr.length-1;
		int maxJ =arr[0].length-1;
		for (int i = 0; i< arr.length; i++) {
			for (int j = 0; j< arr[0].length; j++) {
				System.out.print(arr[i][j]+"");
			}
			System.out.println("");
		}
	}
	
	public static void traverse(int i, int j) {
		findBackMoves(i,j);
		
	}

	
	public static boolean satisfyBack(int i, int j) {
		int maxI = arr.length-1;
		int maxJ =arr[0].length-1;
		if ((i<=maxI) && (i>=0)&&(j<=maxJ) && (j>=0) && (arr[i][j] >0 || arr[i][j] ==-2))
			return true;
		else
			return false;
	}

	public static void findBackMoves(int i,int j) {
		// find all possible moves
		// within the matrix
		// and has value either -2 or greater than 0
		List<Pair> list = new ArrayList();
		if (arr[i][j] == -2) System.out.println("Found!!");
		else {
			
			Pair p = new Pair(-1,-1);

			
			if (satisfyBack(i-1,j)) list.add(new Pair(i-1,j));;
			if (satisfyBack(i+1,j)) list.add (new Pair(i+1,j));
			if (satisfyBack(i,j-1)) list.add (new Pair(i,j-1));
			if (satisfyBack(i,j+1)) list.add (new Pair(i,j+1));
			int min = Integer.MAX_VALUE;
			Iterator it = list.iterator();
			while(it.hasNext()) {
				Pair s = (Pair) it.next();
				if(arr[s.getI()][s.getJ()]<=min) {
					min = arr[s.getI()][s.getJ()];
					p = s;
				}
			}
			
			if(min!=Integer.MAX_VALUE) {
				System.out.println(p.getI() + ","+ p.getJ());
				findBackMoves(p.getI(),p.getJ());
			}
			else {
				System.out.println("Can't traverse");
			}
		}
	}
	
	public static boolean satisfy(int i, int j) {
		int maxI = arr.length-1;
		int maxJ =arr[0].length-1;
		if ((i<=maxI) && (i>=0)&&(j<=maxJ) && (j>=0) && (arr[i][j] ==0 || arr[i][j] ==-3))
			return true;
		else
			return false;
	}
	
	public static List<Pair> findPossibleMoves(int i,int j) {
		// find all possible moves
		// within the matrix
		// and has value 0
		List<Pair> list = new ArrayList();
		if (satisfy(i-1,j)) list.add(new Pair(i-1,j));
		if (satisfy(i+1,j)) list.add (new Pair(i+1,j));
		if (satisfy(i,j-1)) list.add (new Pair(i,j-1));
		if (satisfy(i,j+1)) list.add (new Pair(i,j+1));
		return list;
	}
	
	public static void fillMatrix(int i, int j, int d) {
		List<Pair> list = new ArrayList();
		if(arr[i][j]== -3) foundExit = true;
		else {
			if(arr[i][j]== 0) arr[i][j] = d;
			list = findPossibleMoves(i,j);
			if (!list.isEmpty()) {
				Iterator it = list.iterator();
				while(it.hasNext()) {
					Pair p = (Pair)it.next();
					fillMatrix(p.getI(),p.getJ(),d+1);
				}
			}
		}
	}
	public static void main(String[] args) {
		fillMatrix(0,3,0);
		printMatrix();
		System.out.println(foundExit);
		traverse(1,0);
	}
}
