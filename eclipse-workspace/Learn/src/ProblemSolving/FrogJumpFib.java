package ProblemSolving;

public class FrogJumpFib {
		public static int exploreJump(int remaining) {
			if(remaining == 1) return 1;
			else if(remaining == 2) return 1+exploreJump(1);
			else return exploreJump(remaining-2)+exploreJump(remaining-1);
	}
	public static void main (String[] args) {
			int n = 11;
			System.out.println("Number of ways frog can jump = " + exploreJump(n));
	}
}

