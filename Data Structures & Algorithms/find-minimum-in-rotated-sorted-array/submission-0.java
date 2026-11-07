class Solution {
    public int findMin(int[] nums) {

        //1 2 3 4 5 6
        //5 6 1 2 3 4

        // min is where the number dips
        // nums[i] > nums[i+1]
        // return nums[i + 1]

        // O(n)

        //if everything was sorted you could find a number in logn time
        // number we are finding is the one where nums[mid] < nums[mid-1]

        //left  <   right  (already in sorted)
        //left == right () (left should increase)
        //left > right (reduce right)

        //5 6 7 2 3 4
        //l   m     r  5>4 (reduce right) at mid we have nums[mid] > nums[mid-1]
        //


        //    7 8 9 10 11 12 13 14 15 16 17 18 1 2 3 4 5 6

        //  mid = 15 : mid > left; mid > right --> move left to mid
        //  mid = 1  : mid < left; mid < right --> move right to mid
        // mid = 17  : mid > left; mid > right --> move left to mid
        // mid = 18  : mid > left; mid > right --> check if nums[mid] > nums[mid + 1]


            int l = 0;
            int r = nums.length - 1;

            while (l < r) {
                int m = l + (r - l) / 2;
                if (nums[m] < nums[r]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return nums[l];
        }
}
