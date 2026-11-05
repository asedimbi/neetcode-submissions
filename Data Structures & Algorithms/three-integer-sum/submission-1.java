class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // //3 sum  is an extra loop over two sum?

        // //lets loop i,j,k
        // // nums[i] picks a number
        // // target - nums[i] is the subTarget

        // // we can use 2-sum problem to find the subTarget in the array that is to the right of i
        // // i+1 to the end
        
        // Set<List<Integer>> uniqueTriplets = new HashSet(); //set can hash a List not a primitive array
        
        // int target = 0;

        // for(int i=0; i < nums.length; i++){
            
        //     Map<Integer, Integer> indexMap = new HashMap<>();

        //     int subTarget = target - nums[i];

        //     for(int j=i+1; j < nums.length; j++){

        //         int complement = subTarget - nums[j];

        //         if(indexMap.containsKey(complement)){
                    
        //             int[] tr = new int[]{nums[i], nums[j], complement};
        //             Arrays.sort(tr);

        //             List<Integer> triplet = Arrays.asList(tr[0], tr[1], tr[2]);

        //             uniqueTriplets.add(triplet);

        //        }else{
        //          indexMap.put(nums[j], j);
        //        }
        //     }
        // }

        // return new ArrayList<>(uniqueTriplets);    

        /********************* Two Pointer Best Approach ********************

        Firstly, any of the above solutions are still O(n^2)
        Meaning, if you sort the array with a nlog(n), that is going to be okay.

        so.

        1. Sort the array
        2. consider starting with an outer loop of one number at index i=0
        3. the problem now is to just find the target - nums[i] in a 2-sum
        4. the array to the right is already sorted
        5. so you can use a left and right pointer
        6. if the sum is <, move left, if it is >, move right, if equal we have
            answer
        7. To get unique results. since the array is sorted, skip the numbers
           that are same as prev one.

        */

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        int target = 0;

        for(int i=0; i<nums.length; i++){

                //for a sorted array
                //if already the first num is greater than target, 
                //no point checking further

                if(nums[i]>target) break;

                //if already seen then skip
                if(i > 0 && nums[i] == nums[i-1]) continue;

                //use left and right two-pointers
                int l = i + 1, r = nums.length - 1;

                while (l < r){
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum < target)
                        l++; // move left
                    else if (sum > target)
                        r--; // move right
                    else{
                        result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        l++;
                        r--;
                        //move left and right


                        while(l < r && nums[l] == nums[l-1]){
                            l++; // on the left side, skip till we see new number
                        }

                    }
                }
        }
        return result;
    }
}
