class Solution {
    public int search(int[] nums, int target) {

        //Find the pivot index

        //then find the target's location either in
        // left side segment to the pivot 
        // or the right side segmetn to the pivot

        //finding pivot
        System.out.println("Hello");
        int pivotIndex = -1;

        int l = 0, r = nums.length - 1;

        //[3,5,6,0,1,2]
        // 0         r=5  

        while(l < r){ // 0 < 5 true
            
            int mid = l + (r - l) / 2; //mid = 3
            System.out.println("l : " + l + " r : " + r + " mid : " + mid);

            if(nums[mid] < nums[r]){  //true 1 < 2
                r = mid;  // r = 3
            }else{
                l = mid + 1;  //l = 3
            }
        }
        
        pivotIndex = l;
        System.out.println("pivotIndex : " + pivotIndex);

        // pivot is the min element in the array
        if(target == nums[pivotIndex]){
            return pivotIndex;
        }else if(target <= nums[nums.length-1]){
            //binary search between pivot + 1 and n-1
            return binarySearch(nums, target, pivotIndex + 1, nums.length - 1);
        }else{
            //binary search between 0 and pivot-1
            
            return binarySearch(nums, target, 0, pivotIndex - 1);
        }

        // return -1;
    }

    private int binarySearch(int[] nums, int target, int l, int r){

        System.out.println("Here ! " );
        System.out.println("l : " + l + " r : " + r);

        // if(l == r && nums[l] == target){
        //     return l;
        // }
        // 0 , 2

        while(l <= r){
            int m = (l + r)/2; //0

            System.out.println("l : " + l + " r : " + r + " m : " + m);
            if(target == nums[m]){
                return m;
            }else if(target > nums[m]){
                l = m + 1; //0
            }else{
                r = m-1; // 1
            }
        }

        System.out.println("Not Found ! " );
        return -1;
    }
}
