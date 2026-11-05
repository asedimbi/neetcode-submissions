class Solution {
    public boolean isAnagram(String s, String t) {

        //We need freq of each char. have to store it first
        //then compare the second string.
        //If lengths are not same, by default they are not same.
        //if lengths are same, just iterate length() times to make maps
        // compare maps

        //follow up, we are using two loops and two maps. extra space, extra iteration.
        //can this be reduced.

        //Constraints:
        // same keys, same freq, order is not imp. Map will work
        // better to do null check?
        // char set is only lower case eng letters. not a concern.

        Map<Character, Integer> sStringFreq = new HashMap<>();
        Map<Character, Integer> tStringFreq = new HashMap<>();
        // can we have better names?

        if(s.length() != t.length()){ // .length? or .length()?
            return false;
        }

        for(int i=0; i<s.length(); i++){
            sStringFreq.merge(s.charAt(i), 1, Integer::sum);
            tStringFreq.merge(t.charAt(i), 1, Integer::sum);
        }

        //loop over and check values for each key
        for(Character sKey : sStringFreq.keySet()){

            if(!sStringFreq.get(sKey).equals(tStringFreq.getOrDefault(sKey, 0))){
                return false;
            }
        }

        //can tStringFreq have additional keys than sStringFreq?
        //if so, the counts should differ at least once.

        return true;

    }
}
