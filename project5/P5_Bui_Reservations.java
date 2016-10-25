package project5;

/* CS 225 - Fundamentals of Computer Science
 * File Name: P5_Bui_Reservations.java
 * Java Programming
 * Project 5 - Due 06/10/2015
 * Instructor: Dan Grissom
 * 
 * Name 1: Kevin Bui
 * Description: Create a java application which acts as a hotel reservation system. 
 */

import java.util.ArrayList;

public class P5_Bui_Reservations {
	int uniqueId;
	int beginDay;
	int startMonth;
	int length;
	boolean canBook;
	
	
	public P5_Bui_Reservations(int uniqueId, int startMonth,int beginDay, int length) {
		
		this.uniqueId = uniqueId;
		this.beginDay = beginDay;
		this.startMonth = startMonth;
		this.length = length;
		
		
	}



	ArrayList <P5_Bui_Reservations> reservations = new ArrayList <P5_Bui_Reservations>();
	//do we need a construtor?
	
	
	public void addReservation (P5_Bui_Reservations r){
		reservations.add(r);
	}
	
	
	public boolean getCanBook (){
		
		return canBook;
		
	}

	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	public int getBeginDay() {
		return beginDay;
	}

	public void setBeginDay(int beginDay) {
		this.beginDay = beginDay;
	}



	public int getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}


	public ArrayList<P5_Bui_Reservations> getReservations() {
		return reservations;
	}

	public void setReservations(ArrayList<P5_Bui_Reservations> reservations) {
		this.reservations = reservations;
	}
	
	public String toString(){
		return  uniqueId
				+"\tStart Month: " + startMonth
				+"\tStart Day: " + beginDay
				+"\tNights Staying";
				
	}
	
	
}
