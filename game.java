
import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';

            }
        }
        char player = 'X';
        boolean gameOver = false;
        Scanner in = new Scanner(System.in);

        while (!gameOver) {
            printboard(board);
            System.out.println("player " + player + " enter:");
            int row = in.nextInt();
            int col = in.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = player; //placing the element
                gameOver = haveWon(board, player);
                if (gameOver) {
                    System.out.println("Player" + player + "has won");
                } else {
                    if (player == 'X') {
                        player = 'O';
                    } else {
                        player = 'X';
                    }
                }
            } else {
                System.out.println("Invalid move. Try Again!");
            }
        }
    }

    public static void printboard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }


    public static boolean haveWon(char[][] board, char player) {
        //check for rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        //check for coloumns
        for (int col = 0; col < board.length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        //check for diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0]==player){
            return true;
        }
        return false;

    }
}