
public class TicTacToe {
    private GameBoard board;
    private Player player1;
    private Player player2;
    private GameState state;

    public TicTacToe(Player player1, Player player2) {
        this.board = new GameBoard();
        this.player1 = player1;
        this.player2 = player2;
        this.state = GameState.RUNNING;
    }

    public void movePlayer(Player player, char row, char col) {
        if (this.board.makeMove(row, col, player.getSymbol())) {
            this.board.printBoard();
        } else {
            System.out.println("Invalid move.");
        }

    }

    public boolean winChecker(Player player, char row, char col) {
        char[][] board = this.board.getBoard();

        //check the row
        if (board[row][0] == player.getSymbol() &&)
        }
    }
}
