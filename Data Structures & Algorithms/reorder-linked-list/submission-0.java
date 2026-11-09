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
    public void reorderList(ListNode head) {

        /*       HEAD
        *           curr    currNext                                  last                            
        *           0       1       2       3      4        5         6                                
        * currPrev                                        prevLast                                   
        *
        *           curr    currNext                                             last                            
        *           0       (l)6           1       2       3      4        5         6                                
        * currPrev                                                     prevLast                                            
        *                                                                               
        *                                                                               
        *                                                                               
        *                                                                             
        *                                                                               
        */
        

        //curr.next = last   0->6->null
        //last = prevLast
        //last.next = null  5->null

        //curr = curr.next   head(0)->curr(6)->null
        //curr.next = currNext head(0)->curr(6)->currNext(1)->2
        //currNext = currNext.next head(0)->curr(6)->(1)->currNext(2)->3
        //curr = curr.next  head(0)->6->curr(1)->currNext(2)->3->4->last(5)->null
        //we dont have a prevLast now.

        //curr.next = last   1->5->null
        //last = prevLast X
        
        //curr = curr.next   head(0)->6->curr(1)->last(5)->null
        //curr.next = currNext head(0)->curr(6)->currNext(1)->2
        //currNext = currNext.next head(0)->curr(6)->(1)->currNext(2)->3
        //curr = curr.next  head(0)->6->curr(1)->2->3->4->last(5)->null


        //use length

        //we have 7 length
        //if we insert blank nodes at every node
        //length becomes 14
        //

        //find middle node
        //single pass with a slow and fast pointer

        if(head == null){
            return;
        }

        // 0 1 2 3 4 null
        //     s     f
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //now slow is the midpoint?
        //slow ends up at the end of the first half
        //move it to next to see the second half

        ListNode second = slow.next;

        //reverse the 2nd half of the list
        ListNode prev = slow.next = null;

        while( second != null ) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        //merge the two lists
        ListNode first = head;
        second = prev;
        while ( second != null ) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
}
