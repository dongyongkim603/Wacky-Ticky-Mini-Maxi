package main.java.com.john_haney.ticky_tacky_toe.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AbstractGame {


    //instance variable
    private static int DIMENSIONS;
    private static int TOTAL_MOVES;

    //class variables
    final private static int MIN_VAL = 2;
    final private static int MAX_VAL = 10;
    final private static  Random random = new Random();

    private static char[][] board;

    static int turnCount = 0;

    //constructors
    public AbstractGame(){    }

    public AbstractGame(int dimension){
        this.DIMENSIONS = dimension;
        generateBoard(dimension);
        TOTAL_MOVES = DIMENSIONS * DIMENSIONS;
    }

    /* ------------------- public methods --------------------------*/

    /**
     * Checks to see if there is a draw on the game board by checking to see if there are any remaining free spaces by
     * calling listAvailableMoves.
     *
     * @param gameBoard The game board as a char matrix
     * @return true if there are no more moves available.
     */
    public boolean isDraw(char[][] gameBoard){
        if(getTOTAL_MOVES() == getTurnCount())
            return true;
        else
            return false;
    }

    /* ------------------- protected methods -----------------------*/

    /**
     * Takes a char matrix game board consisting of '#'s, 'X's, and 'O's and finds the moves that are left that can be
     * made.
     *
     * @param gameBoard a char matrix representation of the game board
     * @return a List of Strings of the coordinates of the remaining available moves.
     */
    protected List<String> listAvailableMoves(char[][] gameBoard){

        List<String> moves = new ArrayList<>();
        for (int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard.length; j++){
                if(gameBoard[i][j] == '#'){
                    moves.add(String.valueOf(i) + "," + String.valueOf(j));
                }
            }
        }
        return moves;
    }

    /**
     * Updates the game board with the at the coordinates [x][y] of the player `player` i.e. 'X' or 'O'. Increments the
     * turn count by one.
     *
     * @param player char IDENTIFIER of the player
     * @param x int of the horizontal row coordinate
     * @param y int of the vertical column coordinate
     */
    protected void updateBoard(char player, int x, int y){
        board[x][y] = player;
        incrementTurn();
    }

    /*------------------ private methods -----------------------*/

    /**
     * Initializes board and fills matrix with '#' char which symbolizes empty space.
     */
    private void generateBoard(int dimensions) {
        char[][] b = new char[dimensions][dimensions];
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                b[i][j] = '#';
            }
        }
        setBoard(b);
    }

    public static void incrementTurn(){
        turnCount++;
    }

    /*------------------- Getters and Setters ------------------*/

    public static char[][] getBoard() {
        return board;
    }

    public static void setBoard(char[][] b) {
        board = b;
    }

    public int getDIMENSIONS() {
        return DIMENSIONS;
    }

    public int getTotalMoves() {
        return TOTAL_MOVES;
    }

    public int getTOTAL_MOVES() {
        return TOTAL_MOVES;
    }

    public static int getMinVal() {
        return MIN_VAL;
    }

    public static int getMaxVal() {
        return MAX_VAL;
    }

    public static Random getRandom() {
        return random;
    }

    public static int getTurnCount() {
        return turnCount;
    }

    public static void setTurnCount(int turnCount) {
        AbstractGame.turnCount = turnCount;
    }
}
