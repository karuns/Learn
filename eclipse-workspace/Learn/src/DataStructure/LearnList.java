package DataStructure;
import java.util.* ;


public class LearnList {
	public static boolean isSorted(String s) {
		char[] c = s.toCharArray();
		for(int i = 0; i< c.length-1; i++) {
			if(c[i]>c[i+1]) return false;
		}
		return true;
	}
	public static void main(String [] args) {
	ArrayList <Integer> al = new ArrayList <Integer>(10);
	al.add(1);
	Iterator it = al.iterator();
	System.out.println(it.next());
            Vector<Integer> v  = new Vector<Integer>(10);
             v.add(2);
             it = v.iterator();
     System.out.println(it.next());
            LinkedList<Integer> ll = new LinkedList<Integer>();
            ll.add(3);
            it  = ll.iterator();
            System.out.println(it.next());
            String s = "ab";
            s.toCharArray();
        	System.out.println(s.substring(2).length());
        	
        	int [] arr = {2,3};
        	ArrayList<Integer> aal = new ArrayList(Arrays.asList(arr));
        	System.out.println(aal);
        	aal.
        	String ss = "lmabdefg";
        	System.out.println(isSorted(ss));
        	char [] c = ss.toCharArray();
        	Arrays.parallelSort(c);
        	ss = String.copyValueOf(c);
        	System.out.println(isSorted(ss));
        	System.out.println(ss);
        	int [][] ar = {{1,2},{5,2},{0,1}};
        	Arrays.sort(ar);
        	//System.out.println(String.valueOf(ar));
        	for(int i = 0; i<ar.length;i++) {
        		for(int j = 0; j<2;j++) {
        			System.out.print(" "+ar[i][j]);}
        		System.out.println("");
        	}
        	

        
        	
	}
	
	
	
	
	//Pair <String, Integer> p = Pair.with Pair("Ram",5);
	
	
}
