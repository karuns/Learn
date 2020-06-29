package ProblemSolving;

public class RetObj {
    ListNode root;
    ListNode parent;
    ListNode current;
    int nFromEnd;
    public RetObj(ListNode root, ListNode parent, ListNode current, int nFromEnd) {
        this.root = root;
        this.parent = parent;
        this.current= current;
        this.nFromEnd = nFromEnd;
    }
}
