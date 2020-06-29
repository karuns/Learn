package DataStructure;

public class SelfBalancingTree {

	/* Class node is defined as :
    class Node 
    	int val;	//Value
    	int ht;		//Height
    	Node left;	//Left child
    	Node right;	//Right child
        1:30
	*/
    static boolean isLeaf(Node root) {
        if((root.left == null) && (root.right ==null)) return true;
        else return false;
    }
    static void insertNode(Node root,int val) {
        if(isLeaf(root)){
            Node temp = new Node();
            temp.val = val;
            temp.ht = 0;
            temp.left = null;
            temp.right = null;
            if (val < root.val) root.left = temp;
            else root.right = temp; 
        }
        else {
            if(val < root.val) 
                insertNode(root.left, val);
            else
                insertNode(root.right, val);
        }
    }

    public static int updateHeight(Node root){
        if (root == null) return -1;
        else {
            root.ht = updateHeight(root.left) - updateHeight(root.right);
            return root.ht;
        }
    }

    // public static int updateHeight(Node root){
    //     if (root == null) return -1;
    //     else {
    //         root.ht = 1+Math.max(updateHeight(root.left), updateHeight(root.right));
    //         return root.ht;
    //     }
    // }

    public static Node findUnbalancedNode(Node root, int val) {
    	
        Node ubNode = null;
        if (root!=null) {
            if (val<root.val) ubNode = findUnbalancedNode(root.left, val);
            else 
            if((ubNode == null) &&(root.val < -1) && (root.val > 1)) ubNode = root;
        }
        return ubNode;
    }
    static String findUnbalaceType(Node root, int val){
        if(root.val == val) return "";
        else {
            if(val < root.val ) return "l"+ findUnbalaceType(root.left,val);
            else return "r"+ findUnbalaceType(root.right,val);
        }   
    }

    public static Node findParent(Node root, Node ubNode, int val) {
        if (root == ubNode ) return null;
        else if((root.left == ubNode) ||(root.right == ubNode)) return root;
        else if(val < root.val) return findParent(root.left, ubNode, val);
        else return findParent(root.right, ubNode, val);
    }

    static Node llBalance(Node root, Node ubRoot, Node parent) {
        if(parent == null) { // root node is unbalanced
            root = ubRoot.left;
            ubRoot.left = root.right;
            root.right = ubRoot;
        } else {
          if (parent.left == ubRoot) {
             parent.left = parent.left.left; 
             ubRoot.left = parent.left.right;
             parent.left.right = ubRoot;
          } else {
             parent.right = parent.right.left; 
             ubRoot.left = parent.right.right;
             parent.right.right = ubRoot; 
          }   
        }
        return root;
    }

    static Node rrBalance(Node root, Node ubRoot, Node parent) {
        if(parent == null) { // root node is unbalanced
            root = ubRoot.right;
            ubRoot.right = root.left;
            root.left = ubRoot;
        } else {
          if (parent.left == ubRoot) {
             parent.left = parent.left.right; 
             ubRoot.right = parent.left.left;
             parent.left.left = ubRoot;
          } else {
             parent.right = parent.right.right; 
             ubRoot.right = parent.right.left;
             parent.right.left = ubRoot; 
          }   
        }
        return root;
    }
    static Node lrBalance(Node root, Node ubRoot, Node parent) {
        if(parent == null) { // root node is unbalanced
            root = ubRoot.left.right;
            ubRoot.left.right = root.left;
            root.left = ubRoot.left;
            ubRoot.right = root.right;
            root.right = ubRoot;
        } else {
          if (parent.left == ubRoot) {
             parent.left = parent.left.left.right; 
             ubRoot.left.right = parent.left.left;
             parent.left.left = ubRoot.left;
             ubRoot.left = parent.left.right;
             parent.left.left = ubRoot;
          } else {
             parent.right = ubRoot.left.right; 
             ubRoot.left.right = parent.right.left;
             parent.right.left = ubRoot.left;
             ubRoot.left = parent.right.right;
             parent.right.right = ubRoot;
          }   
        }
        return root;
    }
    static Node rlBalance(Node root, Node ubRoot, Node parent) {
        if(parent == null) { // root node is unbalanced
            root = ubRoot.right.left;
            ubRoot.right.left = root.right;
            root.right = ubRoot.right;
            ubRoot.right = root.left;
            root.left = ubRoot;
        } else {
          if (parent.right == ubRoot) {
             parent.right = parent.right.right.left; 
             ubRoot.right.left = parent.right.right;
             parent.right.right = ubRoot.right;
             ubRoot.right= parent.right.left;
             parent.right.right = ubRoot;
          } else {
             parent.left = ubRoot.right.left; 
             ubRoot.right.left = parent.left.right;
             parent.left.right = ubRoot.right;
             ubRoot.right = parent.left.left;
             parent.left.left = ubRoot;
          }   
        }
        return root;
    }
	static Node insert(Node root,int val){
        insertNode(root, val);
        updateHeight(root);
        Node ubNode = findUnbalancedNode(root, val);
        if(ubNode != null) {
            // height balance
            Node p = findParent(root, ubNode, val);
            String unBalanceType = findUnbalaceType(ubNode, val);
            switch (unBalanceType.substring(0,2)) {
            case "ll": root = llBalance(root, ubNode, p);
                  break;
            case "rr": root = rrBalance(root, ubNode, p);
                  break;
            case "lr": root = lrBalance(root, ubNode, p);
                  break;
            case "rl": root = rlBalance(root, ubNode, p);
                  break;
                //default: break;
            }
        }
        return root;
    }
}
