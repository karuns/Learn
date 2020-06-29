package DataStructure;

public class TwoArrayDS {
	int [] a;
	int [] b;
	int indexA=0, indexB=0; 
	
	TwoArrayDS(int[] a, int[] b) {
		this.a = a;
		this.b = b;
	}
	
	public int getNextSmallest() {
		if((indexA < a.length) && (indexB < b.length)) {
			if(a[indexA] < b[indexB]) {
				indexA++;
				return a[indexA-1];
			}
			else {
				indexB++;
				return b[indexB-1];
			}
		}else if((indexA >= a.length) && (indexB >= b.length)) return -1;
		else if(indexA < a.length) {
			indexA++;
			return a[indexA-1];
		}else {
			indexB++;
			return b[indexB-1];
		}
	}

	public void resetIndex() {
		this.indexA = 0;
		this.indexB = 0;
		// TODO Auto-generated method stub
		
	}
}
