package com.john_haney.game;

import com.john_haney.engine.AbstractGame;
import com.john_haney.engine.GameBoard;
import com.john_haney.engine.PlayerAI;

import java.util.List;
import java.util.Scanner;

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

    /* ----------------- main access method ----------------- */

    public static void main(String[] args) {

        GameManager manager = new GameManager();

        //where user sets dimensions from the command line
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;

        //repeat until user enters valid input
        System.out.println("Please select a game board size by entering a number between 2 and 10...");
        userInput = scanner.nextInt();

        while(userInput < 2 || userInput > 10){
            if(userInput > 10){
                System.out.println(userInput + " is too large of a value\nplease choose a board size between 2 and 10");
            }else{
                System.out.println(userInput + " is too small of a value\nplease choose a board size between 2 and 10");
            }
            userInput = scanner.nextInt();
        }

        //sets the board size to user input
        GameBoard board = new GameBoard(userInput);

        //sets
        PlayerAI player1 = new PlayerAI(manager.getFirstPlayer());
        PlayerAI player2 = new PlayerAI(manager.getSecondPlayer());

        System.out.println(manager.getFirstPlayer() + " goes first");
        while (!board.hasWinner(board.getGameBoard()) || !board.isDraw(board.getGameBoard())){
            
        }
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
