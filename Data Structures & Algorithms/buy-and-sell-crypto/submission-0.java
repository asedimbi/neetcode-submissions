class Solution {
    public int maxProfit(int[] prices) {
        
        //each ele is a price on a given day
        //if always loss, best not to sell ? or sell when equal to purchase?


        //brute force is to check every pair which is O(n^2)

        //we should atleast see every element once 
        //should not sort to keep days order

        //we need a section of array that has diff of start and end as max
        //start should be smaller
        //end should be as bigger as possible

        //start at first ele i = 0
        //check j = i+1 onwards
        //if you have a much smaller start, move i to right
        //if right of start is > start then move end

        //null and empty check
        if(prices == null || prices.length < 1){
            return 0;
        }

        //Wrong approach.
        // int smallestBuy = Integer.MAX_INT;
        // int largestSell = Integer.MIN_INT;
        // int maxProfit = 0;

        // for(int i = 0; i < prices.length; i++){

        //     smallestBuy = Math.min(smallestBuy, prices[i]);
        //     largestSell = Math.max(largestSell, prices[i]);
        // }


        // return largestSell - smallestBuy; //problem is we are not making sure smallest buy is before the largest Sell.


        //Correct Approach

        //we should have a purchase day i, sell day j
        //keep increasing j as long as the price diff is positive and increasing
        //if the price diff is 0 or less, then there is no profit, we can move i to j position, and increment j to the next
        //we should check if j is within the limit

        //every time we have the maxProfit changed, we should try to record the i and j for possible future use

        int maxProfit = 0;
        int i = 0, j = 0;

        int[] maxProfitDays = new int[]{i, j};

        while (j < prices.length){

            int currProfit = prices[j] - prices[i];

            if(currProfit <= 0){
                i = j; //move window start
                j++;
                continue;
            }
            else{

                if(currProfit > maxProfit){
                    maxProfit = currProfit;
                    maxProfitDays = new int[]{i, j};
                }

                //keep checking for next sell day, keeping the same buy day
                j++;
            }
        
        }

        return maxProfit;
    }
}
