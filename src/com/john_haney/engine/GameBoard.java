package com.john_haney.engine;


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
        for (char c : row) {
            if (c == '-') {
                return false;
            } else if (c == 'X') {
                count++;
            } else {
                count--;
            }
        }
        return Math.abs(count) == row.length;
    }

    /**
     * Checks a matrix to see if there is a winner by column. Rotates the Matrix onto its side to make more efficient.
     *
     * @param gameBoard A char array of the board
     * @return true if there is a winner by column
     */
    public boolean hasColumn(char[][] gameBoard) {
        int column;

        for (int i = gameBoard.length-1; i >= 0; i--) {
            column = 0;
            for (char[] chars : gameBoard) {
                if (chars[i] == 'X') {
                    column++;
                } else {
                    column--;
                }
            }
            if(Math.abs(column) == gameBoard.length){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks to see if the board has a winner is the diagonal directions.
     *
     * @param gameBoard A char matrix representation of the game board
     * @return true if there is a winner of either right or left diagonal
     */
    public boolean hasDiagonal(char[][] gameBoard){
        int diagonalL = 0;
        int diagonalR = 0;

        for(int i= 0; i< gameBoard.length; i++){
            for(int j = 0; j < gameBoard.length; j++){
                if(i == j){
                    if(gameBoard[i][j] == 'O'){
                        diagonalL++;
                    }else if(gameBoard[i][j] == 'X'){
                        diagonalL--;
                    }
                }
                if(i+j == gameBoard.length-1){
                    if(gameBoard[i][j] == 'O'){
                        diagonalR++;
                    }else if(gameBoard[i][j] == 'X'){
                        diagonalR--;
                    }
                }
            }
        }
        if(Math.abs(diagonalR) == gameBoard.length || Math.abs(diagonalL) == gameBoard.length)
            return true;
        else
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

    /**
     * prints out the dimensions of the board
     */
    public void printBoardSize() {
        System.out.println("This is a " + getBoard() +"X" + getBoard() + " board");
    }

    /* -------------------- Getters and Setters ----------------*/

    public int getDimension() {
        return dimension;
    }

    public char[][] getBoard() {
        return board;
    }
}
