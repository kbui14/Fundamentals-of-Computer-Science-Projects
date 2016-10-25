package cs225;

/* CS 220 - Intro to Computer Science
 * File Name: L2_Lastname1_Lastname2_P1.java
 * Java Programming
 * Lab 1 - Due 2/2/2015
 * Instructor: Dan Grissom
 * 
 * Name 1: Bill Smith
 * Name 2: Jill Jones
 * Description: This file contains the source code for problem #1
 * for Lab 2.
 */

// enum class used to represent each cell of the mine board:
// HM = Hidden Mine, RM = Revealed Mine, HE = Hidden Empty, RE = Revealed Empty
enum MineCell { HM, RM, HE, RE }

public class L2_Lastname1_Lastname2_P1
{
	// Constants used to make defining the mine board easier
	final static MineCell he = MineCell.HE;
	final static MineCell hm = MineCell.HM;
	
	public static void main(String[] args)
	{
		// Your program should always output your name and the lab/problem
		// number. DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("FirstName1 LastName1 & FirstName2 LastName2");
		System.out.println("Lab 2, Problem # 2");
		System.out.println("");

		// Definition of mine board. You may change the location
		// of the hidden mines (‘hm’) by swapping it with a
		// hidden empty (‘he’) cell in the 5×5 array to change the game.
		MineCell [][] mineBoard = { {he, he, he, he, he},
									{he, hm, he, hm, he},
									{he, he, he, he, he},
									{he, he, hm, he, he},
									{he, he, hm, hm, he} };
		
		// Test your board printing functions before continuing
		testBoardPrinting(mineBoard); // TODO 3: Comment out when print methods tested
		
		// Definition of some variables and constants
		int currScore = 5; // Starting score is 5
		int numEmptySpotsFound = 0; // When we reach 20 empty spots, we win!
		final int minePenalty = 4; // Each time we hit a mine, subtract this value
		final int emptySpaceBonus = 1; // Each time we land on an empty space, add this value
		
		//////////////////////////////////////////////////////
		// Continue the game while the score is greater AND
		// the number of empty spots revealed is less than 20
		while (currScore > 0 && numEmptySpotsFound < 20)
		{
			// TODO 4: Write code here to ask the user for a row and column to guess...
			System.out.println("-----------------------Next Turn-----------------------");
			int row = 0;
			int col = 0; 
			
			// Respond to each guess the user could make
			if (mineBoard[row][col] == MineCell.HM)
			{
				// TODO 5: Write code here to respond to the user
				// guessing a cell that has hidden mine...
			}
			else if (mineBoard[row][col] == MineCell.HE)
			{
				// TODO 6: Write code here to respond to the user
				// guessing a cell that has hidden empty cell...
			}
			else
			{
				System.out.println("You've already guessed this spot, please try again!");
			}
			printCurrBoard(mineBoard);
		}
		
		//////////////////////////////////////////////////////
		// TODO 7: Deliver final results. If we've reached this point,
		// the game is over. Write code to let the user know if they won 
		// or lost and print the final board (remember, you have a function
		// to print the game-over board)
	}
	
	/////////////////////////////////////////////////////////////////////
	// Prints the state of the board while game is still being played:
	// '?' for unexplored, 'M' for revealed mines, 'E' for revealed empty cells
	/////////////////////////////////////////////////////////////////////
	static void printCurrBoard(MineCell[][] board)
	{
		// TODO 1: Write code to print the current game state as specified
		// in the comment above
	}
	
	/////////////////////////////////////////////////////////////////////
	// Prints the state of the board after the game is over (thus, we can
	// reveal everything to the user):
	// 'm' for unrevealed mines, 'e' for unrevealed empty cells,
	// 'M' for revealed mines, 'E' for revealed empty cells
	/////////////////////////////////////////////////////////////////////
	static void printGameOverBoard(MineCell[][] board)
	{
		// TODO 2: Write code to print the final (game-over) game state
		// as specified in the comment above
	}
	
	/////////////////////////////////////////////////////////////////////
	// This function simply calls your two board printing methods to help
	// you test that your print methods are working properly before moving
	// on with this lab.
	/////////////////////////////////////////////////////////////////////
	static void testBoardPrinting(MineCell[][] board)
	{
		printCurrBoard(board);
		System.out.println();
		printGameOverBoard(board);
		System.out.println("\n\n*****Exiting program after test. Comment out testBoardPrinting() method in main() to move on.");
		System.exit(0);
	}
}
