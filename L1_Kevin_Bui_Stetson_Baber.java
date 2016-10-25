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

public class L1_Kevin_Bui_Stetson_Baber
{	//open class
	public static void main(String[] args)
	{//open main
		System.out.println("Kevin Bui & Stetson Baber");
		System.out.println("Lab 1, Problem # 1");
		System.out.println("");
	}//close main
	
	
	public static char[] stringToChar(String a){
		
		char[] string = new char [a.length()];
		for(int i=0;i<a.length(); i++)
			string[i] += a.charAt(i);
		
		vowels(string);
		return string;
		}
	
	public static void vowels(char [] a){
		int [] vowels = new int[5];
		for( int i=0; i<a.length ; i++){//open for loop
			if(a[i]=='a' || a[i]=='A')
				vowels[0]++;
			if(a[i]=='e' || a[i]=='E')
				vowels[1]++;	
			if(a[i]=='i' || a[i]=='I')
				vowels[2]++;
			if(a[i]=='o' || a[i]=='O')
				vowels[3]++;
			if(a[i]=='u' || a[i]=='U')
				vowels[4]++;
		}//close for loop
			System.out.print("A: " + vowels[0] + " E: " + vowels[1] + " I: " +
							vowels[2] + " O: " + vowels[3] + " U: " + vowels[4]);	
	}//close main
}//close class
