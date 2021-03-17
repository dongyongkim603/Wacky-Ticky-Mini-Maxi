package com.john_haney.game;

import com.john_haney.engine.GameBoard;

public class GameManager {


    /* ----------------- main access method ----------------- */

    public static void main(String[] args) {
        GameBoard gb = new GameBoard(4);
        gb.displayBoard();
        char[] row = {'X', 'X', 'X', 'X'};
        System.out.println(gb.hasRow(row) + "\n");

        char[][] columnTest = {
                {'X', '-', 'O', '-'},
                {'O', '-', 'O', '-'},
                {'X', '-', 'O', '-'},
                {'X', '-', 'O', '-'}
        };
        System.out.println(gb.hasColumn(columnTest));
    }

}
