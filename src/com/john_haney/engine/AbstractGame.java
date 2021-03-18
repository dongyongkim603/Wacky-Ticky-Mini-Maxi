package com.john_haney.engine;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGame {


    //instance variable
    private static char[][] board;

    /* ------------------- public methods --------------------------*/

    /**
     * Takes a char matrix game board consisting of '#'s, 'X's, and 'O's and finds the moves that are left that can be
     * made.
     *
     * @param gameBoard a char matrix representation of the game board
     * @return a List of Strings of the coordinates of the remaining available moves.
     */
    protected List<String> listAvailableMoves(char[][] gameBoard){
        List<String> moves = new ArrayList<>();
        for (int i =0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard.length; j++){
                if(gameBoard[i][j] == '#'){
                    moves.add(String.valueOf(i) + "," + String.valueOf(j));
                }
            }
        }
        return moves;
    }

    /**
     * Checks to see if there is a draw on the game board by checking to see if there are any remaining free spaces by
     * calling listAvailableMoves.
     *
     * @param gameBoard The game board as a char matrix
     * @return true if there are no more moves available.
     */
    protected boolean isDraw(char[][] gameBoard){
        List<String> moves = listAvailableMoves(gameBoard);
        System.out.println(moves.size());
        if(moves.size() == 0)
            return true;
        else
            return false;
    }

    /**
     * Updates the game board with the at the coordinates [x][y] of the player `player` i.e. 'X' or 'O'
     *
     * @param player char IDENTIFIER of the player
     * @param x int of the horizontal row coordinate
     * @param y int of the vertical column coordinate
     */
    protected void updateBoard(char player, int x, int y){
        board[x][y] = player;
    }

    /*------------------- Getters and Setters ------------------*/

    protected static char[][] getBoard() {
        return board;
    }

    protected static void setBoard(char[][] board) {
        AbstractGame.board = board;
    }
}
