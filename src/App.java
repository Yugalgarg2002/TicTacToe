import java.util.Scanner;

import board.Board;
import player.Player;
import game.Game;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("First Project -> Tic Tac Toe");

        Board b = new Board(3, '-');

        Scanner s = new Scanner(System.in);

        System.out.println("Enter Details of Player-1");
        System.out.print("Name: ");
        String p1_name = s.nextLine();
        System.out.print("Symbol: ");
        char p1_symbol = s.nextLine().charAt(0);
        Player p1 = new Player();
        p1.setPlayerNameAndSymbol(p1_name, p1_symbol);

        System.out.println("Enter Details of Player-2");
        System.out.print("Name: ");
        String p2_name = s.nextLine();
        System.out.print("Symbol: ");
        char p2_symbol = s.nextLine().charAt(0);
        Player p2 = new Player();
        p2.setPlayerNameAndSymbol(p2_name, p2_symbol);

        // System.out.println("\n");
        // System.out.println("Player-1 Details:");
        // System.out.println("Name: " + p1.getPlayerName());
        // System.out.println("Symbol: " + p1.getPlayerSymbol());
        // System.out.println("------------------------------------------");
        // System.out.println("Player-2 Details:");
        // System.out.println("Name: " + p2.getPlayerName());
        // System.out.println("Symbol: " + p2.getPlayerSymbol());

        Game game = new Game(new Player[] { p1, p2 }, b);
        game.play();

    }
}
