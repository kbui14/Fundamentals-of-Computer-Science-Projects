package cs225;
/* CS 225 - Fundamentals of Computer Science
 * File Name: L7_Bui_Baber_P2.java
 * Java Programming
 * Lab 7 Problem 2 - Due 05/23/2015
 * Instructor: Dan Grissom
 * 
 * Name 1: Kevin Bui
 * Name 2: Stetson Baber
 * Description: Your program will ask the user
 *  to select a day of the week via an integer.
 */
import java.util.Scanner;
import javax.swing.JOptionPane;
public class L7_Bui_Baber_P2 {
	public static void main(String[] args){

	String [] daysOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	int num = 0;
	boolean worked = false;
	String a = null;
	//Scanner scan = new Scanner(System.in);
	
	System.out.println("Kevin Bui & Stetson Baber");
	System.out.println("Lab 7 Problem 2 - Demonstration");
	System.out.println("");
	
	do{
		try{
			String numStr = JOptionPane.showInputDialog("Please select a day of the week via an integer (1-7)");
			num = Integer.parseInt(numStr);
			//System.out.print("Please select a day of the week via an integer (1-7)");
			//num = scan.nextInt();
			a = daysOfWeek[num-1];
			worked = true;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Invalid Input: Please enter an integer between 1 and 7");
			//System.out.println("Invalid Input: Please enter an integer between 1 and 7");
		}
		finally{
			if(num>0 && num<7)
				JOptionPane.showMessageDialog(null, "You've selected " + a);
			//System.out.println("You've selected " + a);
		}
		
		
	}while(!worked);
	}
}
