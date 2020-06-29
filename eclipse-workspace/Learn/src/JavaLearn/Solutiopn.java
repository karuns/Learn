package JavaLearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

class Solutiopn {
    //11:33 , 11:35
	
	public int[] twoSum(int[] nums, int target) {
    	int [] out  = new int [2];
        HashMap<Integer,Integer> hm = new HashMap();
        for(int i= 0; i<nums.length ; i++) {
            if(hm.containsKey(nums[i])) {
            	out[0] = hm.get(nums[i]);
            	out[1] = i;
            }
            else hm.put(target-nums[i],i);
        }
        return out;
        
        
        // for item i in nums, if I exist in set s then return val of 0 else add val, index
    }
	
	
	public static void main(String [] args) {
		String [] arr = {"5:0","4:2","5:1","1:1","2:2", "10:2"};
		Arrays.sort(arr,Collections.reverseOrder()); 
		for(int i = 0 ; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("A", "test1");
		map.put("C", "test3");
		map.put("E", "test5");
		map.put("B", "test2");
		map.put("D", "test4");
		System.out.println(map);
		TreeMap<String, String> tmap = new TreeMap<String, String>(map);
		for(String item : tmap.keySet()) {
			System.out.println(item);
		}
		
		ArrayList<Integer> al = new ArrayList();
		al.add(5);
		al.add(7);
		al.add(6);
		al.add(1);
		al.sort(Collections.reverseOrder());
		System.out.println(al);
		 //al = new ArrayList(Arrays.asl(arr));
		
		 System.out.println(al);
		 
		 String s = "234524";
		 for(int i =0; i<s.length();i++)
			 System.out.println( s.substring(i,i+1));
		 
		 for(char str: s.toCharArray()) {
			System.out.println(Integer.parseInt(Character.toString(str)));
		 }
	}
	
    
}