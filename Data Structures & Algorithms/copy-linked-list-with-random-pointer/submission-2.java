/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        //dummy points to head
        //single pass -> we can get curr.val, curr.next, curr.random
        // to create new node, we can do new node(curr.val, _____ )
        // we will not have a next node ready

        // dummy -> 3(7)  -> 7(4)   ->  4(5)  -> 5(null)

        //         new(3, null) prev
        //         prev.next -> new(7, null) prev = prev.next
        //                      prev.next -> new(4, null) prev = prev.next
        //                                       prev.next -> new (5, null)) prev = prev.next
        //   curr = null so exit

        // one pass works for the curr and next pointers.. good

        // for random
        // once a node exists, we can link it

        // what if we do a simple second pass?
        // we may have to traverse the list many times 

        // if we know the node for each value, we can use a map to do it.. waste of space

        // temporary map?
        // we keep unlinked as next nodes into a map val->node(val, null)

        // when we want to make a new node, with val, we check if the map has it.. use it
        // and remove it?

        Node dummy = head;
        Node deepCopy = new Node(-1);
        Map<Node, Node> nodeMap = new HashMap<>();

        //traverse on the original list
        Node prev = deepCopy;

        while(head != null){
            
            Node curr = nodeMap.computeIfAbsent(head, k -> new Node(k.val));
            prev.next = curr;

            //if node already got created as a random, use that.
            //else make a new one
            Node rand = null;
            if(head.random != null){
                // System.out.println("head : " + head.val + " Random : " + head.random.val);
                rand = nodeMap.computeIfAbsent(head.random, k -> new Node(k.val));
            }
            curr.random = rand;
            //make the node that is in current node's random pointer
            //add it to the map

            prev = prev.next;
            head = head.next;
            //move pointers to thier next positions

        }
        
        nodeMap = null; //free memory.
        return deepCopy.next;
        
    }
}
