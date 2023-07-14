public class GameBoard {
    private char[][] board;

    public GameBoard() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public boolean makeMove(int row, int col, char playerSymbol) {
        if (board[row][col] == '-') {
            board[row][col] = playerSymbol;
            return true;
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public char[][] getBoard() {
        return board;
    }

    public int getRemainingMoves() {
        int moveCount = 0;
        for(int i= 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    ++moveCount;
                }
            }
        }
        return moveCount;
    }
}

