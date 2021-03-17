package com.john_haney.engine;

import java.util.Arrays;

public class GameBoard {

    private int dimension;
    private char[][] board;

    public GameBoard(int dimension) {
        this.dimension = dimension;
        generateBoard();
    }

//-------------------------public methods----------------------

    /**
     * prints board to console
     */
    public void displayBoard() {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println("");
        }
    }

    public boolean hasWinner() {
        return true;
    }

    /**
     * Checks to see if a row has a full set of X's or O's
     *
     * @param row an char array representing one row
     * @return true if row has winner
     */
    public boolean hasRow(char[] row) {
        int count = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] == '-') {
                return false;
            } else if (row[i] == 'X') {
                count++;
            } else {
                count--;
            }
        }
        if (Math.abs(count) == getDimension())
            return true;
        else
            return false;
    }

    public boolean hasColumn(char[][] gameBoard) {
        Boolean winner = false;
        Integer column = 0;

        for (int i = gameBoard.length-1; i >= 0; i--) {
            column = 0;
            for (int j = 0; j < gameBoard.length; j++) {
                System.out.print(gameBoard[j][i]);
                if(gameBoard[j][i] == '-'){
                    continue;
                }else if(gameBoard[j][i] == 'X'){
                    column++;
                }else{
                    column--;
                }
            }
            if(Math.abs(column) == getDimension()){
                return true;
            }
            System.out.println("");
        }
        return false;
    }

//------------------private methods----------------------------

    /**
     * Initializes board and fills board matrix with characters that will form board when printed
     */
    private void generateBoard() {
        char[][] b = new char[dimension][dimension];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                b[i][j] = '-';
            }
        }
        this.board = b;
    }

    public void printBoardSize() {
        System.out.println(board.length);
    }

    /* -------------------- Getters and Setters ----------------*/

    public int getDimension() {
        return dimension;
    }

    public char[][] getBoard() {
        return board;
    }
}
