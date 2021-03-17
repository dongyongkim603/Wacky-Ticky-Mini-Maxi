package com.john_haney.game;

import com.john_haney.engine.GameBoard;

public class GameManager {


    /* ----------------- main access method ----------------- */

    public static void main(String[] args) {
        GameBoard gb = new GameBoard(4);
        gb.displayBoard();
        char[] row = {'X', 'X', 'X', 'X'};
        System.out.println(gb.hasRow(row) + "\n");

        char[][] testboard4 = {
                {'-', '-', 'O', '-'},
                {'O', '-', '-', '-'},
                {'X', '-', '-', '-'},
                {'-', '-', 'O', '-'}
        };

        char[][] testboard3 = {
                {'O', '-', 'O'},
                {'O', 'O', '-'},
                {'O', '-', 'O'}
        };

        System.out.println(gb.hasColumn(testboard3));
        System.out.println(gb.hasDiagonal(testboard4));
        System.out.println(gb.hasDiagonal(testboard3));
    }

}
