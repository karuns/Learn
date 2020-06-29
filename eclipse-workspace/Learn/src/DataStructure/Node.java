package DataStructure;

public class Nodea {
    int value;
    Node left;
    Node right;
 
    public Node(int value, Node left, Node right) {
        this.value = value;
        this.right = right;
        this.left = left;
    }
    public Node(int value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }
    public Node right() {
        return this.right;
    }
    
    public Node left() {
        return this.left;
    }
    
    public int val() {
        return this.value;
    }
}

