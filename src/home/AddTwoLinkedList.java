package home;

public class AddTwoLinkedList {

    // 1->8->1    1->2->1   = 302
   // Input: l1 = [2,4,3], l2 = [5,6,4]
    //Output: [7,0,8]
    /**
     * Definition for singly-linked list. */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode resultNode = new ListNode();
        ListNode dummy = resultNode;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            if(sum > 9) {
                carry = sum / 10;
                sum = sum ^ 10;
            }
            resultNode.next = new ListNode(sum );
            l1 = l1.next;
            l2 = l2.next;
            resultNode = resultNode.next;
        }
         return dummy.next;
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(2,new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5,new ListNode(6, new ListNode(4, null)));
        AddTwoLinkedList addList = new AddTwoLinkedList();
        ListNode result = addList.addTwoNumbers(l1,l2);
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }

}
