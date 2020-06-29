package ProblemSolving;
class RemoveNFromEnd {

    public static RetObj removeN(ListNode root, ListNode parent, ListNode current, int n) {
    	RetObj retn = new RetObj(root, parent, current, 1);
		if(current.next != null)
            retn = removeN(root, current, current.next, n);
        
        if(retn.nFromEnd == n){
            if (parent == null)
            	retn.root = retn.root.next;
            else
                retn.parent.next = retn.parent.next.next;
        }
        else
            return retn;
    }
        
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        RetObj r = removeN(null, null, head, n);
        return r.root;
    }
    
    public static void main(String[] args) {
    	
    	ListNode n = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    	n = removeNthFromEnd(n,2);
    	
    	while(n.next != null)
    		System.out.println(n.val);
    	
    }
}
