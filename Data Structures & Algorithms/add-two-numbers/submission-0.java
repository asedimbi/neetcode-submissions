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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);
        ListNode curr = head;

        while(l1 != null || l2 != null){
            
            if(curr.next != null){
                curr = curr.next;
            }else{
                curr.next = new ListNode(0);
                curr = curr.next;
            }

            if(l1 != null) { curr.val += l1.val; l1 = l1.next; }
            if(l2 != null) { curr.val += l2.val; l2 = l2.next; }

            if( curr.val >= 10 ){
                curr.val = curr.val % 10;
                curr.next = new ListNode(1);
            }

        }

        return head.next;
        
    }
}
