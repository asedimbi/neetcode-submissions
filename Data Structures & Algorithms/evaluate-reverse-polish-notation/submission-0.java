class Solution {
    public int evalRPN(String[] tokens) {

        Deque<Integer> stack = new ArrayDeque<>();
        int a,b;
        try{

            for(String token : tokens){

                switch (token) {
                    case "+" :
                        b = stack.pop();
                        a = stack.pop();
                        stack.push(a+b);
                        break;
                    case "-" :
                        b = stack.pop();
                        a = stack.pop();
                        stack.push(a-b);
                        break;
                    case "*" :
                        b = stack.pop();
                        a = stack.pop();
                        stack.push(a*b);
                        break;
                    case "/" :
                        b = stack.pop();
                        a = stack.pop();
                        stack.push(a/b);
                        break;
                    default:
                        stack.push(Integer.parseInt(token));
                }
            }
        }catch (Exception e){
            System.out.println("Something went wrong !!");
            return Integer.MIN_VALUE;
        }
        
        if(stack.size() != 1){
            System.out.println("Something went wrong !!");
            return Integer.MIN_VALUE;
        }

        return stack.pop();         
    }
}
