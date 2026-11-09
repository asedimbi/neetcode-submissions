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

        // ListNode reverse = null;

        // while(head != null){
        //     // System.out.println("head.val : " + head.val);
        //     reverse = new ListNode(head.val, reverse);
        //     head = head.next;
        // }

        // return reverse;

        //O(n) time, O(1) space

        // 3 reference pointers: head, current, prev

        //          0   1   2    3
        //          h
        //          c
        //   p(null)

        // c = h;        c:0->1->2
        // h = h.next;      h:1->2 
        // c.next = p;   c:0->null
        // p = c;        p:0->null

        // c = h;           c:1->2
        // h = h.next;          h:2->3->null
        // c.next = p;      c:1->0->null
        // p = c;           p:1->0->null

        // c = h;               c:2->3->null
        // h = h.next;               h:3->null
        // c.next = p;          c:2->1->0->null    
        // p = c;               p:2->1->0->null

        // c = h;                    c:3->null
        // h = h.next;                   h:null
        // c.next = p;          c:3->2->1->0->null    
        // p = c;               p:3->2->1->0->null

        ListNode curr = null, prev = null;

        while(head!=null){
            curr = head;
            head = head.next;
            curr.next = prev;
            prev = curr;
        }

        return curr;
    }
}
