public class Nqueens {
    public static void main(String[] args) {
        int n=4;
        boolean[][] maze = new boolean[n][n];
        System.out.println(queens(maze,0));
    }

    static int queens(boolean[][] board, int row) {
        //base condition
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }

        int count=0;
        // we are now placing the queeen and checking for every row and column
        for (int col = 0; col < board.length ; col++) {
            //place the queen if its safe
            if(isSafe(board,row,col)){
                board[row][col] = true;
                //agar q wahha safe h toh place it there and make the elemnt=true
                // meaning we have placed the queen
                count += queens(board,row+1);
                board[row][col] = false;
            }
        }
         return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {

        // check all the false cases edge
        //vertical col
        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                //if there is a queen already placed there , gr thats true pehle se
                return false;
            }
        }

        //diagonal left
        int maxLeft = Math.min(row,col);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row-i][col-i]){
                // if its already true or a queen is placed already
                return false;
            }
        }

        //diagonal right
        int maxRight = Math.min(row, board.length-col-1);
        for (int i = 1; i <= maxRight; i++) {
            if(board[row-i][col+i]){
                // if its already true or a queen is placed already
                return false;
            }
        }

        return true;
    }

    static void display(boolean[][] board) {
        for(boolean[] row : board){
            for(boolean element : row){
                if(element){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

}
