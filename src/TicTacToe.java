
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

    public boolean movePlayer(Player player, char row, char col) {
        this.board.makeMove(row,col, player.getSymbol());
    }

    public boolean
}
