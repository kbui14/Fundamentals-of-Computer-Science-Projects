package cs225;

import java.io.Serializable;
/* CS 225 -  Fundamentals of Computer Science
 * File Name: L5_Lastname1_Lastname2_UniqueObject_P2.java
 * Java Programming
 * Lab 5 - Due 2/23/15
 * Instructor: Dan Grissom
 * 
 * Name 1: Kevin Bui
 *
 * Description:  Create a inherited class structure
 */

public class L5_Kevin_Bui_EmployeeClass_P2 extends L5_Kevin_Bui_UniqueObject_P2 implements Serializable
{
	private String firstName;
	private String lastName;
	protected double hourlyRate;
	protected double years;
	
	public static void main(String[] args){
		System.out.println("Kevin Bui");
		System.out.println("Lab 5, Problem # 2");
		System.out.println("");
		}
	
	L5_Kevin_Bui_EmployeeClass_P2() {
		
		
		firstName = "John Doe";
		hourlyRate = 9.00;
		years = 0;
	}
	
	 L5_Kevin_Bui_EmployeeClass_P2(String fn,String ln, double hr, double y) {
		firstName = fn;
		lastName = ln;
		hourlyRate = hr;
		years = y;
	}
	
	

	protected String getFirstName() {
		return firstName;
	}

	protected String getLastName() {
		return lastName;
	}

	protected double getHourlyRate() {
		return hourlyRate;
	}

	protected double getYears() {
		return years;
	}

	protected double getYearlySalary(){
		double Salary = hourlyRate * 40D * 52D;
		return Salary;
	}
	
	protected void promote(){
		years++;
		hourlyRate = hourlyRate * 1.03;
	}

	public String toString(){
		String employeeInfo;
		employeeInfo = firstName + " " + lastName + " ("+ getUniqueIdString() + ") has been with the company for " + years + " years and makes " + dff.format(hourlyRate) + "/hr";
		return employeeInfo;
	}
	
}
