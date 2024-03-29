package game;

import java.util.Scanner;

import board.Board;
import player.Player;

public class Game {
    Player[] players;
    Board board;
    int turn;
    int noOfMoves;
    Boolean gameOver;
    String zero;
    String cross;

    public Game(Player[] players, Board board) {
        this.players = players;
        this.board = board;
        this.turn = 0;
        this.noOfMoves = 0;
        this.gameOver = false;

        StringBuilder z = new StringBuilder();
        StringBuilder c = new StringBuilder();

        for (int i = 0; i < board.size; i++) {
            z.append('O');
            c.append('X');
        }

        this.zero = z.toString();
        this.cross = c.toString();

    }

    public void printBoardConfig() {
        int sz = this.board.size;
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                System.out.print(this.board.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void play() {
        this.printBoardConfig();
        int sz = this.board.size;

        while (!this.gameOver) {
            this.noOfMoves++;
            int idx = getIndex();
            int row = idx / sz;
            int col = idx % sz;

            this.board.matrix[row][col] = players[turn].getPlayerSymbol();

            if (noOfMoves >= sz * sz) {
                System.out.println("Game Draw!!!");
                return;
            }

            if (noOfMoves >= 2 * sz - 1 && checkCombination() == true) {
                gameOver = true;
                printBoardConfig();
                System.out.println("Winner is: " + players[turn].getPlayerName());
                return;
            }

            turn = (turn + 1) % 2;
            printBoardConfig();
        }
    }

    public int getIndex() {
        while (true) {
            System.out.println("Player: " + players[turn].getPlayerName() + " give one position");
            Scanner scan = new Scanner(System.in);
            int px = scan.nextInt() - 1;
            int sz = this.board.size;
            int row = px / sz;
            int col = px % sz;

            if (row < 0 || row >= sz || col < 0 || col >= sz) {
                System.out.println("Invalid Position");
                continue;
            }

            if (board.matrix[row][col] != '-') {
                System.out.println("Position already occupied");
                continue;
            }

            return px;

        }

    }

    public boolean checkCombination() {
        int sz = this.board.size;

        // Row-Wise Checking
        for (int i = 0; i < sz; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sz; j++) {
                sb.append(this.board.matrix[i][j]);
            }
            String pattern = sb.toString();
            if (pattern.equals(this.zero) || pattern.equals(this.cross)) {
                return true;
            }
        }

        // Col-Wise Checking
        for (int i = 0; i < sz; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sz; j++) {
                sb.append(this.board.matrix[j][i]);
            }
            String pattern = sb.toString();
            if (pattern.equals(this.zero) || pattern.equals(this.cross)) {
                return true;
            }
        }

        // Diagonal Checking
        for (int i = 0; i < sz; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sz; j++) {
                if (i == j) {
                    sb.append(this.board.matrix[j][i]);
                }
            }
            String pattern = sb.toString();
            if (pattern.equals(this.zero) || pattern.equals(this.cross)) {
                return true;
            }
        }

        // Anti-Diagonal Checking
        for (int i = 0; i < sz; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sz; j++) {
                if (i == (sz - 1 - j)) {
                    sb.append(this.board.matrix[j][i]);
                }
            }
            String pattern = sb.toString();
            if (pattern.equals(this.zero) || pattern.equals(this.cross)) {
                return true;
            }
        }

        return false;
    }
}
