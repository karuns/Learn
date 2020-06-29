package DataStructure;

import java.util.*;
import java.util.function.Predicate;

public class ArrayListLearn {
	
	public static List<String> createArrayListExample() {
		List<String> al = new ArrayList<>(5);
		al.add("lion");
		al.add("tiger");
		al.add("cheetah");
		
		System.out.println(al); 
		System.out.println(al.get(0)); 
		System.out.println(al.toString());
		
		List<String> bird = new ArrayList<>(5);
		bird.add("sparrow");
		bird.add("parrot");
		bird.add("eagle");
		
		// addAll at the end
		al.addAll(bird);
		System.out.println(al);
		
		// removeAll()
		al.removeAll(bird);
		System.out.println(al);
		
		//addAll at the specified index.
		al.addAll(1,bird);
		System.out.println(al);
		
		//add twice and removeall
		al.addAll(bird);
		System.out.println(al);
		
		// removeAll()   it  removes all the occurances.
		al.removeAll(bird);
		System.out.println(al);
				
		int [] a = new int[]{2,3,4,5};
		ArrayList<Integer> aal = new ArrayList((ArrayList)Arrays.asList(a));
		System.out.println(aal);
		return al;

		
	}
	public static void main(String [] args) {
		System.out.println("Learning ArrayList");
		List<String> list = new ArrayList();
		list = createArrayListExample();
		
		// Iterate next starts from -1 index.
		int i =0;
		Iterator it = list.iterator();
		while(it.hasNext()) {
			list.set(i++,(String) it.next()+":");
			//it.remove();
		}
		System.out.println(list);
		
	
		// Iterate previous from specified index. starting from size i.e last item+1
		// Can traverse both ways
		ListIterator lit = list.listIterator(list.size()); 
		while(lit.hasPrevious()) System.out.println(lit.previous());
		

		// Iterate previous from 2  index. starting from size i.e last item+1
		lit = list.listIterator(2);
		while(lit.hasPrevious()) System.out.println(lit.previous());
		
		
		// Remove if
		System.out.println(list);
		list.removeIf(s->s.startsWith("c"));
		System.out.println(list);
		
		// Remove if with predicate 
		list.add("cheetah");
		list.removeIf(new Predicate<String>() {
			@Override
			public boolean test(String s) { 
				return s.startsWith("c");
				
			}
			
		});
		LinkedHashMap<Integer,Integer> lhm = new LinkedHashMap();
	
		System.out.println(list);
		list.add("cheetah");
		System.out.println(list);
		
		// exist in list
		System.out.println(list.contains("cheetah"));
		
		System.out.println(list.containsAll(list));
	
		//equals
		System.out.println(list.equals(new ArrayList<String>()));
		
		
		// empty
		list.isEmpty();
		list.remove(2);
		System.out.println(list);
		list.add("cheetah");
		System.out.println(list);
		list.remove("cheetah");
		System.out.println(list);
		list.add("cheetah");
		System.out.println(list);
//		list.se
		
		// for each 
		//list.forEach(s -> {//here you have access to s});
//		list.forEach(s -> {
//			System.out.println(s);
//		});;
		
		it = list.iterator();
		it.forEachRemaining(s -> {
			System.out.println(s);		
		});
		
// Search
		System.out.println(list.contains("cheetah"));
		System.out.println(list.indexOf("cheetah"));
		System.out.println(list.lastIndexOf("cheetah"));
		
		
// Sort using Collections and Comparator class.
		Collections.sort(list);
		System.out.println(list);
	
		list.sort(Comparator.reverseOrder());
		System.out.println(list);
		
// Using lambda compare to. if positive number sort in asscendind if negative then  descending 
		list.sort((num1, num2) -> {
			return num1.compareTo(num2);
		});
		System.out.println(list);


		list.sort((num1, num2) -> {
			//System.out.println(num2.compareTo(num1));
			return num2.compareTo(num1);
		});
		System.out.println(list);
		
		list.sort((num1, num2) -> {
			
			return 1;
		});
		System.out.println(list);
		
		list.sort((num1, num2) -> {
			return -1;
		});
		System.out.println(list);
		list.sort((a,b)->{return 1;});
		
		System.out.println(new int[] {1,3});
		
		PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
		pq.add(4);
		pq.add(1);
		pq.add(10);
		while(!pq.isEmpty()) System.out.println(pq.poll());
		
		
		// Convert to binary String
		System.out.println(Integer.toBinaryString(5));
		
		PriorityQueue<Integer> pqr = new PriorityQueue();
		
		pqr.add(2); 
		pqr.add(4);
		//pq.add(2);
		pqr.add(5);
		System.out.println(pqr.contains(2));
		System.out.println(pqr);
		
		System.out.println(new int[]{});
	
	}

}
