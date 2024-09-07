import java.util.List;

public class LinkedListCycle {

    boolean  isCyclic(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)  return true ;
        }
        return false;
    }
    public static void main(String[] args){
        LinkedListCycle llc = new LinkedListCycle();
        ListNode ln = new ListNode(3);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(0);;
        ln.next.next.next = new ListNode(-4);;
        ln.next.next.next.next = ln;;
        System.out.println(llc.isCyclic(ln.next));
    }
}
