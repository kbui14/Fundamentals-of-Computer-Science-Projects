package cs225;

public class P1_Kevin_Bui_Stetson_Baber_P2 {
	/* CS 225 -  Fundamentals of Computer Science
	 * File Name: P1_Kevin_Bui_Stetson_Baber_P2.java
	 * Java Programming
	 * Lab 1 - Due 1/30/15
	 * Instructor: Dan Grissom
	 * 
	 * Name 1: Kevin Bui
	 * Name 2: Stetson Baber
	 * Description: Write a class encapsulating 
	 * the concept of converting integer grades to
	 *  letter grades (A, B, C, D,or F), assuming 
	 *  grades are composed of an array of integers
	 *   between 0 and 100.
	 */
	
	public static void main(String[] args) {
		// Your program should always output your name and the lab/problem
					// number. DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("Kevin Bui & Stetson Baber");
		System.out.println("Lab 1, Problem # 1");
		System.out.println("");
		
		 int [] ranGrades = new int [10];
		// Constructor initializes array with random values
		new P1_Kevin_Bui_Stetson_Baber_P1(10);
		System.out.println("There are " + P1_Kevin_Bui_Stetson_Baber_P1.getNumStudents() + " students.");
		
		P1_Kevin_Bui_Stetson_Baber_P1.toString(ranGrades);
		System.out.println();
		P1_Kevin_Bui_Stetson_Baber_P1.LetterGradesArray(ranGrades);
		int [] newGrades =  {80, 69, 23, 63, 100, 97, 76, 56, 42,50};
		System.out.println("\nOh no! There was a problem with the system and everyone got random grades. Here are the correct grades: ");
		P1_Kevin_Bui_Stetson_Baber_P1.setGrades(newGrades);
		P1_Kevin_Bui_Stetson_Baber_P1.toString(newGrades);
		System.out.println();
		P1_Kevin_Bui_Stetson_Baber_P1.LetterGradesArray(newGrades);
		System.out.println("\nTime for a $" + P1_Kevin_Bui_Stetson_Baber_P1.partyMoney(newGrades) + " party!");
		}
		
	}


