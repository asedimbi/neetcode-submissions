class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0){
            return false;
        }

        //binary search on the first column.
        //we either find the mid matches the number
        // or we find the target is between mid and mid-1 or mid and mid +1
        // we then have to binary search that one row

        //how to access first column digits in a 2d Matrix?
        //00 10 20 30 .. keep j = 0 on the outer loop

        int top = 0, bottom = matrix.length - 1;
        int flag = 0;

        int row = -1;

        while(top <= bottom){
            
            int midRow = (top + bottom) / 2;

            System.out.println("top, bottom, midRow, matrix[midRow][0] : " +
            top+ " " + bottom + " "+ midRow + " " + matrix[midRow][0]);

            if(target == matrix[midRow][0]){
                return true;
            }else if(target < matrix[midRow][0]){
                if(midRow == 0){
                    row = midRow;
                    break;
                }
                else if(target > matrix[midRow - 1][0]){
                    row = midRow-1;
                    break;
                }
                bottom = midRow - 1;
            }else if(target > matrix[midRow][0]){
                if(midRow == matrix.length -1){
                    row = midRow;
                    break;
                }
                else if(target < matrix[midRow + 1][0]){
                    row = midRow;
                    break;
                }
                top = midRow + 1;
            }
        } //logm times

        System.out.println("row to search : " + row);

        if(row == -1){
            return false;
        }

        int l = 0, r = matrix[row].length - 1;

        while(l <= r){

            int mid = (l + r) / 2;

            System.out.println("row, left, right, mid, matrix[row][mid] : " 
            + row + " "+ l + " " + r + " " + mid + " " + matrix[row][mid]);

            if(target == matrix[row][mid]){
                return true;
            }else if(target < matrix[row][mid]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return false;
    }
}
