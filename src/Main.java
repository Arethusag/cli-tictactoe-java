// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Player player1 = new Player("Alice", 'X');
        Player player2 = new Player("Bob", 'O');
        TicTacToe game = new TicTacToe(player1,player2);
        game.playGame();
    }
}