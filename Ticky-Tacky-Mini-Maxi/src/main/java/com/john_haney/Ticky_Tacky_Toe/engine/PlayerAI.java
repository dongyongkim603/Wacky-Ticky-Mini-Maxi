package main.java.com.john_haney.ticky_tacky_toe.engine;

import java.util.List;
import java.util.Random;

public class PlayerAI extends AbstractGame {

    //Identifies which player
    private char identifier;

    //Constructors
    public PlayerAI(char id){
        this.identifier = id;
    }

    /* -----------------------public methods -------------------------- */

    /**
     * Makes a random next move for the PlayerAI by getting a list of CSV String coordinates of the remaining available
     * moves. A random integer is generated between 0 and size of list of available moves. The random number corresponds
     * to the index value in the moves list. This value is returned and parsed into an integer value and
     *
     * @param gameBoard char matrix representation of a game board
     * @param id the id of the PlayerAI that is making the move
     */
    public void makeRandomMove(char[][] gameBoard, char id){

        //gets the list of available moves that can be made
        List<String> moves = listAvailableMoves(gameBoard);

        //generates a random number from 0 to size of list
        int next = getRandom().nextInt(moves.size());

        //gets the CSV String coordinate
        String nextMove = moves.get(next);

        //converts the CSV coordinates to integers
        int x = Integer.parseInt(nextMove.substring(0,nextMove.indexOf(",")));
        int y = Integer.parseInt(nextMove.substring(nextMove.indexOf(",")+1));

        updateBoard(id, x, y);
    }

    /*----------------------- Getters and Setters-----------------------*/

    public char getIdentifier() {
        return identifier;
    }

    public static Random getRandom() {
        return AbstractGame.getRandom();
    }
}
