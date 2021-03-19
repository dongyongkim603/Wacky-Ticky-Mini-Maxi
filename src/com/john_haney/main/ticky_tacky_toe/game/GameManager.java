package com.john_haney.main.ticky_tacky_toe.game;

import com.john_haney.main.ticky_tacky_toe.engine.AbstractGame;
import com.john_haney.main.ticky_tacky_toe.engine.GameBoard;
import com.john_haney.main.ticky_tacky_toe.engine.PlayerAI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameManager extends AbstractGame {

    //instance variables
    public char firstPlayer;
    public char secondPlayer;

    //constructor
    public GameManager(){
        initializeGame();
    }

    /* ----------------- public methods ----------------------*/

    /**
     * Randomly selects a first player by using the mod 2 operator on a random number. The firstPlayer and secondPlayer
     * variables are set. These variables are used to initialize the corresponding PlayerAIs.
     */
    public void initializeGame(){
        if(getRandom().nextInt()%2 ==0) {
            setFirstPlayer('X');
            setSecondPlayer('O');
        }else{
            setFirstPlayer('O');
            setSecondPlayer('X');
        }
    }

    /**
     * Uses scanner to read in user input from console and sets a value that will be returned to the user. The value must
     * be in int form and between 2 and 10 will catch InputMismatchException. Method will continue to ask user for input
     * until a valid option is given.
     *
     * @return int value of the user input that was scanned in.
     */
    public int getIntFromUser(){
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        boolean exit = false;

        //use loop to handle if user enters invalid int value
        while(!exit){
            try{
                System.out.println("please enter a number between 2 and 10 to set the size of the board...");
                userInput = scanner.nextInt();

                //checks if the user input is between the MIN_VAL AND MAX_VAL's
                if(userInput >= getMinVal() && userInput <= getMaxVal()){
                    exit = true;
                }else if(userInput < getMinVal()){
                    System.out.println(userInput + " is too small");
                }else {
                    System.out.println(userInput + " is too large");
                }
                //catch a non-int input that a user may enter
            }catch(InputMismatchException e){
                System.out.println("invalid input!");

                //clear the invalid input form buffer
                scanner.nextLine();
            }
        }

        //Don't forget to close the Scanner no one likes a memory leak
        scanner.close();
        return userInput;
    }

    /**
     * The method for running the game until an end condition i.e. draw or win is reached. Will check to see which
     * players turn it is and have the PlayerAI make a move. Will then check if either end conditions have been met.
     *
     * @param player1 PlayerAI of the player that is to go first
     * @param player2 PlayerAI of the player that is to go second
     * @param gameBoard GameBoard object that game will be played on.
     */
    public static void runGame(PlayerAI player1, PlayerAI player2, GameBoard gameBoard){

        //Win and draw condition booleans
        boolean winner = false, draw = false;

        //keeps track of which player went last
        char lastPlayer = player1.getIdentifier();

        //while there is no winner or draw
        while (!winner || !draw){
            gameBoard.displayBoard();
            if(lastPlayer == player1.getIdentifier()){
                player1.makeRandomMove(getBoard(), player1.getIdentifier());

                //check to see if move was a winning move
                winner = gameBoard.hasWinner(gameBoard.getGameBoard());
                if(winner){
                    gameBoard.displayBoard();
                    System.out.println(player1.getIdentifier() + " won!");
                    break;
                }

                //checks to see if there is a draw
                draw = gameBoard.isDraw(gameBoard.getGameBoard());

                //updates the last player
                lastPlayer = player2.getIdentifier();
            }else{
                player2.makeRandomMove(getBoard(), player2.getIdentifier());

                //check to see if move was a winning move
                winner = gameBoard.hasWinner(gameBoard.getGameBoard());
                if(winner){
                    gameBoard.displayBoard();
                    System.out.println(player2.getIdentifier() + " won!");
                    break;
                }

                //checks to see if there is a draw
                draw = gameBoard.isDraw(gameBoard.getGameBoard());

                //updates the last player
                lastPlayer = player1.getIdentifier();
            }

            //exit loop if there was a draw
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
        int userInput = manager.getIntFromUser();

        //sets the board size to user input
        GameBoard board = new GameBoard(userInput);

        //Initializes the first and second player by passing the first and second player char variables
        PlayerAI player1 = new PlayerAI(manager.getFirstPlayer());
        PlayerAI player2 = new PlayerAI(manager.getSecondPlayer());

        System.out.println(manager.getFirstPlayer() + " goes first");

        //driver method
        runGame(player1, player2, board);
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
