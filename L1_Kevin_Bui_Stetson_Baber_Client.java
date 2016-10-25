package cs225;

/* CS 225 -  Fundamentals of Computer Science
 * File Name: L1_Kevin_Bui_Stetson_Baber.java
 * Java Programming
 * Lab 1 - Due 1/26/15
 * Instructor: Dan Grissom
 * 
 * Name 1: Kevin Bui
 * Name 2: Stetson Baber
 * Description: This file contains the source code for problem #1
 * for Lab 1.
 */

import java.util.Scanner;
public class L1_Kevin_Bui_Stetson_Baber_Client {
	public static void main(String[] args){
		System.out.println("Kevin Bui & Stetson Baber");
		System.out.println("Lab 1, Problem # 1");
		System.out.println("");
		
		String phrase = "";
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter a sentence: ");
		phrase = scan.nextLine();
		
		L1_Kevin_Bui_Stetson_Baber.stringToChar(phrase);
	}//close main
}//close class
