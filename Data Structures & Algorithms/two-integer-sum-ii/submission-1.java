class Solution {
    public int[] twoSum(int[] numbers, int target) {

        //array is sorted in non decending order
        // meaning it is ascending and at times could be equal through some length

        // given a target t
        // we can start with i=0 a
        // all we have to do is find the t-a in a sorted array

        //sounds like a binary search prob
        //we just have to start at i+1 and until len-1
        // if we find the mid point - this is going to be log(n)

        // that should be ok.
        //problem is we have to do this for every element in the array until we find some pair

        //it will be nlogn complexity using binary search

        //

        //better idea is to use "two pointers"
        //start with left and right at the array ends
        // if left + right < target, we need larger numbers so we will increment left side
        // if left + right > target, we need smaller numbers so we will decrement the right side

        int left=0, right = numbers.length - 1;
        
        while(left < right){
            int sum = numbers[left] + numbers[right];

            if(sum == target){
                return new int[]{left+1, right+1};
            }
            else if(sum < target){
                left++;
            }
            else{
                right--;
            }
            
        }

    return new int[]{};
    }
}
