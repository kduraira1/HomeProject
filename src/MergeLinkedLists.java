import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class MergeLinkedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode();
        ListNode dummyNode = mergedList;
        while(list1 !=null && list2 != null) {
            if(list1.val > list2.val) {
                mergedList.next = list2; //new ListNode(list2.val);
                list2 = list2.next;

            } else {
                mergedList.next = list1; //new ListNode(list1.val);
                list1 = list1.next;
            }
            mergedList = mergedList.next;
        }
        mergedList.next = list1 != null ? list1 : list2;
        return dummyNode.next;
    }
    public static void main(String[] args){
        MergeLinkedLists mll = new MergeLinkedLists();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode result = mll.mergeTwoLists(list1, list2);
        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }


}
