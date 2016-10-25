package cs225;

/* CS 225 -  Fundamentals of Computer Science
 * File Name: P1_Kevin_Bui_Stetson_Baber_P1.java
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
import java.util.Arrays;
import java.util.Random;
public class P1_Kevin_Bui_Stetson_Baber_P1 {
	
	//declare instants variables
	private static int students;
	private static int [] count;
	private static int [] grades;
	private static char [] letterGrades;
	private static int partyCost;
	
	
	
	public static void main(String[] args){
		// Your program should always output your name and the lab/problem
					// number. DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("Kevin Bui & Stetson Baber");
		System.out.println("Lab 1, Problem # 1");
		System.out.println("");
	}//close main

	//constructor that sets array with random values
	public P1_Kevin_Bui_Stetson_Baber_P1(int a) {
		students = a;
		
		grades = new int[students];
		Random randomGenerator = new Random();
		for(int i=0; i<students; i++){
			int randomInt = randomGenerator.nextInt(101);
			grades [i] += randomInt;
		}
	//return the number of students 
	}
	public static int getNumStudents(){
		return students;	
	}
	//return the grades
	public static int[] getGrades(){
		
		Arrays.copyOf(grades, grades.length);
		
		return grades;
		
		
		}
	//replaces old grades with new grades
	public static void setGrades(int [] newGrade){
	for(int i=0; i<newGrade.length; i++)
		grades[i] = newGrade[i];
		}

	//prints out the current grades
	public static void toString (int [] a){
	
		for(int i=0; i<a.length; i++){
		System.out.print(grades[i] + " ");
		}
	//print student grades into letter grades
	}
	
	//converts number grades into letter grades
	public static char[] LetterGradesArray(int [] a){
		letterGrades = new char [students];
		for(int i=0; i<a.length; i++){
			if(grades[i]<=100 && grades[i]>=90)
				letterGrades[i]='A';
			if(grades[i]<90 && grades[i]>79)
				letterGrades[i]='B';
			if(grades[i]<80 && grades[i]>69)
				letterGrades[i]='C';
			if(grades[i]<70 && grades[i]>59)
				letterGrades[i]='D';
			if(grades[i]<60)
				letterGrades[i]='F';	
		}
	//calls upon the method that counts the letter grades
	countLetterGrades(letterGrades);

	return letterGrades;
	}

	
	//counts the letter grades
	public static int[] countLetterGrades(char [] a){
		count = new int [5];
		for( int i=0; i<a.length ; i++){//open for loop
			if(a[i]=='a' || a[i]=='A')
				count[0]++;
			if(a[i]=='b' || a[i]=='B')
				count[1]++;	
			if(a[i]=='c' || a[i]=='C')
				count[2]++;
			if(a[i]=='d' || a[i]=='D')
				count[3]++;
			if(a[i]=='f' || a[i]=='F')
				count[4]++;
		}//close for loop
			System.out.print("A: " + count[0] + " B: " + count[1] + " C: " +
					count[2] + " D: " + count[3] + " F: " + count[4]);	
				return count;
		}

	
	//adds up the letter grades for the cost of the party
	public static int partyMoney(int [] a){
		partyCost += count[0] * 20;
		partyCost += count[1] * 10;
		partyCost += count[2] * 5;
		return partyCost;
	}
}

