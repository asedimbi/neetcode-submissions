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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // fast and slow pointer
        // init fast and keep going forward in a loop

        // keep a counter
        // when counter reaches n then initiate slow and slow prev pointers?

        /*  n = 4
              (1)     (2)       (3)        (4)       (5)       (6)     (7)    (null)              
               s                                      f                   
               p        s                                       f                                        
                        p        s                                      f
                                 s                                             f
                                                                                                                                                                                          
        */

        //if we initiate slow at count = n then it becomes prev.
        // we can simply do result = slow.next, and slow.next = slow.next.next

        ListNode removed;
        ListNode slow = head, fast = head;
        int count = 0, len = 0;

        while(fast != null){

            len++;

            System.out.println("fast : " + fast.val);
            

            if(count >= n+1){
                slow = slow.next;
                System.out.println("slow : " + slow.val);
            }

            count++;
            fast = fast.next;
        }

        System.out.println("slow : " + slow.val);
        System.out.println("Length of list : " + len);


        
        if (len == n){
            removed = new ListNode(head.val);
            System.out.println("case 2 - Removing node : " + removed.val);
            head = head.next;
        }else if(slow.next != null){
            removed = slow.next;
            System.out.println("case 1 - Removing node : " + removed.val);
            slow.next = slow.next.next;
        }
        

        return head;

    }
}
