import java.util.Scanner;

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

    public boolean movePlayer(Player player, int row, int col) {
        if (this.board.makeMove(row, col, player.getSymbol())) {
            this.board.printBoard();
            return true;
        } else {
            System.out.println("Invalid move.");
            return false;
        }

    }

    public boolean winChecker(Player player, int row, int col) {
        char[][] board = this.board.getBoard();
        char symbol = player.getSymbol();
        //check the row
        if (board[row][0] == symbol && board[row][1] == symbol && board[row][2] == symbol) {
                return true;
        }
        //check columns
        if (board[0][col] == symbol && board[1][col] == symbol && board[2][col] == symbol) {
            return true;
        }
        //check diagonals
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }
        return false;
    }

    public boolean drawChecker() {
        if (this.board.getRemainingMoves() == 0) {
            return true;
            }
        return false;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        outerLoop:
        while (this.state == GameState.RUNNING) {
            for (Player currentPlayer : new Player[]{player1, player2}) {
                boolean validInput = false;
                while (!validInput) {
                    try {
                        String playerName = currentPlayer.getName();
                        System.out.println("Player " + playerName + ", enter your move as 'row,col':");
                        String input = scanner.nextLine();
                        String[] parts = input.split(",");
                        if (parts.length != 2) {
                            throw new IllegalArgumentException("Invalid input format. Please enter your move as 'row,col'");
                        }
                        int row = Integer.parseInt(parts[0].trim());
                        int col = Integer.parseInt(parts[1].trim());

                        if (!this.movePlayer(currentPlayer, row, col)) {
                            throw new IllegalArgumentException("Move not possible. Cell is already occupied or out of range.");
                        }
                        if (winChecker(currentPlayer, row, col)) {
                            System.out.println("Player " + playerName + " wins!");
                            if (currentPlayer == player1) {
                                this.state = GameState.PLAYER1_WINS;
                                break outerLoop;
                            } else if (currentPlayer == player2) {
                                this.state = GameState.PLAYER2_WINS;
                                break outerLoop;
                            }
                        }
                        if (drawChecker()) {
                            System.out.println("Game is a draw, better luck next time.");
                            this.state = GameState.DRAW;
                            break outerLoop;
                        }
                        validInput = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Both the row and the column should be numbers. Please try again.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Invalid input format. Please enter your move as 'row,col'");
                    }
                }
            }
        }
        scanner.close();
    }
}
