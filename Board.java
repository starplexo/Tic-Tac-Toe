
public class Board {
    private String[][]board;
    private int turn;

    //initializes board and turn
    public Board(){
        board = new String[3][3];
        for (String[] row : board) {
            for (int j = 0; j < row.length; j++) {
                row[j] = "-";
            }
        }
        turn = 0;
    }

    //returns what turn it is
    public int getTurn(){
        return turn;
    }
    
    //main function that handles the turns between players
    //returns if the placeCheck function was accepted
    public boolean takeTurn(String player1sym, String player2sym, int row, int col) {
        boolean success;
        if (turn % 2 == 0) {
            success = placeCheck(player1sym, row, col);
        } else {
            success = placeCheck(player2sym, row, col);
        }

        if (success) {
            turn++;
        }

        return success;
    }
    //Checks if the turn is past 9
    public boolean checkTurn(){
        return turn < 9;
    }

    //places check on board
    public boolean placeCheck(String check, int row, int col) {
        //Makes sure that the use can enter 1,1 or 2,2 without being flagged. Good for non cs students
        int boardRow = row - 1;
        int boardCol = col - 1;
        //prerequisite that the inputted row and coluum is able to be placed on the board
        if (boardRow < 0 || boardRow >= board.length ||
            boardCol < 0 || boardCol >= board[0].length) {
            System.out.println("Invalid board position: " + row + ", " + col + " (enter 1-3)");
            return false;
        }
        //checks if the board is already occupied by check if there isnt a "-" there
        if(!"-".equals(board[boardRow][boardCol])){
            System.out.println("Board position already occupied: " + row + ", " + col);
            return false;
        }

        board[boardRow][boardCol] = check;
        //returns true if there was a success
        return true;
    }
    //Prints board using a enhanced for loop
    public void printBoard(){
        for (String[] row : board) {
            for (String element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
    }
    }
    //checks all 8 win conditions
    public boolean checkWin(String check){
        //row check
        for(int i = 0; i < board.length; i++){
            if(board[i][0].equals(check) && board[i][1].equals(check) && board[i][2].equals(check)){
                return true;
            }
        }
        //coluum check
        for(int j = 0; j < board[0].length; j++){
            if(board[0][j].equals(check) && board[1][j].equals(check) && board[2][j].equals(check)){
                return true;
            }
        }
        // diagonal left to right check
        if(board[0][0].equals(check) && board[1][1].equals(check) && board[2][2].equals(check)){
            return true;
        }
        // diagonal right to left check
        if(board[0][2].equals(check) && board[1][1].equals(check) && board[2][0].equals(check)){
            return true;
        }

        return false;
    }
}
