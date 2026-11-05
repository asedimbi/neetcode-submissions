class Solution {
    public int characterReplacement(String s, int k) {

        //Sliding window
        //As we keep going over elements
        //add element into a frequency map
        //whenever we add an element to the map
        //we store its frequency
        //we immediately compare its frequency with the
        //max frequency
        //if all chars so far are same, we get windowsize same
        // as the maxFreq
        //but when there are few different chars
        //the windowsize - maxfreq will be some pos number
        //we can allow this num to grow until k
        //if the number equals k we should no longer increase the window
        //instead we should shrink the window from the left
        //when we shrink the window we should reduce the freq of that char in the map
        //what happens to max freq? how do we recalculate it?
        //this is not needed and can become stale
        //the varibale represents the max frequency observed so far and not the max freq in the current window
        //it will still give the correct answer and help avoid the cases where current window can have two or more chars that have same frequency.

        //AAAABBCC k = 2

        //AAAABB -> valid window, maxObservedSoFar = 6
        
        //slide window

        //(A)  AAABBC -> maxObservedSoFar = 4 still
        // replacements possible is 6-4 = 2
        // replacements are the last B,C 
        // AAABAA -> this is practically invalid
        // but for computation of max window size, we will still be seeing max possible window size is 6, if we for a second ignore the window is invalid.
        // this works out only because we were asked the max size of the window and not the window itself as the solution


        // instead, I can use a hashMap and re calculate the maxfreq every window.
        // the map size will be max of 26 A to Z chars hence 
        // iterating over it will be of constant time

        // this approach is easier to explain
        // and if i need to print the window, I can do that


        Map<Character, Integer> freq = new HashMap<>();

        int result = 0;

        int l = 0, r = 0, currMaxFreq = 0, n = s.length();
        while(r < n){ //XYY X
            char c = s.charAt(r); //X

            freq.put(c, freq.getOrDefault(c, 0) + 1); // X -> 1, Y -> 2
            currMaxFreq = Math.max(currMaxFreq, freq.get(c)); //2
            
            //compare window length - max freq to available replacements
            while((r - l + 1) - currMaxFreq > k){  // (3-2+1) > 2 false
                //we crossed the limit, we have to move l forward        

                //remove char at l from the map and reduce its freq.
                char rem = s.charAt(l); //Y
                freq.put(rem, freq.getOrDefault(rem, 0) - 1); //X -> 1, Y -> 1

                //check map values and reset curr max freq.
                //this is O(26) constant operation
                currMaxFreq--; //1
                for(int v : freq.values()){
                    currMaxFreq = Math.max(currMaxFreq, v); //1
                }

                l++; //2
            }

            result = Math.max(result, (r-l+1)); //2

            r++; //2
        } 


    return result;
        
    }
}
