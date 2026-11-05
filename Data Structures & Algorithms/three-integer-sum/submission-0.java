class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        //3 sum  is an extra loop over two sum?

        //lets loop i,j,k
        // nums[i] picks a number
        // target - nums[i] is the subTarget

        // we can use 2-sum problem to find the subTarget in the array that is to the right of i
        // i+1 to the end
        
        Set<List<Integer>> uniqueTriplets = new HashSet(); //set can hash a List not a primitive array
        
        int target = 0;

        for(int i=0; i < nums.length; i++){
            
            Map<Integer, Integer> indexMap = new HashMap<>();

            int subTarget = target - nums[i];

            for(int j=i+1; j < nums.length; j++){

                int complement = subTarget - nums[j];

                if(indexMap.containsKey(complement)){
                    
                    int[] tr = new int[]{nums[i], nums[j], complement};
                    Arrays.sort(tr);

                    List<Integer> triplet = Arrays.asList(tr[0], tr[1], tr[2]);

                    uniqueTriplets.add(triplet);

               }else{
                 indexMap.put(nums[j], j);
               }
            }
        }

        return new ArrayList<>(uniqueTriplets);        
    }
}
