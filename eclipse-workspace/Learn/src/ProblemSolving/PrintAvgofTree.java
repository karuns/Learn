package ProblemSolving;
import java.util.*;
import DataStructure.Node1;

public class PrintAvgofTree {
	public static void printLevel(List<Node1> l, int level) {


		while(!l.isEmpty()) {
			double sum = 0;
			int i = 0;
			List<Node1> newL = new ArrayList();
			Iterator<Node1> it = l.iterator();
			while(it.hasNext()) {
				Node1 n = it.next();
				sum+=n.val();
				if(n.left()!=null) newL.add(n.left());
				if(n.right()!=null) newL.add(n.right());
				it.remove();
				i++;
			}
			l.addAll(newL);
			System.out.println("Average at level: "+level++ +" is = "+ (sum/i));
		}

		
}
	public static void main (String [] args) {
		// Construct input tree
		Node1 n = new Node1 (5, new Node1(1, new Node1(3), new Node1(1)),
			         new Node1(1, new Node1(2), new Node1(2)));
        n = new Node1 (3, new Node1(4) ,n );

		// Print each level
		List<Node1> l = new ArrayList();
		l.add(n);
		printLevel(l, 0);
}
}

