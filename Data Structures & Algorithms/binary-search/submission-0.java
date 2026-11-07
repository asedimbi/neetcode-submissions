class Solution {
    public int search(int[] nums, int target) {

        if(nums == null || nums.length == 0){
            return -1;
        }

        int l = 0, r = nums.length - 1;
        // boolean found = false;
        
        while(l <= r) { // 3, 5
            System.out.println("l = " + l + " r = " +  r );

            int mid = (l + r) / 2;  // 4
            System.out.println("mid = " + mid + " nums[mid] = " +  nums[mid] );
            if (nums[mid] == target) {  //6 != 4
                return mid;
            } else if (nums[mid] < target) { // 2 < 4
                l = mid + 1; // l=3, r = 5
            } else { // 6 > 4
                r = mid - 1; //3
            }
        }

        
        return -1;
    }
}
