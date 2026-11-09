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

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode(-1);
        ListNode curr = head;

        while(list1 != null && list2 != null){
            // System.out.println("list1.val : " + list1.val + "    list2.val : " + list2.val);
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
                // System.out.println("curr.val : " + curr.val);
            }else{
                curr.next = list2;
                list2 = list2.next;
                // System.out.println("curr.val : " + curr.val);  
            }
            curr = curr.next;
            // System.out.println("curr.val : " + curr.val);
        }

        if(list1 == null){
            curr.next = list2;
        }else if(list2 == null){
            curr.next = list1;
        }

        return head.next;
        
    }
}