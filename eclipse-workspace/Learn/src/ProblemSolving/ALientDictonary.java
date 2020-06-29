package ProblemSolving;

/*
4:10
*/
import java.util.*;
class Solution {
    
    public static int getIndexOf(String s, HashMap<Character,Integer> order) {
        
        return order.get(s.charAt(0)); // making sure all character are valid
    }
    public static boolean compare (String s1, String s2, HashMap<Character,Integer> order) {
        if(s1.length() == 0) return true;
        else if(s2.length()==0) return false;
        else if(getIndexOf(s1,order) < getIndexOf(s2,order)) return true;
        else if(getIndexOf(s1,order) > getIndexOf(s2,order)) return false;
        else if(getIndexOf(s1,order) == getIndexOf(s2,order)) {
            return compare(s1.substring(1),s2.substring(1),order);
        }
        else return false;
    }
    public boolean isAlienSorted(String[] words, String order) {
        // getIndex() put all the character to arraylist or hash to get the index
        // compare two word at a time and if succeed move to next two if fails exit. if it continues till the end of word. we retiurn true
        // if only one then return
        HashMap <Character, Integer> hm = new HashMap();
        for(int i =0; i<order.length() ;i++){
            hm.put(order.charAt(i),i);
        }
        boolean isSorted = true;
        for (int i=0; (i< words.length-1 && isSorted);i++)
            isSorted = compare(words[i],words[i+1],hm);
        return isSorted;
    }
}
