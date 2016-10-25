package cs225;

/* CS 220 - Intro to Computer Science
 * File Name: P2_Kevin_Bui_P1.java
 * Java Programming
 * Lab 1 - Due 2/16/2015
 * Instructor: Dan Grissom
 * 
 * Name 1: Kevin Bui
 * 
 * Description: Write a Java application for a 1-player version of the popular game called Battleship. The main
learning objectives of this lab are to demonstrate a practical understanding of multi-dimension
arrays and ArrayLists.
 */

import java.util.ArrayList;
//import java.util.Collections;
import java.util.Scanner;


enum ShipCell { HS, RS, HE, RE }

public class P2_Kevin_Bui_P1 {

	final static ShipCell he = ShipCell.HE;
	final static ShipCell re = ShipCell.RE;
	final static ShipCell rs = ShipCell.RS;
	final static ShipCell hs = ShipCell.HS;
	static int moves = 0;
	//ShipCell [] [] currentShipBoard = new ShipCell [7][7];
	//ShipCell [] [] battleShipBoard = new ShipCell [7][7];
	//private ArrayList<Integer> rowHistory;
	//private ArrayList<Integer> colHistory;
	private boolean gameIsOver;
	//private int shipNum;
	private final static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		System.out.println("Kevin Bui");
		System.out.println("Project 2, Problem # 1");
		System.out.println("");
		
		new P2_Kevin_Bui_P1();
		
		//variables used
		Scanner scan = new Scanner(System.in);
		ShipCell [] [] shipBoard = new ShipCell [7][7];
		ArrayList<Integer> rowHistory = new ArrayList<Integer>();
		int ships = 0;
		char confirm;
		//method to place ships
		System.out.println("Welcome to the simple battleship game!\nPlease start by having your enemy place his ships.\n\n ");
		placeShips(shipBoard);
		System.out.println("\nYou have set up your ships! Are you sure about your placements? (y or n)");
		confirm = scan.next().charAt(0);
		//play the game
		if(confirm == 'n'){
			placeShips(shipBoard);
			System.out.println("\nYou have set up your ships! Are you sure about your placements? (y or n)");
			confirm = scan.next().charAt(0);
		}
		if(confirm == 'y'){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		while (ships < 9)
		{
			// Write code here to ask the user for a row and column to guess...
			int row;
			int col; 
			System.out.println("\nPlease enter the row and column to guess where the enemy's ships are.");
			System.out.print("Row(0-6): ");
			row = scan.nextInt();
			System.out.print("Column(0-6): ");
			col = scan.nextInt();
			//add to move history
			System.out.println("\n-----------------------Next Turn-----------------------\n");
			
			if (row<0 || row >6 || col <0 ||  col>6)
				System.out.println("Invalid");
			// Respond to each guess the user could make
			else if (shipBoard[row][col] == ShipCell.HS)
			{
				System.out.println("HIT! You hit the enemy's ship!");
				shipBoard[row][col] = ShipCell.RS;
				ships++;
				
				// guessing a cell that has hidden mine...
			}
			else if (shipBoard[row][col] == ShipCell.HE)
			{
				System.out.println("Missed!");
				shipBoard[row][col] = ShipCell.RE;
				
				
				
				// guessing a cell that has hidden empty cell...
			}
			
			else
			{
				System.out.println("You've already guessed this spot, please try again!");
			}
			//adds row and col history into ONE arraylist
			rowHistory.add(row);
			rowHistory.add(col);
			moves++;//counts moves
			printCurrBoard(shipBoard);
		}}
		System.out.println("\nGame Over!\nNumber of Moves: " + moves);
		printMoveHistory(rowHistory);
		
		
	}
	


	P2_Kevin_Bui_P1(){
		gameIsOver = false;
		
	}
	
	public boolean isGameIsOver() {
		
		return gameIsOver;
	}
	
	public static void placeShips(ShipCell [] [] board){
		///////////////////////////////////////
		///Method that prompts user to place 
		///ships for enemy to hit
		///////////////////////////////////////

		//int [] [] rowCol=new int [10][10];
		int shipNum, r, c;
		char z;
		for(int i = 0; i<board.length;i++){ 
			for(int j=0; j<board[i].length; j++){
				board[i][j] = he;
				
			}}
		printPlacedShipBoard(board);
			shipNum = 0;
			
		while(shipNum < 1){
		System.out.println("\nPlease enter the small ship (2 spaces): ");
		r = scan.nextInt();
		c = scan.nextInt();
		board[r][c] = hs;
		printPlacedShipBoard(board);
		System.out.println("\nHorizontal or Vertical? (h or v)");
		z = scan.next().charAt(0);
		if (z=='h'){
			System.out.println("Left or Right? (l or r)");
			z = scan.next().charAt(0);
			if(z == 'l'){
				board[r][c-1] = hs;
				shipNum++;
				shipNum++;
			}
			if(z == 'r'){
				board[r][c+1] = hs;
				shipNum++;
				shipNum++;
			}
		}
		if (z == 'v'){
			System.out.println("Up or Down? (u or d)");
			z = scan.next().charAt(0);
			if(z == 'u'){
				board[r-1][c] = hs;
				shipNum++;
				shipNum++;
			}
			if(z == 'd'){
				board[r+1][c] = hs;
				shipNum++;
				shipNum++;
			}
		}	
		else if(z != 'l' && z != 'r')
			System.out.println("Invalid");
		
		printPlacedShipBoard(board);
	}//close while loop
	
		while(shipNum < 3 ){
			System.out.println("\nPlease enter the medium ship (3 spaces): ");
			
			r = scan.nextInt();
			c = scan.nextInt();
			if(board[r][c] != hs)
				board[r][c] = hs;
			else
				System.out.println("Invalid");
			printPlacedShipBoard(board);
			System.out.println("\nHorizontal or Vertical? (h or v)");
			z = scan.next().charAt(0);
			if (z == 'h'){
				System.out.println("Left or Right? (l or r)");
				z = scan.next().charAt(0);
				if(z == 'l'){
					board[r][c-1] = hs;
					board[r][c-2] = hs;
					shipNum++;
					shipNum++;
					shipNum++;
				}
				if(z == 'r'){
					board[r][c+1] = hs;
					board[r][c+2] = hs;
					shipNum++;
					shipNum++;
					shipNum++;
				}
			}
			if (z == 'v'){
				System.out.println("Up or Down? (u or d)");
				z = scan.next().charAt(0);
				if(z == 'u'){
					board[r-1][c] = hs;
					board[r-2][c] = hs;
					shipNum++;
					shipNum++;
					shipNum++;
				}
				if(z == 'd'){
					board[r+1][c] = hs;
					board[r+2][c] = hs;
					shipNum++;
					shipNum++;
					shipNum++;
				}
			}
			else if(z != 'l' && z != 'r')
				System.out.println("Invalid");
			
			printPlacedShipBoard(board);
		}//end while loop
		
		while(shipNum < 6 ){
			System.out.println("\nPlease enter the large ship (4 spaces): ");
			
			r = scan.nextInt();
			c = scan.nextInt();
			if(board[r][c] != hs)
				board[r][c] = hs;
			else
				System.out.println("Invalid");
			printPlacedShipBoard(board);
			System.out.println("\nHorizontal or Vertical? (h or v)");
			z = scan.next().charAt(0);
			if (z == 'h'){
				System.out.println("Left or Right? (l or r)");
				z = scan.next().charAt(0);
				if(z == 'l'){
					board[r][c-1] = hs;
					board[r][c-2] = hs;
					board[r][c-3] = hs;
					shipNum++;
					shipNum++;
					shipNum++;
					shipNum++;
				}
				if(z == 'r'){
					board[r][c+1] = hs;
					board[r][c+2] = hs;
					board[r][c+3] = hs;
					shipNum++;
					shipNum++;
					shipNum++;
					shipNum++;
				}
			}
			if (z == 'v'){
				System.out.println("Up or Down? (u or d)");
				z = scan.next().charAt(0);
				if(z == 'u'){
					board[r-1][c] = hs;
					board[r-2][c] = hs;
					board[r-3][c] = hs;
					shipNum++;
					shipNum++;
					shipNum++;
					shipNum++;
				}
				if(z == 'd'){
					board[r+1][c] = hs;
					board[r+2][c] = hs;
					board[r+3][c] = hs;
					shipNum++;
					shipNum++;
					shipNum++;
				}
			}
			
			else if(z != 'l' && z != 'r')
				System.out.println("Invalid");
			
			printPlacedShipBoard(board);
		}//end while loop
	}
	
	public static void printPlacedShipBoard(ShipCell [] [] board){
		
		System.out.print(" r/c \t0\t1\t2\t3\t4\t5\t6 ");
		for(int i=0; i<board.length; i++){
			System.out.println();
			for(int j=0; j<board[i].length;j++){
				if(j==0)
				System.out.print("  " + i);
				if(board[i][j]==he){
					System.out.print("\t-");
				}
				if(board[i][j]==hs)
					System.out.print("\tS");
				
			}
		}
	}
	
	
	static void printCurrBoard(ShipCell[][] board)
	{
		System.out.print("r/c \t0\t1\t2\t3\t4\t5\t6 ");
		for(int i=0; i<board.length; i++){
			System.out.println();
			for(int j=0; j<board[i].length;j++){
				if(j==0)
					System.out.print("  " + i);
				if(board[i][j]== he)
					System.out.print("\t-");
				if(board[i][j]==hs)
					System.out.print("\t-");
				if(board[i][j]==re)
					System.out.print("\tm");
				if(board[i][j]==rs)
					System.out.print("\tX");
			}
		}
		//Write code to print the current game state as specified
		// in the comment above
	}
	
	public static void printMoveHistory(ArrayList<Integer> row){
		//method to print history of moves taken
		System.out.println("Move History: ");
		//for(int m = 0; m<moves; m++){
		for(int r=0; r<row.size();r++){
			//for(int c=0;c<col.size();c++){
			
			if(r%2==0){
				
			 System.out.print( "Move "+ ((r/2) +1) + ": " + row.get(r) + " " + row.get(r+1) +"\n");
			//}
			}
		}
	}
	}
	
	
	

