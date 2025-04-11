import java.util.Scanner;

public class ConnectFour {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static char[][] board = new char[ROWS][COLS];
    private static boolean isPlayerOneTurn = true;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        initBoard();
        displayBoard();

        while (true) {
            makeMove(keyboard);
            displayBoard();

            // char winner = checkWinner();
            // if (winner == 'X') {
            //     System.out.println("Player 1 (X) wins!");
            //     break;
            // } else if (winner == 'O') {
            //     System.out.println("Player 2 (O) wins!");
            //     break;
            // } else if (checkDraw()) {
            //     System.out.println("It's a draw!");
            //     break;
            // }
        }

        // keyboard.close();
    }

    public static void initBoard() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                board[r][c] = ' ';
            }
        }
    }

    public static void displayBoard() {
        System.out.println();
        for (int r = 0; r < ROWS; r++) {
            System.out.print("|");
            for (int c = 0; c < COLS; c++) {
                System.out.print(board[r][c] + "|");
            }
            System.out.println();
        }
        System.out.println(" 0 1 2 3 4 5 6");
    }

    public static void makeMove(Scanner keyboard) {
        int col = -1;
        char currentPlayer = isPlayerOneTurn ? 'X' : 'O';
    
        while (true) {
            System.out.print("Player " + (isPlayerOneTurn ? "1 (X)" : "2 (O)") + ", choose a column (0–6): ");
            String input = keyboard.nextLine();
    
            try {
                col = Integer.parseInt(input);
                if (col < 0 || col >= COLS) {
                    System.out.println("Column out of range. Try again.");
                } else if (board[0][col] != ' ') {
                    System.out.println("Column is full. Try another.");
                } else {
                    // Place piece in lowest available row
                    for (int row = ROWS - 1; row >= 0; row--) {
                        if (board[row][col] == ' ') {
                            board[row][col] = currentPlayer;
                            break;
                        }
                    }
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 0 and 6.");
            }
        }

        isPlayerOneTurn = !isPlayerOneTurn;
    }

  
}
