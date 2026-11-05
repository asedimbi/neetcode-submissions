class Solution {
    public boolean isValidSudoku(char[][] board) {

        //basic intutition
        // rows can have blank values in intialization
        // cols can have blank values in intialization


        // loop 1 -> all row elements should be 0<k<10, and no repeatitions
        // loop 2 -> all col elements should be 0<k<10, and no repeatitions
        // loop 3 -> all 3x3 grid elements should be 0<k<10, and no repeatitions

        // 3x O(9*9) -> constant order

        
        for(char[] row : board){
            if(!isValidRow(row)){
                return false;
            }    
        }

        for(int j=0; j<9; j++){
            if(!isValidCol(board, j)){
                return false;
            }    
        }

        for(int j=0; j<9; j+=3){
            for(int i=0; i<9; i+=3){
              if(!isValidGrid(board, i,j)){
                return false;
              }   
            }
        }

        return true;
        
    }

    private boolean isValidRow(char[] row){
        
        int[] freqOneToNine = new int[]{0,0,0,0,0,0,0,0,0};
        for(char c : row){
            //get int value
            if(c == '.'){
                continue;
            }

            int num = Integer.parseInt(String.valueOf(c)); // we can use c - '0' instead
            //check elements are valid 0<k<10 - this is not needed. already guaranteed
            // if(num<1 || num>9){
            //     return false;
            // }

            freqOneToNine[num-1] += 1;
            if(freqOneToNine[num-1] > 1){
                return false;
            }
        }
        
        //check elements are unique

        return true;
    }

    private boolean isValidCol(char[][] board, int colIndex){
        //convert column to row and call the same method isValidRow
        char[] madeUpRow = new char[9];

        for(int i=0; i<9; i++){
            madeUpRow[i] = board[i][colIndex];
        }

        return isValidRow(madeUpRow);
    }

    private boolean isValidGrid(char[][] board, int rowIndex, int colIndex){

        //convert column to row and call the same method isValidRow
        char[] madeUpRow = new char[9];
        
        int k=0;
        for(int i=rowIndex; i<rowIndex+3; i++){
            for(int j=colIndex; j<colIndex+3; j++){
                madeUpRow[k] = board[i][j];
                k+=1;
            } 
        }

        return isValidRow(madeUpRow);
    }    


}
