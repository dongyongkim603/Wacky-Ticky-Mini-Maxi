package com.john_haney.game;

import com.john_haney.engine.GameBoard;

public class GameManager {


    /* ----------------- main access method ----------------- */

    public static void main(String[] args) {
        GameBoard gb = new GameBoard(4);
        gb.displayBoard();

        char[][] testboard4 = {
                {'X', '-', 'O', 'O'},
                {'O', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'O', '-', 'O', 'X'}
        };

        char[][] testboard3 = {
                {'O', '-', 'O'},
                {'-', '-', '-'},
                {'O', '-', 'X'}
        };

        System.out.println(gb.hasWinner(testboard4));
        System.out.println(gb.hasWinner(testboard3));

    }

}
