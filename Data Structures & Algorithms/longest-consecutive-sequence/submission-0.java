class Solution {
    public int longestConsecutive(int[] nums) {
        
        //what if we take a double ended queue
        //do a one pass on the input array
        // place nums[0] '2' in the queue head
        // move to nums[1] 20 is +18, so we insert 18 '.' into the queue and then place the '20'
        // move to nums[2] 4 is -16 from 20, so we insert 16 '.'

        //ohh.. we cannot insert in the middle of a queue.

        //linked list is a possiblity. but a lot of space.

        //we likely cannot initialize an array from -10^9 to 10^9 

        //If we use a set to convert array into a set
        // 2 is a starting point because 2-1 does not exist
        // keep checking if 2+1 = 3 exists in the set and count it as length
        // when counter+1 does not exist aymore, we have the local max lenght. compare and set global max length

        // when we get to 3,
        // 3-1 = 2 exists in the set, so 3 is not starting point, we can skip.

        int longestSeqLen = 0;

        Set<Integer> numSet = new HashSet<>();
        for(int num: nums){
            numSet.add(num);
        }

        for(int num : numSet){

            if(numSet.contains(num-1)){
                //not a starting point. continue to next
                continue;
            }

            int localSeqLen = 1;
            for(int i=num; numSet.contains(i+1); i++){
                localSeqLen += 1;
            }

            longestSeqLen = Math.max(longestSeqLen, localSeqLen);

        }

        return longestSeqLen;

    }
}
