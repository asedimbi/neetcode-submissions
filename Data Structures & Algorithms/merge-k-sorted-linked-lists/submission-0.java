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
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(node -> node.val)
        );

        for(ListNode head: lists){
            if(head != null)
                minHeap.offer(head);
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;

        while(!minHeap.isEmpty()){

            ListNode smallest = minHeap.poll();

            tail.next = smallest;

            if(smallest.next != null){
                minHeap.offer(smallest.next);
            }

            tail = tail.next;
            tail.next = null;
        }

        return dummyHead.next;
    }
}
