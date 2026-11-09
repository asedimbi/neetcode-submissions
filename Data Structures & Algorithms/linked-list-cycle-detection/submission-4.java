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
    public boolean hasCycle(ListNode head) {

        // Set<ListNode> visited = new HashSet<>();
        // ListNode curr = head;

        // while(curr != null){
        //     // System.out.println("visited : " + visited);
        //     if(visited.contains(curr)){
        //         return true;
        //     }else{
        //         visited.add(curr);
        //         curr = curr.next;
        //     }
        // }
        // return false;


        //when there is a cycle and if we keep iterating
        // the size of list appears larger than actual
        // but original size is not known

        //how do we remember previous nodes?
        //

        //given data has -1000 to 1000
        // type is int which is 32 bit (byte, short, int, long)

        //we can replace elements by -2000 and if we get same value again we can return true

        // while(head != null){
        //     if(head.val == -2000){
        //         return true;
        //     }

        //     head.val = -2000;
        //     head = head.next;
        // }

        // return false;


        //slow and fast pointers
        //fast moves two steps, slow moves one step
        // if fast == slow any time then we have a loop

        //where to initialize fast and slow?

        if(head == null || head.next == null){
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        fast = fast.next.next;
        while(fast!= null){
            if(fast == slow){
                return true;
            }
            slow = slow.next;
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
        }

        return false;

    }
}
