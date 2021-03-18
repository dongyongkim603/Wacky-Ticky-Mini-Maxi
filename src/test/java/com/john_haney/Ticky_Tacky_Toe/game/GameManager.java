package test.java.com.john_haney.Ticky_Tacky_Toe.game;

import test.java.com.john_haney.Ticky_Tacky_Toe.engine.AbstractGame;
import test.java.com.john_haney.Ticky_Tacky_Toe.engine.PlayerAI;
import test.java.com.john_haney.Ticky_Tacky_Toe.engine.GameBoard;

public class GameManager extends AbstractGame {

    //instance variables
    public char firstPlayer;
    public char secondPlayer;

    //constructor
    public GameManager(){
        intializeGame();
    }

    /* ----------------- public methods ----------------------*/

    /**
     * Randomly selects a first player by using the mod 2 operator on a random number. The firstPlayer and secondPlayer
     * variables are set. These variables are used to initialize the corresponding PlayerAIs.
     */
    public void intializeGame(){
        if(getRandom().nextInt()%2 ==0) {
            setFirstPlayer('X');
            setSecondPlayer('O');
        }else{
            setFirstPlayer('O');
            setSecondPlayer('X');
        }
    }

    /**
     * TODO: create logic to take in user input use Abstract game MIN_VAL and MAX_VAl
     * @return
     */
    public int getUserInput(){
        return -1;
    }

    public static void runGame(PlayerAI player1, PlayerAI player2, GameBoard gameBoard){
        boolean winner = false, draw = false;
        char lastPlayer = player1.getIdentifier();
        while (!winner || !draw){
            gameBoard.displayBoard();
            if(lastPlayer == player1.getIdentifier()){
                player1.makeRandomMove(getBoard(), player1.getIdentifier());
                winner = gameBoard.hasWinner(gameBoard.getGameBoard());
                if(winner){
                    System.out.println(player1.getIdentifier() + " won!");
                    break;
                }
                draw = gameBoard.isDraw(gameBoard.getGameBoard());
                lastPlayer = player2.getIdentifier();
            }else{
                player2.makeRandomMove(getBoard(), player2.getIdentifier());
                winner = gameBoard.hasWinner(gameBoard.getGameBoard());
                if(winner){
                    System.out.println(player2.getIdentifier() + " won!");
                    break;
                }
                draw = gameBoard.isDraw(gameBoard.getGameBoard());
                lastPlayer = player1.getIdentifier();
            }
            gameBoard.displayBoard();
            if(draw){
                System.out.println("it was a draw");
                break;
            }
        }
    }

    /* ----------------- main access method ----------------- */

    public static void main(String[] args) {

        GameManager manager = new GameManager();

        //captures input as a String in case user enters invalid String or special characters
        int userInput = manager.getUserInput();

        //sets the board size to user input
        GameBoard board = new GameBoard(4);

        //sets
        PlayerAI player1 = new PlayerAI(manager.getFirstPlayer());
        PlayerAI player2 = new PlayerAI(manager.getSecondPlayer());

        System.out.println(manager.getFirstPlayer() + " goes first");
        runGame(player1, player2, board);
//        boolean winner = false, draw = false;
//        char lastPlayer = manager.getFirstPlayer();
//        while (!winner || !draw){
//            board.displayBoard();
//            if(lastPlayer == manager.getFirstPlayer()){
//                player1.makeRandomMove(board.getGameBoard());
//                winner = board.hasWinner(board.getGameBoard());
//                if(winner){
//                    System.out.println(player1.getIDENTIFIER() + " won!");
//                }
//                draw = board.isDraw(board.getGameBoard());
//            }else{
//                player2.makeRandomMove(getBoard());
//                winner = board.hasWinner(board.getGameBoard());
//                if(winner){
//                    System.out.println(player2.getIDENTIFIER() + " won!");
//                }
//                draw = board.isDraw(board.getGameBoard());
//            }
//            board.displayBoard();
//            if(draw){
//                System.out.println("it was a draw");
//            }
//        }
    }

    /*------------------Getters and Setters ----------------------*/

    public char getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(char firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public char getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(char secondPlayer) {
        this.secondPlayer = secondPlayer;
    }
}
