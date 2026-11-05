class Solution {
    public int[] productExceptSelf(int[] nums) {

        //brute force is to do O(n^2). for every element compute the product of rest of the array

        //what if we compute product first and then divide by every element
        // this will make a divide by 0 problem
        // can overcome this by skipping 0's when computing product and noting down we have a zero
        // but if there are multiple zeros, we need products in output to be 0

        //better solution is to think of computing
        // left product at every element in one pass
        // right product at every element in the reverse pass

        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            result[i] = 1; 
        }//Use Arrays.nCopies()?

        //Compute left side products in forward pass
        int leftProduct = 1;
        for(int i=1; i<nums.length; i++){
            leftProduct *= nums[i-1];
            result[i] = leftProduct;
        }
        // System.out.println("nums :" + Arrays.toString(nums));
        // System.out.println("after left :" + Arrays.toString(result));

        //compute rigt side products in reverse pass
        int rightProduct = 1;
        for(int i=nums.length-2; i>=0; i--){
            rightProduct *= nums[i+1];
            result[i] *= rightProduct;
        }
        // System.out.println("nums :" + Arrays.toString(nums));
        // System.out.println("after right :" + Arrays.toString(result));


        return result;
    }
}  
