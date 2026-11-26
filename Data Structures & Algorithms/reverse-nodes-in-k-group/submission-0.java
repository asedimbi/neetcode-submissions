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
    public ListNode reverseKGroup(ListNode head, int k) {
        if( head  == null) {
            return head;
        }

        ListNode tempHead = new ListNode(-1);
        ListNode result = tempHead;
        tempHead.next = head;

        while(tempHead.next != null){
            
            head = tempHead.next;
            ListNode tail = head;

            for (int i = 1; i < k; i++){
                tail = tail.next;
                if (tail == null)
                    break;
            }

            if(tail == null){
                break;
                //last sublist is smaller than k. no need to reverse
            }

            tempHead.next = reverseLinkedList(head, tail, k); //reverse and link the reversed part

            tempHead = head; //head is not end of the sublist. move there for next iteration            
        }

        return result.next; //result still points to the dummy -1 node.
     
    }

    public ListNode reverseLinkedList(ListNode head, ListNode tail, int k){
        ListNode nextHead = tail.next; //a reference to the end of sublist

        ListNode prev = nextHead;
        ListNode curr = head;

        while (curr != nextHead) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}
