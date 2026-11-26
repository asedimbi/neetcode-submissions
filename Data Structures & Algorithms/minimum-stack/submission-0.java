class MinStack {

    Deque<Integer> stackAll;
    Deque<Integer> stackMins;

    public MinStack() {
        stackAll = new ArrayDeque<>();
        stackMins = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stackAll.push(val);

        if ( stackMins.isEmpty() || val <= stackMins.peek() ){
            stackMins.push(val);
        }
    }
    
    public void pop() {
        if(!stackAll.isEmpty()){
            int popped = stackAll.pop();

            if( !stackMins.isEmpty()){
                 if (popped == stackMins.peek() )
                    stackMins.pop();
            }else{
                System.out.println("StackMins is empty. Something went wrong!");
            }
        }else{
            System.out.println("StackAll is empty. Invalid pop operation");
        } 
    }
    
    public int top() {
        if(!stackAll.isEmpty())
            return stackAll.peek();
        else{
            System.out.println("StackAll is empty. Invalid pop operation");
            return Integer.MAX_VALUE;
        }
        
    }
    
    public int getMin() {
        if(!stackMins.isEmpty()){
            return stackMins.peek();
        }else{
            System.out.println("StackMins is empty. Invalid pop operation");
            return Integer.MAX_VALUE;
        }
        
    }
}
