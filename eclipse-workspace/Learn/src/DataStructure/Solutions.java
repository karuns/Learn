package DataStructure;

class Solutions {
	public static long solution(long[] prices) {
	      // Type your solution her
		int maxLocal = 0;
		int maxTotal = 0;
		for(int i = 1; i< prices.length; i++){
			long priceChange = prices[i] - prices[i-1];
	    	if(priceChange>0)
	    		maxLocal+= priceChange;
	    	else {
	    		maxTotal+= maxLocal;
	    		maxLocal = 0;
	    	}
	    }
	    maxTotal+= maxLocal;
	    return maxTotal;
	}

    
    public static void main(String[] args) {

    	System.out.println(solution(new long[]{6, 1,0, -1, 11}));
    	System.out.println(Integer.MAX_VALUE);
    }
    
//    public static long solution(long[] prices) {
//        // Type your solution here
//      int maxLocal = 0;
//      int maxTotal = 0;
//      for(int i = 1; i< prices.length; i++){
//        maxLocal+= prices[i] - prices[i-1];
//      	maxLocal = Math.max(0, maxLocal);
//        maxTotal = Math.max(maxTotal, maxLocal);
//      }
//      return maxTotal;
//    }

}
