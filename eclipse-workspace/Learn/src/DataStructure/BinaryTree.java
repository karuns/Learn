package DataStructure;

public class BinaryTree {
	TNode root;

    BinaryTree() {
	}


	int findSize(TNode t) {
		int size = 0;
		if(t != null) {
			size = findSize(t.left)+1+findSize(t.right);
		}
		return size;
	}
	
	int size() {
		//TNode t = this.root;
		return findSize(this.root);
	}
	
	int findMax(TNode t) {
		int max = Integer.MIN_VALUE;
		if(t!=null) {
			max = Math.max(max,findMax(t.left));
			max = Math.max(max,findMax(t.right));
			max = Math.max(max,t.val);
		}
		return max;
	}
	int max() {
		return findMax(this.root);
	}
	
	
	int findMin(TNode t) {
		int min = Integer.MAX_VALUE;
		if(t!=null) {
			min = Math.min(min,findMin(t.left));
			min = Math.min(min,findMin(t.right));
			min = Math.min(min,t.val);
		}
		return min;
	}
	
	int min() {
		return findMin(this.root);
	}
	
}
