class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        //maxheap the window mlog(m)
        //peak() to get answer at each iteration O(1)
        // add r, remove l -> O(m) + O(log(m))

        //Better approach
        // take the window into a double ended queue

        /*                              [1, 2, 1]     current max = 2
        *   offer(0)                    [1, 2, 1, 0]     current max = 2
        *   remove until current max        [2, 1, 0]    current max = 2
        *   offer(4)                        [2, 1, 0, 4]    current max = 4       
        *   remove until current max                 [4]    current max = 4
        *
        */
        if (nums == null || k <= 0 || k > nums.length) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Store indices, not values.
        // Values at these indices are in decreasing order.
        Deque<Integer> deque = new ArrayDeque<>();

        int j = 0;

        for (int i = 0; i < n; i++) {

            // 1. Remove indices outside the current window
            while (!deque.isEmpty()
                    && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 2. Remove smaller or equal values from the back
            // They cannot become the maximum while nums[i]
            // is still inside the window.
            while (!deque.isEmpty()
                    && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // 3. Add the current index
            deque.offerLast(i);

            // 4. Record maximum once a full window is formed
            if (i >= k - 1) {
                result[j] = nums[deque.peekFirst()];
                j++;
            }
        }

        return result;
    }
}
