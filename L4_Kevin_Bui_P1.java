package cs225;
import java.util.Scanner;
import java.util.Random;
public class L4_Kevin_Bui_P1 {
	/* CS 225 - Fundamentals of Computer Science
	 * File Name: L4_Kevin_Bui_P2.java
	 * Java Programming
	 * Lab 4 - Due 2/16/2015
	 * Instructor: Dan Grissom
	 * 
	 * Name 1: Kevin Bui
	 * Description: Write a Java Application that allows you to play a timed summation game.
	 */
	
		static Scanner scan = new Scanner(System.in); // Holds a local scanner 
		private static int secondsLeft; // Number of seconds after each turn
		private static int score = 0;   // Score variable which you update
		private static NonBlockingHasNext t = new NonBlockingHasNext(); // Special class for timer
		private static int [][][] gameBoard = new int [3][3][3]; // TODO 2: Initialize to a new 3x3x3 array
		
		//////////////////////////////////////////////////////
		// main() runs the program. Do NOT edit this method.
		//////////////////////////////////////////////////////
		public static void main(String[] args)
		{
			// TODO 1: Update your info
			// Your program should always output your name and the lab/problem
			// number. DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
			System.out.println("Kevin Bui & FirstName2 LastName2");
			System.out.println("Lab 4, Problem # 1");
			System.out.println("");

			// Give user instructions and begin
			System.out.println("You will be presented 3 3x3 boards of random numbers, labeled 0, 1 and 2.");
			System.out.println("Quickly select the board you believe to contain the largest sum of 9 numbers" +
								"by entering the board number and pressing enter");
			System.out.println("Press any key and hit enter to begin...");
			scan.nextLine();
			
			int numTurns = 10;
			for (int i = 0; i < numTurns; i++)
			{
				reInit3dBoard();
				print3dBoard(i, numTurns);
				int choiceMade = countDownTimer();
				choiceMade--; // Decrement to match with 0-indexed arrays	
				analyzeChoice(choiceMade);			
			}			
		}
		
		//////////////////////////////////////////////////////
		// countDownTimer() counts down from 10 seconds. Returns
		// the user input if the value that is input is a 1, 2
		// or 3. If the value is something else or no value is
		// input, this method returns a -1.
		//////////////////////////////////////////////////////
		private static int countDownTimer()
		{
			// Some really complicated stuff to work around Java shortcomings.
			// Basically, this code creates a new "thread" which allows us to
			// run other code while a scanner in NonBlockingHasNext is waiting
			// for a user input.
			t = new NonBlockingHasNext();
			(new Thread(t)).start();
			
			System.out.println("\nSeconds left to make choice: ");
			for (int i = 10; i > 0; i--)
			{
				secondsLeft = i;
				System.out.print(secondsLeft + "...");
				
				
				// Sleep for 1 second and....
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace(); }

				
				// ...check again for input. If received a valid input in time, then return it
				if (t.hasNext())
				{
					// Make sure choice is valid (1, 2 or 3)
					int choice = t.nextInt(); //scan.nextInt();
					if (choice >= 1 && choice <= 3)
					{
						System.out.println("\nYou chose grid #" + choice + " with " + secondsLeft + " seconds left!");
						return choice;
					}				
				}
			}
			
			// If we get here, then no choice was made!
			System.out.println("\nNo choice made!");
			return -1; // If no valid choice made
		}
		
		//////////////////////////////////////////////////////
		//////////////////////////////////////////////////////
		//////////////////////////////////////////////////////
		//////////////////////////////////////////////////////
		/////////////////DO NOT EDIT ABOVE////////////////////
		//////////////////////////////////////////////////////
		//////////////////////////////////////////////////////
		//////////////////////////////////////////////////////
		//////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////////
		// Simply assigns each element of the 3x3x3 3D board
		// a random number from 1-9 (should not see 0's or 10's)
		//////////////////////////////////////////////////////
		private static void reInit3dBoard()
		{
			Random r = new Random();
			
			for(int row = 0; row<gameBoard.length; row++){
				
				for(int col = 0; col<gameBoard[row].length ; col++){
					
					for(int dep = 0; dep<gameBoard[row][col].length; dep++){
				int	i = r.nextInt(9) + 1;
					gameBoard[row][col][dep]= i;
					}
				}
			}
			// TODO 3: Generate a random assignment of the gameBoard variable
			// (see member variables) as described in the method header above.
			// NOTE: You can just overwrite the values there.
		}
		
		//////////////////////////////////////////////////////
		// Prints the 3x3x3 3D board out to the console. It
		// should print 3 2d boards. The line directly above each board
		// should be labeled "Board 1:", "Board 2:" or "Board 3:".
		// The line directly below each board should be blank. 
		//////////////////////////////////////////////////////
		private static void print3dBoard(int turn, int numTurns)
		{
			System.out.println("--------------------------Turn " + (turn+1) + "/" + numTurns + "--------------------------");
			
			
			
			
			for(int row = 0; row<gameBoard.length; row++){
				System.out.println("\nBoard: " + (row+1));
				for(int col = 0; col<gameBoard[row].length ; col++){
					System.out.println();
					for(int dep =0; dep<gameBoard[row][col].length; dep++){
					System.out.print(gameBoard[row][col][dep]+"   ");
					
					}
				}
			}
			
			// TODO 4: Print out the 3d board as described in the method header above.
			// Make sure to label the boards 1-3 and not 0-2.
		}
		
		//////////////////////////////////////////////////////
		// This method analyzes the choice made by the user 
		// conveniently passed into us for array-indexing purposes
		// as a 0, 1 or 2.
		//////////////////////////////////////////////////////
		private static void analyzeChoice(int choiceMade)
		{
			int [] count = new int [3];
			int max = 0;
			
			for(int row = 0; row<gameBoard.length; row++){
				
				for(int col = 0; col<gameBoard[row].length ; col++){
					
					for(int dep = 0; dep<gameBoard[row][col].length; dep++){
				
					count[dep]+=gameBoard[row][col][dep];
					}
				}
			}
			// TODO 5: Create a counter array and use several FOR loops
			// to compute the sum of each of the 3 boards.

			if(count[0]>=count[1] && count[0]>=count[2])
				max=0;
			if(count[1]>=count[0] && count[1]>=count[2])
				max=1;
			if(count[2]>=count[0] && count[2]>=count[1])	
				max=2;
				for(int i=0;i<count.length;i++){
					System.out.print("Board "+ (i+1)+ " : " + count[i]);
				if (i==choiceMade){
					if(choiceMade==max){
						System.out.print("(Right)");
						score += secondsLeft;
					}
					else
						System.out.print("(Wrong)");	
					
				}
				System.out.println();
			}
			
			
			
			
			// TODO 6: From your counter array, compute the max score
			
			// TODO 7: Print out the score of all three boards (e.g., "Board 1 value: 34"). Number
			// the boards 1-3 b/c this is what the user saw when selecting.
			// Next to the selected board, add the string "(Right)" or "(Wrong)" if their guess
			// was correct (i.e., the max board). Also, update the score by adding the number
			// of seconds left when the guess was made.
			
			// HINT: At this point, the member variable "score" holds the current score and the
			// member variable "secondsLeft" holds the seconds left when the last selection was made.
			
			// Print out the current score
			System.out.println("\n***Current Score: " + score);
		}
	}

