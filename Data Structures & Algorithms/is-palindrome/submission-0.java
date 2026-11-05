class Solution {
    public boolean isPalindrome(String s) {

        // make string into a char array and loop over it
        // measure length and use CharAt instead of wasting space

        // even length - progress until (int) mid point
        // odd length - progress until before (int) midpoint

        // only alpha numeric -> 0-9, a-z, A-Z
        // case insensitive - Character.toLowerCase(c) this means a-z covers A-Z

        //initialize a set? 
        // c -'a' gives the int value as 

        char digit = '0', alpha = 'a';
        Set<Character> alphaSet = new HashSet<>();

        for(int i=0; i<10; i++){
            alphaSet.add(digit);
            digit++;
        }
        for(int i=0; i<26; i++){
            alphaSet.add(alpha);
            alpha++;
        }
        // System.out.println(alphaSet);

        int i=0, end = s.length()-1;

        while(i<end){
            char front = Character.toLowerCase(s.charAt(i));
            char back = Character.toLowerCase(s.charAt(end));

            if(!alphaSet.contains(front)){
                i++;
                continue;
            }
            if(!alphaSet.contains(back)){
                end--;
                continue;
            }
            if(front != back){
                return false;
            }else{
                i++;
                end--;
            }

        }


        return true;
        
    }
}
