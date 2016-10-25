package cs225;
/* CS 220 - Intro to Computer Science
 * File Name: L3_Kevin_Bui_Stetson_Baber_P2.java
 * Java Programming
 * Lab 1 - Due 2/9/2015
 * Instructor: Dan Grissom
 * 
 * Name 1: Kevin Bui
 * Name 2: Stetson Baber
 * Description: This file contains the source code for problem #2
 * for Lab 3.
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class L3_Kevin_Bui_Stetson_Baber_P2 // TODO 3: Change class name and constructor header below
{
	private final Scanner scan = new Scanner(System.in);
	private final DecimalFormat df = new DecimalFormat("$#,##0.00");
	private final double [] cashPrizes = {.01, .50, 1, 5, 10, 50, 100, 250, 500, 1000, 5000, 10000, 100000, 500000, 1000000};
	private ArrayList<Double> remainingPrizesBoard;
	private boolean gameIsOver;
	private ArrayList<Double> offerHistory;
	

	
	/////////////////////////////////////////////////////////////////////
	// The constructor initializes remainingPrizesBoard to a new board
	// containing a random ordering of all the prizes.
	/////////////////////////////////////////////////////////////////////
	L3_Kevin_Bui_Stetson_Baber_P2()
	{
		System.out.println("Let's play DEAL OR NO DEAL!");
		
		gameIsOver = false; // New game, so game is not over!
		initializeRandomPrizeBoard();
		offerHistory = new ArrayList<Double>();
		// TODO 9: Instantiate offerHistory using the new keyword
	}

	/////////////////////////////////////////////////////////////////////
	// Prints the locations available to choose from
	// (0 through numRemainingPrizes-1)
	/////////////////////////////////////////////////////////////////////
	private void printRemainingPrizeBoard()
	{
		// Copies remaining prizes ArrayList into prizes ArrayList (a temp ArrayList)
		ArrayList<Double> prizes = new ArrayList<Double>();
		for (double prize : remainingPrizesBoard){
			prizes.add(prize);
			//System.out.print( df.format(remainingPrizesBoard.get((int)prize) + "\t"));
		}
		Collections.sort(prizes);
		for (double s : prizes)
			System.out.print(df.format(s) +"\t");
		//for(int i=0; i<cashPrizes.length;i++)
			//System.out.print( df.format(cashPrizes[i]) + "\t");
			
		// TODO 4: Print the prizes in the prize ArrayList. All values should be on
		// a single line (put a few spaces after each prize) and add a new line
		// at the end (simple for loop)
	}
	
	/////////////////////////////////////////////////////////////////////
	// Generates the banks offer. The banker algorithm computes the average
	// value of the remaining prizes and then offers 85% of the average. 
	/////////////////////////////////////////////////////////////////////
	private double getBankerOffer()
	{
		double avg = 0;
		for(double s : remainingPrizesBoard)
			avg += s;
		
		avg = avg/remainingPrizesBoard.size();
		avg = avg * .85;
		return avg;
		
		// TODO 5: Write code which returns the banker's offer as a double,
		// according to the description in this method's comment above.
	}

	/////////////////////////////////////////////////////////////////////
	// Takes in the selected door number and processes the result
	/////////////////////////////////////////////////////////////////////
	private void chooseDoor(int door)
	{
		offerHistory.add(getBankerOffer());
		// TODO 10: Add the current bank offer (remember, we have a method
		// for this) to the our offerHistory 
		
		if (door == -1)
		{
			// This block is executed when the player accepts the banker's offer. Thus the game is over.
			gameIsOver = true;
			
			System.out.println("!!!!!Congratulations, you've accepted the banker's offer of " + df.format(getBankerOffer()) + "!!!!!!");
			printOfferHistory(getBankerOffer());
			// TODO 6: Set the gameIsOver variable to true
			// Inform the user that the game is over and how much money they accepted from the banker.
			// Print the offer history (there is a method to call for this).
		}
		else
		{
			// This block is executed when the player selects one of the remaining doors.
			
			System.out.println("***You've selected door " + door + " which held the value of " + df.format(remainingPrizesBoard.get(door)) + "***");
			remainingPrizesBoard.remove(door);
			
			// TODO 7: Obtain the prize behind the proper door and remove the prize from the board
			// Print out which door the user selected and what prize was behind it (this prize is now gone)
		}
		
		// If only one prize remaining, game is over!!!
		if (remainingPrizesBoard.size() == 1)
		{
			// This block is executed when there is only one more prize remaining...so it is what they win!
			gameIsOver = true;
			System.out.println("!!!!!Congratulations, your final door contained " + df.format(remainingPrizesBoard.get(0)) + "!!!!!!");
			printOfferHistory(getBankerOffer());
			// TODO 8: Set the gameIsOver variable to true
			// Let the user know what prize they won behind the final door!
			// Print the offer history (there is a method to call for this).
		}
	}
		
	/////////////////////////////////////////////////////////////////////
	// This method is called when the game is over, and thus takes as a
	// parameter the prize that was accepted (either from the banker's offer
	// or the final door).
	//
	// Prints out the offers made by the banker in chronological order.
	// Then, prints out the money left on the table (for example, if the
	// largest offer from the banker was $250,000, and you ended up winning
	// $1,000, whether from a later banker offer or from the last door,
	// then you "left $249,000 on the table).
	/////////////////////////////////////////////////////////////////////
	private void printOfferHistory(double acceptedPrize)
	{
		// Print out the history of offers from the banker
		int count = 1;
		for(double s : offerHistory){
			System.out.println("Offer " + count + ": " + df.format(s));
			count++;
		}
		double max = Collections.max(offerHistory);
		// TODO 11: Print out the banker offer history (will need to loop through
		// your offerHistory member variable) and find the max offer made.
		// Print one offer per line, like:
		// Offer 1: $10.00
		// Offer 2: $5.00
		// .....
		if(max>getBankerOffer())
		System.out.println("Uh oh, you left " + df.format(max - getBankerOffer()) + " on the table :-(");
		else
			System.out.println("Nice! You won more than the banker's max offer of " + df.format(getBankerOffer()) + ":-)");
		// TODO 12: If the max offer was greater than the accepted prize, then print out
		// the $$$ left out on the table (see the example in this method's header above).
		// Otherwise, congratulate the user that they won more than the banker's max
		// offer and display the banker's max offer.
	}
	
	
	/////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////
	/////////////DO NOT EDIT ANY PORTIONS OF METHODS BELOW///////////////
	/////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////
	
	
	/////////////////////////////////////////////////////////////////////
	// Processes all the code needed to execute a single turn of the game
	/////////////////////////////////////////////////////////////////////
	public void playNextTurn()
	{
		System.out.println("-----------------------------------------------------------------------");
		
		// Print out remaining prizes
		System.out.println("There are " + remainingPrizesBoard.size() + " prizes remaining, listed in ascending order: ");
		printRemainingPrizeBoard();
		
		// Display all prize doors
		System.out.println("\nThe prizes have been dispersed randomly behind the following doors:");
		for (int i = 0; i < remainingPrizesBoard.size(); i++)
			System.out.print(i + "     ");
		System.out.println();
		
		// Print out banker's offer and ask user what to do
		System.out.println("The banker would like to make you an offer of...................." + df.format(getBankerOffer()));
		System.out.print("What would you like to do? Enter '-1' to accept the banker's offer, " +
							"or select one of the doors above (0-" + (remainingPrizesBoard.size()-1) + "): ");
		

		// Get selection from user and choose door
		int selectedDoorNum = scan.nextInt();
		if (selectedDoorNum >= -1 && selectedDoorNum < remainingPrizesBoard.size()) // Make sure valid selection
			chooseDoor(selectedDoorNum);
		else
			System.out.println(selectedDoorNum + " is not a valid selection.");
		System.out.println();
		System.out.println();
	}
	
	/////////////////////////////////////////////////////////////////////
	// Basically, a getter method for the gameIsOver method. The client
	// will continually call playNextTurn() until gameIsOver() evaluates
	// to true.
	/////////////////////////////////////////////////////////////////////
	public boolean gameIsOver()
	{
		return gameIsOver;
	}
	
	/////////////////////////////////////////////////////////////////////
	// Copies the constant prizes (from an array) into a temporary array
	// and uses that array to populate the initial board into the member
	// variable 'remainingPrizesBoard'.
	/////////////////////////////////////////////////////////////////////
	private void initializeRandomPrizeBoard()
	{
		// Start with a fresh board with nothing in it
		remainingPrizesBoard = new ArrayList<Double>();
		
		// Copies cashPrizes array into prizes ArrayList (a temp ArrayList)
		ArrayList<Double> prizes = new ArrayList<Double>();
		for (double prize : cashPrizes) 
			prizes.add(prize);
		
		// Randomizes prizes into remainingPrizesBoard
		while (!prizes.isEmpty())
		{
			Random r = new Random();
			int i = r.nextInt(prizes.size()); // Pick a random remaining prize
			remainingPrizesBoard.add(prizes.get(i)); // Copy into our "board"
			prizes.remove(i);
		}
		
		// Debug print which will show the random board contents
		//for (double d : remainingPrizesBoard)
		//	System.out.print(df.format(d) + "  --  ");
		//System.out.println();
	}
}
