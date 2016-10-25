package cs225;

/* CS 225 - Fundamentals of Computer Science
 * File Name: L7_Bui_Baber_Password_P3.java
 * Java Programming
 * Lab 7 Problem 2 - Due 05/23/2015
 * Instructor: Dan Grissom
 * 
 * Name 1: Kevin Bui
 * Name 2: Stetson Baber
 * Description: Write a program which tests two passwords being submit on a webpage. 
 */

public class L7_Bui_Baber_Password_P3 {
	private String password;
	int count = 0;

	public String getPassword() {
		return password;
	}

	public L7_Bui_Baber_Password_P3(String p1, String p2) throws L7_Bui_Baber_IllegalPasswordException_P3 {
		if(upper1AtLeast(p1) == true)
			count++;
		else 
			throw new L7_Bui_Baber_IllegalPasswordException_P3 ("Password does not contain at least 1 uppercase letter.");
		
		if(lower1AtLeast(p1) == true)
			count++;
		else 
			throw new L7_Bui_Baber_IllegalPasswordException_P3 ("Password does not contain at least 1 lowercase letter.");
		
		if(integer1AtLeast(p1) == true)
			count++;
		else 
			throw new L7_Bui_Baber_IllegalPasswordException_P3 ("Password does not contain at least 1 number.");
		
		if(lengthValid(p1) == true)
			count++;
		else 
			throw new L7_Bui_Baber_IllegalPasswordException_P3 ("Password must at least be 5 characters long.");
		
		if(Verify(p1,p2)==true)
			count++;
		else
			throw new L7_Bui_Baber_IllegalPasswordException_P3 ("Your passwords were not the same!");
		
		if(count == 5)
			password = p2;
	}


	public static boolean upper1AtLeast(String pw){//checks for at least 1 upper case letter in the password
		char c;
		int count = 0;
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i = 0; i<pw.length();i++)
		{//for loop
			c = pw.charAt(i);
			if(upperCase.indexOf(c) != -1)
				count++;
		}//end of for loop
		if (count>=1) 
			return true;
		return false;
	}//end of upper1

	public static boolean lower1AtLeast(String pw){//checks for at least 1 lower case letter in the password
		char c;
		int count = 0;
		String lowerCase = "abcdefghijklmnopqrsuvwxyz";
		for(int i = 0; i<pw.length();i++)
		{//for loop
			c = pw.charAt(i);
			if(lowerCase.indexOf(c) != -1)
				count++;
		}//end of for loop
		if (count>=1) 
			return true;
		return false;
	}//end of lower1
	
	public static boolean integer1AtLeast(String pw){//checks for at least 1 integer within the password
		char c;
		int count = 0;
		String digits = "0123456789";
		for(int i = 0; i<pw.length();i++)
		{//for loop
			c = pw.charAt(i);
			if(digits.indexOf(c) != -1)
				count++;
		}//end of for loop
		if (count>=1) 
			return true;
		return false;
	}//end of 2 digits
	
	public static boolean lengthValid(String pw){ //checks for the password length
		int i = pw.length();
		if(i>=5)
		return true;
		return false;
	}//end of length
	
	public static boolean Verify(String pw1, String pw2){
		int count = 0;
		for(int i = 0; i<pw2.length(); i++){
			if(pw1.charAt(i)==pw2.charAt(i))
				count++;
			if(count==pw2.length() && count==pw1.length())
				return true;
		}
		return false;
	}
}
