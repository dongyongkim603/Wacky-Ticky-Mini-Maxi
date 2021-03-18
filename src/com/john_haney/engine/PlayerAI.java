package com.john_haney.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerAI extends AbstractGame {

    //Identifies which player
    final private char IDENTIFIER;

    private static Random random;

    //Constructors
    public PlayerAI(char id){
        this.IDENTIFIER = id;
        this.random = new Random();
    }

    /* -----------------------public methods -------------------------- */

    /**
     * Makes a random next move for the PlayerAI by getting a list of CSV String coordinates of the remaining available
     * moves. A random integer is generated between 0 and size of list of available moves. The random number corresponds
     * to the index value in the moves list. This value is returned and parsed into an integer value and
     *
     * @param gameBoard
     */
    public void makeRandomMove(char[][] gameBoard){

        //gets the list of available moves that can be made
        List<String> moves = listAvailableMoves(gameBoard);

        //generates a random number from 0 to size of list
        int next = getRandom().nextInt(moves.size());

        //gets the CSV String coordinate
        String nextMove = moves.get(next);

        //converts the CSV coordinates to integers
        int x = Integer.parseInt(nextMove.substring(0,nextMove.indexOf(",")));
        int y = Integer.parseInt(nextMove.substring(nextMove.indexOf(",")+1));

        updateBoard(getIDENTIFIER(), x, y);
    }

    /*----------------------- Getters and Setters-----------------------*/

    public char getIDENTIFIER() {
        return IDENTIFIER;
    }

    public Random getRandom() {
        return random;
    }
}
