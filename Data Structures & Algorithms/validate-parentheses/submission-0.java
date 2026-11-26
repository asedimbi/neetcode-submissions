class Solution {
    public boolean isValid(String s) {

        char[] chars = s.toCharArray();

        // System.out.println(chars);

        Map<Character, Character> pairs = new HashMap<>(Map.of(')','(', '}','{',']','['));
        Deque<Character> stack = new ArrayDeque<>();

        // System.out.println(pairs);
        for(char c1 : chars){
            if (!pairs.containsKey(c1)){
                stack.push(c1);
                System.out.println(stack);
            }else{
                if(stack.isEmpty())
                    return false;

                char c2 = stack.pop();
                // System.out.println(c1 +" "+c2);
                if (c2 != pairs.get(c1)){
                    return false;
                }
            }
        }

        if(!stack.isEmpty())
            return false;

        return true;
        
    }
}
