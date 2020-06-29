package ProblemSolving;
import java.util.*;

import DataStructure.Pair;
import DataStructure.People;

public class FBMaxYearPopulation {
	
	public static Pair findLowBirthYear(ArrayList <People> p) {
		int lowB = Integer.MAX_VALUE;
		int highB = Integer.MIN_VALUE;
		
		for (int i=0; i<p.size(); i++) {
			lowB = Math.min(lowB,p.get(i).b);
			highB = Math.max(highB,p.get(i).b);
			
		}
		return new Pair(lowB,highB);
		
	}
	public static int findMaxPopulationYear(ArrayList <People> p) {
		Pair pair = findLowBirthYear(p);
		int lowBirthYr = pair.getI();
		int highBirthYr = pair.getJ();
		
		int yearSize = highBirthYr-lowBirthYr+1;
		//last year would be yearSize start+i, to start+size-1
		int [] years  = new int [yearSize];
		for(int i = 0; i<yearSize; i++) years[i] = 0 ;
		
		// for each year add step 
		for (int i=0; i<p.size(); i++) {
			years[p.get(i).b-lowBirthYr]  += 1 ;
			int dYear = p.get(i).d-lowBirthYr+1;
			if(dYear <yearSize) years[p.get(i).d-lowBirthYr+1]  -= 1 ;
		}
	
		int temp = 0;
		int year = 0;
		int max = 0;
		for(int i = 0; i<yearSize; i++) {
			temp+=years[i];
			if(temp > max) {
				max = temp;
				year = i;
			}
		}
		return year+lowBirthYr;
	}
	
	public static void main(String[] args) {
		ArrayList <People> p = new ArrayList();
		p.add(new People("Ram", 1, 10));
		p.add(new People("Ram", 3, 10));
		p.add(new People("Ram", 100, 120));
		System.out.println(Math.floorMod(4, 3));
		System.out.println(findMaxPopulationYear(p));
	}
}


