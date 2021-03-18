package com.john_haney.engine;

public class GameBoard extends AbstractGame {


    //constructor
    public GameBoard(int dimension) {
        super(dimension);
    }

/*---------------------public methods----------------------*/

    /**
     * prints board to console
     */
    public void displayBoard() {
        for (char[] row : getBoard()) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println("");
        }
    }

    /**
     * Checks the board to see if there is a winner
     * @param gameBoard The game board as a char matrix
     * @return true if there is a winner.
     */
    public boolean hasWinner(char[][] gameBoard) {
        char[] row;
        final boolean b = true;

        for(int i = 0; i < gameBoard.length; i++){
            row = extractRow(gameBoard, i);
            if(hasRow(row))
                return b;
        }
        if(hasColumn(gameBoard) || hasDiagonal(gameBoard)) {
            return b;
        }
        return false;

    }

    /**
     * prints out the dimensions of the board
     */
    public void printBoardSize() {
        System.out.println("This is a " + getBoard() +"X" + getBoard() + " board");
    }

/*------------------private methods---------------------------*/

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
            if (c == '#') {
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
        return getDIMENSIONS();
    }

    public char[][] getGameBoard(){
        return AbstractGame.getBoard();
    }
}
