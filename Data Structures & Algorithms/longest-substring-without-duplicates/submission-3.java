class Solution {
    public int lengthOfLongestSubstring(String s) {

        /*
        *   z 
        *       x 
        *           y z 
        *               x z 
        *                   z a b c 
        *                           c
        */

        //we need to add chars to set.
        //we need to know where repeated char happened
        //should we then keep a map?
        //

        //clearly a window problem
        //l, r window start and end
        //r keeps moving right as long as the window has unique chars
        //we can move l as long as the set does not become unique
        //remove is not a O(1) in set?

        //if we use a map, we are not reducing the windown correctly.
        //only use a set
        if(s == null || s.length() == 0){
            return 0;
        }

        Set<Character> window = new HashSet<>();

        int l = 0, r = 0, n = s.length();
        int maxWindowLen = 0;

        while(r < n){
            char start = s.charAt(l);
            char end = s.charAt(r);

            //try to add r to window
            if(window.contains(end)){
                //if window already contains r, remove l from set and l++;
                window.remove(start);
                l++;
            }else{
                //if window does not have r, add it 
                window.add(end);
                // System.out.println("Adding : " + end);
                // System.out.println("Set : " + window);

                //and compare maxWindowLen, r++;
                maxWindowLen = Math.max(maxWindowLen, window.size());
                r++;
            }
        }

       return maxWindowLen; 
    }
}
