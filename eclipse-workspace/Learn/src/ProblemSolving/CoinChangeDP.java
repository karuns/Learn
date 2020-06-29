package ProblemSolving;

import java.util.Arrays;

class CoinChangeDP{                                    
	    public int coinChange(int[] coins, int amount) {
	        if (amount == 0) return 0;
	        int[] dp = new int[amount+1];
	        Arrays.sort(coins);
	        for(int i = 0 ; i < dp.length; i++) dp[i] = amount+1;
	        for(int i = 0 ; (i < dp.length) && (i < coins[0]); i++) dp[i] = 0;
	        
	        for(int i = 1 ; i < dp.length; i++) {
	            dp[i] = amount+1; // initialize
	            for(int j = 0; j < coins.length; j++) {
	                if(coins[j] <= i) {
	                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
	                }
	            }
	        }
	        if (dp[amount] == amount+1) return -1;
	        else 
	            return dp[amount];
	    }
	}