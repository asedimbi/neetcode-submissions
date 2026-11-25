class LRUCache {

    //DataStructure: O(1) gets is a HashMap, O(1) puts is a doubly linked list. Mapy of doubly linked list nodes

    //Making the ListNode class
    class ListNode{
        int key, value;
        ListNode next, prev;

        public ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    //LRUCahce class should have the Map, the list, the capacity
    int capacity;
    ListNode head, tail;
    Map<Integer, ListNode> nodeMap;

    public LRUCache(int capacity) {
        //Initialize
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        //head, tail remain null
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)){
            return -1;
        }

        //otherwise, we have the key, get the node
        ListNode curr = nodeMap.get(key);

        //Most recent accessed node. move to head. the method should take care of necessary pointer corrections
        moveToHead(curr);
        
        return curr.value;
    }
    
    public void put(int key, int value) {
        ListNode curr;
        if(nodeMap.containsKey(key)){
            curr = nodeMap.get(key);
            curr.value = value;

            //most recently used. so move to head
            moveToHead(curr);

        }else{
            curr = new ListNode(key, value);
            nodeMap.put(key, curr);

            //only add to head. no need to detach new nodes
            addToHead(curr);
        }

        
        //check capacity and evict LRU node
        if(nodeMap.size() > capacity){
            removeLruNode();
        }
    }


    //helper methods
    private void moveToHead(ListNode curr){
        if(head == curr){
            return;
        }

        //step 1:
        detachNode(curr);
        //step 2: 
        addToHead(curr);

    }

    private void detachNode(ListNode curr){

        ListNode left = curr.prev;
        ListNode right = curr.next;

        if(left != null)
            left.next = right;
        else
            head = right;

        if(right != null)
            right.prev = left;
        else
            tail = left;
        
        curr.next = null;
        curr.prev = null;

    }

    private void addToHead(ListNode curr){
        //we already handled the case where curr is head. so at this point curr is other than head

        if(head == null){
            head = curr;
        } else {

            curr.next = head;
            head.prev = curr;
            head = curr;
        }

        if(tail == null){
            tail = curr;
        }

    }

    private ListNode removeLruNode(){
        if(tail == null){
            return null;
        }

        ListNode removed = tail;
        detachNode(removed);

        nodeMap.remove(removed.key);

        // System.out.println("Removed : " + removed.key + " -> " + removed.value);

        return removed;
    }
}
