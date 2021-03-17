package com.john_haney.engine;

public class GameBoard {

	private int dimension;
	private char[][] board;

	public GameBoard(int dimension) {
		this.dimension = dimension;
		generateBoard();
	}

//-------------------------public methods----------------------
	
	/**
	 * prints board to console
	 */
	public void displayBoard() {
		for(char[] row : board) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println("");
		}
	}

//------------------private methods----------------------------
	/**
	 * Fills board matrix with characters that will form board when printed
	 */
	private void generateBoard() {
		char[][] b = new char[(dimension*2)-1][(dimension*2)-1];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (i % 2 == 0 && j % 2 == 0) {
					b[i][j] = ' ';
				} else if (i % 2 == 0 && j % 2 != 0) {
					b[i][j] = '|';
				} else if (i % 2 != 0 && j % 2 != 0) {
					b[i][j] = '+';
				} else {
					b[i][j] = '-';
				}
			}
		}
		this.board = b;
	}

	public void printBoardSize(){
		System.out.println(board.length);
	}

}
