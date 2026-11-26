class Solution {
    public int findDuplicate(int[] nums) {
        
        int slow = 0;
        int fast = 0;

        // Phase 1: Find a meeting point inside the cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find the cycle entrance
        int slow2 = 0;

        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
        
    }
}
