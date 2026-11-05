class Solution {
    public int trap(int[] height) {

        //at every index if we know what is the max bar to its left
        // and what is the max bar to its right

        //so all we have to do is pass along the array once to find left maxes
        //then pass along the array to find the right maxes
        //and then store the maxes into separate arrays

        //what is leftmax? max(left, leftMaxUntil then)
        
        //null and empty check + return
        if(height == null || height.length < 3){
            return 0;
        }
        
        int n = height.length;



        int[] leftMaxHeights = new int[n];
        int[] rightMaxHeights = new int[n];

        for(int i = 1; i < n; i++){
            leftMaxHeights[i] = Math.max(height[i-1], leftMaxHeights[i-1]);
        }

        for(int j = n-2; j >= 0; j--){
            rightMaxHeights[j] = Math.max(height[j+1], rightMaxHeights[j+1]);
        }

        // System.out.println(Arrays.toString(height));
        // System.out.println(Arrays.toString(leftMaxHeights));
        // System.out.println(Arrays.toString(rightMaxHeights));

        int waterAccumulated = 0;
        for(int k = 0; k < n; k++){
            int minHeightOnSides = Math.min(leftMaxHeights[k], rightMaxHeights[k]);
            int waterColumn = minHeightOnSides - height[k];
            if(waterColumn > 0){
                waterAccumulated +=  waterColumn;
            }
            // System.out.println("At index k = "+ k + " waterAccumulated = " + waterAccumulated);
        }

        return waterAccumulated;

    }
}
