class LRUCache {

    class Node {
        int key, value;
        Node next, prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> nodeMap;
    int capacity, len;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.len = 0;
        this.nodeMap = new HashMap<>();
    }

    public int get(int key) {

        if (!nodeMap.containsKey(key)) {
            return -1;
        }

        Node curr = nodeMap.get(key);

        // Access makes this node most recently used
        moveToHead(curr);

        return curr.value;
    }

    public void put(int key, int value) {

        // Existing key: update value and move to head
        if (nodeMap.containsKey(key)) {

            Node curr = nodeMap.get(key);
            curr.value = value;

            moveToHead(curr);
            return;
        }

        // New key: create and insert at head
        Node curr = new Node(key, value);

        nodeMap.put(key, curr);
        addToHead(curr);
        len++;

        // Evict least recently used node
        if (len > capacity) {
            removeLruTail();
        }
    }

    // Insert a node at the head (MRU)
    private void addToHead(Node curr) {

        curr.prev = null;
        curr.next = head;

        if (head != null) {
            head.prev = curr;
        }

        head = curr;

        // First node is both head and tail
        if (tail == null) {
            tail = curr;
        }
    }

    // Disconnect a node from its current position
    private void removeNode(Node curr) {

        Node left = curr.prev;
        Node right = curr.next;

        if (left != null) {
            left.next = right;
        } else {
            head = right;
        }

        if (right != null) {
            right.prev = left;
        } else {
            tail = left;
        }

        curr.prev = null;
        curr.next = null;
    }

    // Move existing node to MRU position
    private void moveToHead(Node curr) {

        if (curr == head) {
            return;
        }

        removeNode(curr);
        addToHead(curr);
    }

    // Remove LRU node
    private void removeLruTail() {

        if (tail == null) {
            return;
        }

        Node removed = tail;

        removeNode(removed);

        nodeMap.remove(removed.key);
        len--;
    }
}