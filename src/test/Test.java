/*
Tick Tack Toe 
changes:


TODO:
create check for win method
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
        game.clear();
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
    private boolean p1turn;
    private char current;

    public TTT() {
        board = new char[3][3];
        initializeBoard();
        p1turn = true;
    }

    public void play() {
        clear();
        System.out.println("====Let's Play Tick Tack Toe!====");
        System.out.println("Press Enter to Continue");
        sc.nextLine();
        System.out.println("Player 1 pick your marker:");
        char choice = sc.nextLine().charAt(0);
        setPlayer(1, choice);
        System.out.println("Player 2 pick your marker:");
        choice = sc.nextLine().charAt(0);
        setPlayer(2, choice);
        clear();
        printBoard();
        do {
            turn();
            printBoard();
            p1turn = !p1turn;

        } while (!isBoardFull() && !checkForWin());
        System.out.println("board full.");
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
            //System.out.println("The Board is not full.");
            return false;
        }
        return true;
    }

    public boolean checkForWin() {
        boolean win = false;
        int count = 0;
        int r = 1;
        for (int c = 0; c < 3; c++) {
            if (board [r][c] == current)
                count++;
            if (count == 3){
                return true;
            }
        }
        
        return false;
    }

    public boolean isSpaceEmpty(int r, int c) {
        if (board[r][c] == '-') {
            //System.out.println("Space (" + r + "," + c + ") is empty");
            return true;
        }
        //System.out.println("Space (" + r + "," + c + ") is not empty");
        return false;
    }

    public void place(int r, int c) {
        char piece;
        if (this.isSpaceEmpty(r, c)) {
            if (p1turn) {
                piece = p1;
            } else {
                piece = p2;
            }
            board[r][c] = piece;
        }
    }

    public void turn() {
        int p;
        if (p1turn) {
            p = 1;
            current = p1;
        } else {
            p = 2;
            current = p2;
        }
        boolean valid = false;
        while (!valid) {
            System.out.println("Player " + p + "'s turn, place your marker (" + current + ")");
            System.out.print("Row: ");
            int r = sc.nextInt() - 1;
            System.out.print("Column: ");
            int c = sc.nextInt() - 1;
            if (r < 3 && c < 3 && this.isSpaceEmpty(r, c)) {
                valid = true;
                place(r, c);
                clear();
            } else {
                System.out.println("Coordinates Invalid, Please enter proper values");
            }
        }
    }

    public void setPlayer(int player, char c) {
        if (player == 1) {
            p1 = c;
        } else {
            p2 = c;
        }
    }

    public void clear() {
        for (int x = 0; x < 40; x++) {
            System.out.print("\n");
        }
    }
}

