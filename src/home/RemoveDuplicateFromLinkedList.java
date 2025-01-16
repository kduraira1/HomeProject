package home;

public class RemoveDuplicateFromLinkedList {
    public ListNode removeDuplicate(ListNode listNode) {
        ListNode dummy = new ListNode(0);
        dummy.next = listNode;
        ListNode previous = dummy;

        while( listNode !=null && listNode.next != null) {
            //if (listNode == null || listNode.next == null) return listNode;
            if(listNode.val == listNode.next.val) {
                while (listNode.next != null && listNode.val == listNode.next.val) {
                    listNode = listNode.next;
                }
                previous.next = listNode.next;
            } else {
                previous.next = listNode;
                previous = previous.next;

            }
            listNode = listNode.next;
        }
        return dummy.next;
    }

    //Input: head = [1,2,3,3,4,4,5]
    //Output: [1,2,5]
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;

        if (next.val == head.val) {
            while (next != null && next.val == head.val) {
                next = next.next;
            }
            return deleteDuplicates(next);
        } else {
            head.next = deleteDuplicates(next);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5, null)))))));
        //home.ListNode result = l1;
       /* while(l1 != null) {
            System.out.print(l1.val + " ");
            l1 = l1.next;
        }*/
        RemoveDuplicateFromLinkedList rdll = new RemoveDuplicateFromLinkedList();
        ListNode result ;//= rdll.removeDuplicate(l1);
        result = rdll.deleteDuplicates(l1);
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
