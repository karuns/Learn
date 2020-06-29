package DataStructure;



public class Node1{
	int val;
    Node1 left = null,  right = null;

	public Node1(int val){
		this.val = val;
    }
	
	public Node1(int val, Node1 left, Node1 right){
		this.val = val;
		this.left = left;
		this.right = right;
    }
	
	public int val(){
		return this.val;
	}
	
	public Node1 left(){
		return this.left;
	}
	public Node1 right(){
		return this.right;
	}
}
