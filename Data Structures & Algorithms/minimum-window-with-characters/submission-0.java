class Solution {
    public String minWindow(String s, String t) {

        if(s == null || t == null){
            return "";
        }

        int m = s.length(), n = t.length();
        if(m < n){
            return "";
        }

        String minWindow = "";


        //make a map of t
        Map<Character, Integer> tFreq = new HashMap<>();
        for(char c : t.toCharArray()){
            tFreq.merge(c, 1, Integer::sum);
        }

        //make a HashMap for the window;
        Map<Character, Integer> tFreqWindow = new HashMap<>();

        //sliding window
        int l = 0, r = 0; //size of t
        while(r < m){
            
            //expand until valid window is obtained
            while(!isMatchingWindow(tFreqWindow, tFreq) && r < m){
                char c = s.charAt(r);
                tFreqWindow.merge(c, 1, Integer::sum); 
                r++;
            }

            //shrink as long as window remains valid
            while(isMatchingWindow(tFreqWindow, tFreq) && l < r){

                int windowLen = r - l; //r is already 1 ahead than required

                if(minWindow.isEmpty() || minWindow.length() > windowLen){
                    minWindow = s.substring(l, r);
                }

                char c = s.charAt(l);
                tFreqWindow.merge(c, -1, Integer::sum);
                l++;
            }

        }

        return minWindow;
    }


    //determine if window is valid
    private boolean isMatchingWindow(Map<Character, Integer> window, Map<Character, Integer> t){
        for(Map.Entry<Character, Integer> entry : t.entrySet()){
            char c = entry.getKey();
            int requiredCount = entry.getValue();

            if(window.getOrDefault(c, 0) < requiredCount) // greater count is also valid
                return false;
        }

        return true;
    }
}
