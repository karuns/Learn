package DataStructure;
import java.util.*;

import java.util.HashMap;


public class HashesExample {

	public static void main(String [] args) {
		// HashSet 
		HashSet<Integer> hs = new HashSet();
		hs.add(1);
		hs.add(2);
		hs.add(1);
		hs.add(3);
		
		System.out.println(hs);
		System.out.println(hs.equals(new HashSet(hs)));
	
		HashMap<String, Integer> hm = new HashMap();
		hm.put("a",1);
		hm.put("a",2);
		hm.put("b",3);
		
		
		//Collections.sort(hm.keySet().t(), Collections.reverseOrder());
		System.out.println(hm);
		hm.remove("b",5);
		System.out.println(hm);
		hm.remove("b",3);
		System.out.println(hm);
		hm.put("a",1);
		hm.put("a",2);
		hm.put("b",3);
		System.out.println(hm);
		hm.remove("b");
		Iterator it = hm.keySet().iterator();
		
		while(it.hasNext()) System.out.println(it.next());
		//System.out.println(hm.entrySet());
		//System.out.println(hm.keySet());
		
		Hashtable <String, Integer> ht = new Hashtable();
		ht.put("a",2);
		ht.put("b",3);
		System.out.println(ht);
		System.out.println(ht.keys());
		it = ht.keys().asIterator();
		
		while (it.hasNext()) System.out.println( ht.get(it.next()));
		it = ht.keySet().iterator();
		while (it.hasNext()) System.out.println( ht.get(it.next()));
	
		//System.out.println(it.next());
		
		LinkedHashSet<Integer> lhs = new LinkedHashSet();
		lhs.add(1);
		lhs.add(2);
		lhs.add(1);
		lhs.add(3);
		
		
		System.out.println(lhs);
		
		
		// Linked HashMap
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap();
		lhm.put("a",1);
		lhm.put("a",2);
		lhm.put("b",3);
		lhm.putIfAbsent("b", 5);
		lhm.rem
		
		System.out.println(lhm);
		HashMap <Integer,Integer> hmp = new HashMap();
		hmp.put(100,2);
		hmp.put(190,2);
		hmp.put(99,2);
		hmp.put(70,2);
		hmp.put(60,2);
		System.out.println(hmp);
		
		TreeMap<Integer,Integer> tmp = new TreeMap(hmp);
		for(Integer item: tmp.descendingKeySet()) /// 
			System.out.println(item);
	}
	
}
