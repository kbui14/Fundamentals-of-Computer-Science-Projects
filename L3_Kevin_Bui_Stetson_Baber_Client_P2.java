package cs225;

/* CS 220 - Intro to Computer Science
 * File Name: L3_Lastname1_Lastname2_P2.java
 * Java Programming
 * Lab 1 - Due 2/9/2015
 * Instructor: Dan Grissom
 * 
 * Name 1: Bill Smith
 * Name 2: Jill Jones
 * Description: This file contains the source code for problem #2
 * for Lab 3.
 */

public class L3_Kevin_Bui_Stetson_Baber_Client_P2
{
	
	public static void main(String[] args)
	{
		// TODO 1: Update your info
		// Your program should always output your name and the lab/problem
		// number. DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("Kevin Bui & Stetson Baber");
		System.out.println("Lab 3, Problem # 2 - Demonstration");
		System.out.println("");
		
		// TODO 2: Change the class name below to match your class name. DO NOT
		// change ANYTHING else in this file.		
		L3_Kevin_Bui_Stetson_Baber_P2 game = new L3_Kevin_Bui_Stetson_Baber_P2(); // Create new game
		
		// Keep playing the game until it is over
		while (!game.gameIsOver())
		{
			game.playNextTurn();
		}
		System.out.println("\n\n\nThank you for playing!");
		

	}
	
}
