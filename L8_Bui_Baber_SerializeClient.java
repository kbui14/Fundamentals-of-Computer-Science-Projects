package cs225;
/* CS 225 -  Fundamentals of Computer Science
 * File Name: L8_Bui_Baber_SerializeClient_P2.java
 * Java Programming
 * Lab 5 - Due 2/30/15
 * Instructor: Dan Grissom
 * 
 * Name 1: Kevin Bui
 * Name 2: Stetson Baber
 *
 * Description:  Write a program that allows you to save employees to and read
employees from a file.
 */
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Scanner;

public class L8_Bui_Baber_SerializeClient {

	public static void main(String[] args){
		
		System.out.println("Kevin Bui");
		System.out.println("Lab 5, Problem # 2");
		System.out.println("");
		
		
		
		ArrayList<L5_Kevin_Bui_EmployeeClass_P2> employees = new ArrayList<L5_Kevin_Bui_EmployeeClass_P2>();
		int a;
		String First;
		String Last;
		double hourlyRate;
		double years;
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to SEE all employees or ADD a new employee? (1 or 2)");
		a = scan.nextInt();
		
		if(a == 1 ){
			
			try {
				readEmployeeFromFile("employee.txt", employees);
			} 
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else 
			if (a == 2){
			System.out.println("What is the employee's First and Last name?");
			First = scan.next();
			Last = scan.next();
			System.out.println("What is the employee's hourly rate?");
			hourlyRate = scan.nextDouble();
			System.out.println("How long has this employee been working here? (years)");
			years = scan.nextInt();
			
			L5_Kevin_Bui_EmployeeClass_P2 e = new L5_Kevin_Bui_EmployeeClass_P2(First,Last,hourlyRate, years);
			employees.add(e);
			try {
				updateEmployeeFile("employee.txt", employees);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}

	public static void readEmployeeFromFile(String fileName,ArrayList <L5_Kevin_Bui_EmployeeClass_P2> employee) throws IOException {
		
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			try 
			{
				while(employee != null){
				{
				L5_Kevin_Bui_EmployeeClass_P2 e = (L5_Kevin_Bui_EmployeeClass_P2) ois.readObject();
				employee.add(e);
				//System.out.println(e.toString());
				}
			}
			}
				catch (StreamCorruptedException e)
				{
					System.out.println("");
				}
				catch (EOFException e)
				{
					e.printStackTrace();
				}
			
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			finally
			{
				
				ois.close();
				
					
			}
			for (L5_Kevin_Bui_EmployeeClass_P2 e : employee)
				System.out.println(e.toString());
		}
	
	public static void updateEmployeeFile(String fileName, ArrayList<L5_Kevin_Bui_EmployeeClass_P2> employee) throws IOException{
		readEmployeeFromFile(fileName, employee);
		FileOutputStream fos = new FileOutputStream(fileName, true);
		ObjectOutputStream oos = new ObjectOutputStream (fos);
		try 
		{
			for(L5_Kevin_Bui_EmployeeClass_P2 e: employee)
			oos.writeObject(e);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally{
			oos.close();
			
		}
		
		
		
	}

}
