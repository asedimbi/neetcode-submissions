class Solution {
    public int[] twoSum(int[] nums, int target) {

        //there will be exactly one pair of numbers that satisfy nums[i]+nums[j] = target


        //Brute force:
        //double loop, and check sum is equal
        // O(n^2)

        //make a set of numbers in first pass
        //Pass over the array
        //For a nums[i] if the set contains target-nums[i] then we have the two number
        // , we can check in O(1) from the set
        //we will know i, but how do we know j?
        // we could use a map.
        // if we have repeated elements, we cannot use map or set
        // Actually we can. 

        /* When using a map, if the repeated elements are the pair
        we only need to know the location i of the first one.

        during single pass traversal, when we hit j,
        we can then know the complemntary value already happened at i
        and we saved it in the map as a -> i
        */

        Map<Integer, Integer> numFirstIndexMap = new HashMap<>();

        for(int j=0 ; j< nums.length ; j++){
            
            int complement = target - nums[j];

            if(numFirstIndexMap.containsKey(complement)){
                return new int[]{numFirstIndexMap.get(complement), j};
            }

            numFirstIndexMap.put(nums[j], j);
        }

        return new int[]{};
        
    }
}
