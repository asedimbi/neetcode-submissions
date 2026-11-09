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
    public ListNode reverseList(ListNode head) {

        // O(n) time, O(n) space

        // list reverseHead = new ()
        // for(current in linkedList)
        //     reverseHead = new ListNode(current.val, reverseHead);

        ListNode reverse = null;

        while(head != null){
            // System.out.println("head.val : " + head.val);
            reverse = new ListNode(head.val, reverse);
            head = head.next;
        }

        return reverse;
        
    }
}
