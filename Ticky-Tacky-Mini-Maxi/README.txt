#####################################################################################
#                                                                                   #
#                              TICKY TACKY TOE                                      #
#                                    BY                                             #
#                                JOHN HANEY                                         #
#                                                                                   #
#####################################################################################

ABOUT:
Ticky Tacky Toe is a program that plays games of tic tac toe between two AI players
(no human play is involved). The user will input a number between 2 and 10 which 
will correspond to the size of the board in the game. For example, if a user enters
'5' the game will be run on a 5x5 grid with '#' representing empty spaces.

example of a 5x5 grid:		#####
				#####
				#####
				#####
				#####

--------------------------------------------------------------------------------------

GAME RULES:
The two AI players are assigned values of 'O' and 'X'. The game will randomly assign
one of the AI players to start the game.

The game will run until one of four conditions are met.

	1. an AI player has won via horizontal
	
				XXXXX
				#O###
				##O##
				#O###
				#####
				
				X has won!

	2. an AI player has won via vertical
	
				#X##O
				##X#O
				#X##O
				#X##O
				##X#O
			
				O has won!

	3. an AI player has won via diagonal

				XO#O#
				#X#O#
				##X##
				#O#X#
				####X

				X has won!
	
	4. There are no more moves availible for the AI players to make i.e. the game is a 
	draw.

				OXXOO
				OXXXO
				XOOXO
				XOOXX
				OOXXO

				it was a draw

The game will notify the user of the end conditions.


--------------------------------------------------------------------------------------


HOW TO RUN:

	step 1.
	navigate to 'src' dirctory with terminal, bash, cmd, etc.
	
	step 2.
	compile the project by copying and entering the following command:
	javac com/john_haney/main/ticky_tacky_toe/game/GameManager.java

	step 3.
	run the compiled java class 'GameManager' from the same 'src' directory by
	copying and pasting the following command:
	java com.john_haney.main.ticky_tacky_toe.game.GameManager

