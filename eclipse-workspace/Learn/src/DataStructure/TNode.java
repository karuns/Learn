package DataStructure;

public class TNode {
    Integer val;
	TNode left = null;
	TNode right = null;
	
	TNode(Integer val) {
		this.val = val;
	}

	TNode(Integer val, TNode left, TNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	Integer getVal() {
		return this.val;
	}
}
