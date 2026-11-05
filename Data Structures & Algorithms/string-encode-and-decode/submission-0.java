class Solution {

    public String encode(List<String> strs) {

        //needs to merge all words into one string

        StringBuilder encoderSb = new StringBuilder();
        for(String word : strs){
            encoderSb.append(word.length())
                     .append('#') //make the delimter a varaible
                     .append(word);
        }

        return encoderSb.toString();
    }

    public List<String> decode(String str) {

        //needs to divide a string into individual words
        //so there must be a separation char?
        //but what if data is same a separation char
        //what do we know about encoding and decoding?
        //there will be usually a header and payload in all transmission
        //i could use something like this
        /*
        *  [word1, word2, word3, ....]
        *    
        *  string builder
        *       String(word1.length) + word1
        *       String(word2.length) + word2
        *
            In the decoder, I can parse first char as int 
            then get sub string of that length, and append to output

            then again i can parse the next char as int
            then get sub string of that length, and append to output

        */

        List<String> result = new ArrayList<>();

        int i=0, limit = str.length();
        while(i<limit){
            //find the delimter char #
            int delimterIndex = str.indexOf('#', i); //gets the first index that was found.good

            //extract the word length and parse to integer
            String wl = str.substring(i, delimterIndex);  //substring returns a String
            int wordLen = Integer.parseInt(wl); //Integer.parseInt() takes a String input

            //extract the word based on the length starting after the delimiter char
            int startOfWordIndex = delimterIndex+1;
            int endOfWordIndex = startOfWordIndex+wordLen; //excluding

            //make the string word and add to the result
            String word = str.substring(startOfWordIndex, endOfWordIndex);
            result.add(word);

            i = endOfWordIndex;

        }

        return result;

    }
}
