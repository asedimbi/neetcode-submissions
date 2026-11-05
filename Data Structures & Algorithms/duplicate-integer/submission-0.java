class Solution {
    public boolean hasDuplicate(int[] nums) {

        /* constraints :
        * primitive ints. pos or negative or zero. premitive so no nulls
        * frequence of any one number > 1 then true
        * Can we allocate extra space?
        * expected time complexity (guessing O(n) at least one pass over all data)
        * length can be upto 10^5
        * 

        * Watchout for:
        * var names, array limits
        * think of optimal data structures
        */

        /*
        * DataStructure: HashMap
        * {1->1, 2->1, 3->2 (break)}
        * make a key of each number as we pass
        * increment count of its occurences
        * when we find a >1 then we break the loop,
        * return true
        */

        //Define the Map DataStruc
        Map<Integer, Integer> numFrequency = new HashMap<>();

        //Iterate over nums. accrue count
        // key: num, value: freq
        for(int num : nums){
            numFrequency.put(num, numFrequency.getOrDefault(num, 0) + 1);
            //can use .merge() ?

            //Check if > 1
            if(numFrequency.get(num) > 1){
                return true;
            }
        }

        return false;
    }
}