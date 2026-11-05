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

        if (s1 == null || s2 == null) {
            return false;
        }

        int m = s1.length();
        int n = s2.length();

        if (m > n) {
            return false;
        }

        int[] freqS1 = new int[26];
        int[] freqWindow = new int[26];

        // Initialize target and first window
        for (int i = 0; i < m; i++) {
            freqS1[s1.charAt(i) - 'a']++;
            freqWindow[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(freqS1, freqWindow)) {
            return true;
        }

        // Slide window one character at a time
        for (int r = m; r < n; r++) {

            int l = r - m;

            // Remove outgoing character
            freqWindow[s2.charAt(l) - 'a']--;

            // Add incoming character
            freqWindow[s2.charAt(r) - 'a']++;

            // Compare frequencies
            if (Arrays.equals(freqS1, freqWindow)) {
                return true;
            }
        }

        return false;
    }
}
