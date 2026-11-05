class Solution {
    public int maxArea(int[] heights) {

        /*
        Intuition:

        we should always know what is left height and what is right heigth
        difference between indexes is the width.

        which ever is the taller of the two heigths can stay
        the other one can move

        start at left and right extremes
        find volume (min(lh, rh) * r-l)
        maxVol = Max(maxVol, currVol)
        //because we do not need the indexes



        */

        int l = 0, r = heights.length - 1; //two pointers left and right
        int maxWater = 0;

        while (l < r){

            int currWater = Math.min(heights[l], heights[r]) * (r - l);
            maxWater = Math.max(maxWater, currWater);

            if(heights[l] <= heights[r]){
                l++;
            }
            else if (heights[l] > heights[r]){
                r--;
            }
        }
        
        return maxWater;
        
    }
}
