class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // only lowercase a to z (26, constant time)

        //s1 has m letter
        //we could check in a sliding window of size m
        // if all char freq in s1, and all char freq in window are same
        // as we move the window, we can decrement the freq of that one dropped char
        // and increment the newly added char

        // how do we compare two maps?
        // we could do Arrays.equals with a freq array?
        // freq array is better

        if(s1 == null || s2 == null){
            return false;
        }
        
        int[] freqS1 = new int[26];
        int[] freqWindow = new int[26];

        int m = s1.length(), n = s2.length();
        int l = 0, r = l + m - 1;

        // System.out.println("l : "+l + " r : " + r + " m : " + m + " n : " + n);

        if(n < m){
            return false;
        }

        for(char c : s1.toCharArray()){
            freqS1[c - 'a']++;
        }

        for(char c : s2.substring(l, r+1).toCharArray()){
            freqWindow[c - 'a']++;
        }

        while(l <= n - m){
            
            if(Arrays.equals(freqS1, freqWindow)){

                return true;

            }else{

                char c = s2.charAt(l);
                freqWindow[c - 'a']--;
                l++; 

                r++;
                if(r >= n){
                    break;
                }else{
                    char d = s2.charAt(r);
                    freqWindow[d - 'a']++;
                } 

            }
        }

    return false;        
    }
}
