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

    /**
     *
     * @param gameBoard
     * @return
     */
    public boolean hasWinner(char[][] gameBoard) {
        char[] row;
        for(int i = 0; i < gameBoard.length; i++){
            row = extractRow(gameBoard, i);
            if(hasRow(row))
                return true;
        }
        if(hasColumn(gameBoard)) {
            return true;
        }else if(hasDiagonal(gameBoard)){
            return true;
        }
        return false;

    }

    /**
     * TODO: finish logic
     * @param gameBoard
     * @return
     */
    public boolean isDraw(char[][] gameBoard){
        boolean draw = true;
        for(char[] cA : gameBoard){
            for(char c : cA){
                if(c == '-'){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * prints out the dimensions of the board
     */
    public void printBoardSize() {
        System.out.println("This is a " + getBoard() +"X" + getBoard() + " board");
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
     * Extracts the given row number from the matrix
     * @param gameBoard a matrix representation of the board as chars
     * @param rowNum the target row number
     * @return the row of rowNum as a char array
     */
    private char[] extractRow(char[][] gameBoard, int rowNum){
        char[] row = new char[gameBoard.length];
        for(int i = 0; i < gameBoard.length; i++){
            row[i] = gameBoard[rowNum][i];
        }
        return row;
    }

    /**
     * Extracts the given row number from the matrix
     * @param gameBoard a matrix representation of the board as chars
     * @param colNum the target row number
     * @return the row of rowNum as a char array
     */
    private char[] extractColumn(char[][] gameBoard, int colNum){
        char[] column = new char[gameBoard.length];
        for(int i = 0; i < gameBoard.length; i++){
            column[i] = gameBoard[i][colNum];
        }
        return column;
    }

    /**
     * Checks to see if a row has a full set of X's or O's
     *
     * @param row an char array representing one row
     * @return true if row has winner
     */
    private boolean hasRow(char[] row) {
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
     * Checks the a board to see if there is a winner by column by extracting the column and utilizing the hasRow() method
     *
     * @param gameBoard A char array of the board
     * @return true if there is a winner by column
     */
    private boolean hasColumn(char[][] gameBoard) {
        char[] column;
        for (int i = 0; i < gameBoard.length; i++) {
            column = extractColumn(gameBoard, i);
            if(hasRow(column)){
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
    private boolean hasDiagonal(char[][] gameBoard){
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

    /* -------------------- Getters and Setters ----------------*/

    public int getDimension() {
        return dimension;
    }

    public char[][] getBoard() {
        return board;
    }
}
