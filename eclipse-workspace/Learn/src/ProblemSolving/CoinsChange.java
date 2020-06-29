package ProblemSolving;

import java.util.Arrays;

class CoinsChange {
    // 11:17
    public static boolean findCoins(int[] coins, int[] out, int val, int n) {
        if(n<0) return false;
        int max = val/coins[n];
        for(int i = max; i>=0; i--) {
            out[n] = i;
            int difference = val - (out[n] * coins[n]);
            if(difference == 0) return true;
            else {
                if(findCoins(coins, out, difference, n-1)) return true;
            }
        }
        return false;
    }
                                    
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        int[] out = new int[coins.length];
        for(int i = 0; i<coins.length; i++) System.out.println(coins[i]);
        for(int i = 0; i<out.length; i++) out[i] = 0;
        findCoins(coins, out, amount, coins.length-1);
        int total = 0;
        for(int i = 0; i<out.length; i++) total+= out[i];
        if(total == 0)
            return -1;
        else
            return total;
    }
    
    public static void main(String[] args) {
    	System.out.println(coinChange(new int[] {186,419,83,408}, 6249));
    }
}
