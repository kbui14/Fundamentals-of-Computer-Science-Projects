package cs225;
/* CS 225 - Fundamentals of Computer Science
 * File Name: L7_Bui_Baber_Client_P3.java
 * Java Programming
 * Lab 7 Problem 3 - Due 03/23/2015
 * Instructor: Dan Grissom
 * 
 * Name 1: Kevin Bui
 * Name 2: Stetson Baber
 * Description: Write a program which tests two passwords being submit on a webpage.
 */


import java.util.Scanner;
public class L7_Bui_Baber_Client_P3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String pw1,pw2;
		boolean success = false;
		L7_Bui_Baber_Password_P3 pass = null;
		
		
		
				// Your program should always output your name and the lab/problem
				// number. DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
				System.out.println("Kevin Bui & Stetson Baber");
				System.out.println("Lab 7 Problem 3 - Demonstration");
				System.out.println("");
				
		do{
		try{
			System.out.println("Please enter a password");
			pw1 = scan.next();
			System.out.println("Please enter your password one more time for verification.");
			pw2 = scan.next();
			pass = new L7_Bui_Baber_Password_P3(pw1,pw2);
			success = true;
		}
		catch(L7_Bui_Baber_IllegalPasswordException_P3 e ){
			System.out.println(e.getMessage());
		}
		finally{
			if(success == true)
			System.out.println("Congratulations! Your password is: " + pass.getPassword());
		}
		}while(!success);
	}

}
