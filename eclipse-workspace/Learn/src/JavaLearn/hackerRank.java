package JavaLearn;

public class hackerRank {
    // Complete the pylons function below.
    static int findNextOptimumCity(int k, int i, int [] arr) {
        int j = i+(k-1);
        if(j > arr.length-1) return -2; // reached end 
        else{
            // going to other side but not crossing total size.
            j = j+(k-1);
            if(j > arr.length-1) j = arr.length-1;
            
            while(j > i) {
                if (arr[j] ==1) return j;
                else j--;
            }
            if(j ==i){
                if((arr[j]) == 1) return i;
                else return -1;
            }
        }
        return 0;
    }

    static int buildPp(int k, int i, int [] arr) {
        int nextI = findNextOptimumCity(k, i, arr );
        if(nextI == -1) return -1; // can’t find possible city
        else if(nextI == -2) return 0; // reach to end
        else {
            int val = buildPp(k, nextI+1, arr);
            if (val == -1) return -1;
            else return val+1;
        }
    }

    static int pylons(int k, int[] arr) {
            return buildPp(k, 0, arr);
    }

}
