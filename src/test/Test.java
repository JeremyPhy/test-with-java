/*
Tick Tack Toe 
 */
package test;

import java.awt.*;
import java.util.*;

/**
 *
 * @author win8
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TTT game = new TTT();
        game.play();/*
        game.isBoardFull();
        game.isSpaceEmpty(0, 0);
        game.place(0, 0, 'X');
        game.printBoard();
        game.isSpaceEmpty(0, 0);*/
    }
}

class TTT {

    static Scanner sc = new Scanner(System.in);
    private char p1;
    private char p2;
    private char[][] board;
    private int currentPlayer;

    public TTT() {
        board = new char[3][3];
        initializeBoard();
        currentPlayer = 1;
    }

    public void play() {
        System.out.println("Let's Play Tick Tack Toe!");
        System.out.println("Player 1 pick your marker:");
        char choice = sc.nextLine().charAt(0);
        setPlayer(1, choice);
        System.out.println("Player 2 pick your marker:");
        choice = sc.nextLine().charAt(0);
        setPlayer(2, choice);
        printBoard();
    }

    public void initializeBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = '-';
            }
        }
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print("| " + board[r][c] + " ");
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }

    public boolean isBoardFull() {
        int count = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] != '-') {
                    count++;
                }
            }
        }
        if (count < 9) {
            System.out.println("The Board is not full.");
            return false;
        }
        return true;
    }

    public boolean checkForWin() {
        return false;
    }

    public boolean isSpaceEmpty(int r, int c) {
        if (board[r][c] == '-') {
            System.out.println("Space (" + r + "," + c + ") is empty");
            return true;
        }
        System.out.println("Space (" + r + "," + c + ") is not empty");
        return false;
    }

    public void place(int r, int c, char piece) {
        if (this.isSpaceEmpty(r, c)) {
            board[r][c] = piece;
        }
    }

    public void setPlayer(int player, char c) {
        if (player == 1) {
            p1 = c;
        } else {
            p2 = c;
        }
    }
}
