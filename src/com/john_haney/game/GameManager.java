package com.john_haney.game;

import com.john_haney.engine.GameBoard;
import com.john_haney.engine.PlayerAI;

import java.util.List;

public class GameManager {

    /* ----------------- public methods ----------------------*/



    /* ----------------- main access method ----------------- */

    public static void main(String[] args) {
        GameBoard gb = new GameBoard(4);
        gb.displayBoard();
        PlayerAI x = new PlayerAI('X');

        char[][] testboard4 = {
                {'X', '#', 'O', 'O'},
                {'O', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'O', '#', 'O', 'X'}
        };

        char[][] testboard3 = {
                {'O', 'X', 'O'},
                {'X', 'X', 'O'},
                {'X', 'O', 'X'}
        };

//        System.out.println(gb.isDraw(testboard4));
//        System.out.println(gb.isDraw(testboard3));
//
//        List<String> moves = x.listAvailableMoves(testboard4);

//        for(String s : moves){
//            System.out.println(s);
//        }

        for (int i = 0; i < 20; i++){
            x.makeRandomMove(gb.getGameBoard());
        }
    }
}
