class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        // each index takes 1/k hours
        // total time to finish the array of piles = n/k hours
        // total number of bananas to 


        // we have to eat everything within h hours
        // if h == 1, then there can be only one size of the array
        // if the array size is n
        // then you will need atleast n hours

        // if h<n then it is impossible to finish
        // if n == n, then we should give the max value of the array as the rate
        // if h > n then we have some buffer time to spare
        // your k should be smallest
        // say if n = 4 and h = 9
        // pile can have 0 bananas, so not time needed over there
        // if you eat the largest pile in 1 hr, then the time needed is always equal to n = h
        // how to minimize k
        // 
        
        // h == n return max int

        // h > n
        // we have to spend 1 hr min on each index where the value is non zero

        // to eat a pile with x bananas, the max time we have 

        if (piles == null || piles.length == 0) {
            return 0;
        }

        int m = Integer.MIN_VALUE;
        for(int n : piles){
            m = Math.max(m, n);
        }

        // System.out.println("m : " + m);

        //max no of bananas in the array is m
        //upper limit of k is m
        //we could choose lower limit as 1

        // between 1 to m we need to find the min possible value of k

        //time to eat all bananas at rate k
        int low = 1, high = m;
        int res = m;
        while(low <= high){
            int k = (low + high) / 2;
            // System.out.println("k: " + k);

            int timeNeeded = 0;
            for(int x : piles){
            //there are x bananas in this pile. we are eating at k per hour
            // time taken is ceil(x/k)
            timeNeeded += Math.ceil((double) x / k);
                // System.out.println("x: "+ x + " k : "+ k +" Loop - timeTaken : " + timeTaken);
            }


            // System.out.println("low, high, k, h, timeNeeded : " 
            // + low + " " + high + " " + k + " " + h + " " + timeNeeded);

            if(timeNeeded <= h){
                res = k;
                high = k - 1;
            }else{
                low = k + 1;
            }
        }

        return res;

    }

}
