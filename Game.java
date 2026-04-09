import java.util.Scanner;

class Game{
    public static void main(String[] args) {
        
        //Get all variables now
        Board board = new Board();
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Enter Player 1: ");
        String player1 = input.nextLine();
        
        System.out.println("Enter Player 1 symbol:");
        String player1sym = input.nextLine();
        
        System.out.println("Enter Player 2:");
        String player2 = input.nextLine();

        System.out.println("Enter Player 2 symbol:");
        String player2sym = input.nextLine();

        
        System.out.println("Let the games begin!");
        
        //Game loop
        while(!board.checkWin(player1sym) && !board.checkWin(player2sym) && board.checkTurn()){
            System.out.println("Current Board");
            board.printBoard();

            if(board.getTurn() % 2 == 0){
                System.out.println("It is " + player1 + "'s turn!");
            }else{
                System.out.println("It is " + player2 + "'s turn!");
            }

            //Makes sure that the rows and coluums entered are valid and redos the loop until a proper row and coluum is inputed
            boolean moveAccepted;
            do {
                System.out.println("Enter Row (1-3)");
                int row = input.nextInt();
                System.out.println("Enter Column (1-3)");
                int col = input.nextInt();

                moveAccepted = board.takeTurn(player1sym, player2sym, row, col);
                if (!moveAccepted) {
                    System.out.println("Invalid move. Try again.");
                }
            } while (!moveAccepted);
        }

        System.out.println("Final Board");
        board.printBoard();
        if(board.checkWin(player1sym)){
            System.out.println(player1 + " wins!");
        } else if(board.checkWin(player2sym)){
            System.out.println(player2 + " wins!");
        } else {
            System.out.println("It's a draw!");
        }

        input.close();
    }
}


