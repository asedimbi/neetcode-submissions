class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        //Top K is a hint to imagine heaps/ priorityqueue

        //if we make a map of (k,v) pairs
        //if we use a TreeMap that can keep sorted elements all the time
        //if we use Comparator to sort based on the v, descending
        //we could just return a sub list of k elements from the treeMap.keys()
        // but we cannot make a tree map that sorts based on values, tree map sorts based on keys

        //Even for the priority queue approach,
        //once we make a map with freq
        //we should reinsert each element into the PQ?
        //then poll them out?
        //yes this seems the most logical
        //use a map to get frequencies and build a PQ to poll k top elements

        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num: nums){
            freqMap.merge(num, 1, Integer::sum);
        }

        Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(
            b.getValue(), a.getValue()
        ));

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            maxHeap.offer(entry);
        }

        int[] result = new int[k];

        for(int i=0; i<k ; i++){
            result[i] = maxHeap.poll().getKey();
        }
        
        return result;

    }
}
