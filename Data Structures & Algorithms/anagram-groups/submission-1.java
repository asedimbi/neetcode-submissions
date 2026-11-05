class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        //First thoughts:
        /*
        each word can have repeated chars, so we need to know the freq. not just set.
        If we make a map of each word, its going to be 10K maps in worst case

        for each map, we should go through and compare every other map. not good.

        Consider making a sorted string of each word.
        This can be the key, and we can have a value of words
        natrually just retrun the map.values()

        sorting each word -> checking if it is present in the map. 
        add sorted key word if not present.
        append to value array if exists.
        we need expandable storage, so ArrayList.
        output format is list. so that will be ok.

        if there are k chars in a word. sorting is klogk. and if there are n elements.
        we are passing once.

        so the complexity is O(n2logn)? we should revisit this
        space complexity is a map of size roughly equal to O(n)

        Question:
        what is the expected complexity?

        */

        Map<String, List<String>> anagrams = new HashMap<>();

        for(String word : strs){

            //make a sorted word
            char[] charsArray = word.toCharArray();
            Arrays.sort(charsArray);

            String anagramKey = new String(charsArray);

            //merge to map
            anagrams.putIfAbsent(anagramKey, new ArrayList<>());
            anagrams.get(anagramKey).add(word);

        }

        return new ArrayList<>(anagrams.values());

    }
}
