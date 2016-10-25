package project6;


/* CS 225 - Fundamentals of Computer Science
 * File Name: Bui_Reservation.java
 * Java Programming
 * Project 5 - Due 04/26/2015
 * Instructor: Dan Grissom
 * 
 * Name 1: Kevin Bui
 * Description: Create a java application which acts as a hotel reservation system with a GUI. 
 */

import java.text.DecimalFormat;


public class Bui_Reservation
{
	// Instance Variables
	long hotelId;
	int startMonth;
	int endMonth;
	int startDay;
	int endDay;
	DecimalFormat df = new DecimalFormat("$##.00");
	
	// Constructors
	Bui_Reservation(long hotId, int inMonth, int outMonth, int inDay, int outDay)
	{
		hotelId = hotId;
		startMonth = inMonth;
		endMonth = outMonth;
		startDay = inDay;
		endDay = outDay;
	}
	Bui_Reservation(long hotId, int month, int inDay, int outDay)
	{
		hotelId = hotId;
		startMonth = month;
		endMonth = month;
		startDay = inDay;
		endDay = outDay;
	}
	
	// Getters/Setters
	public long getHotelId() { return hotelId;	}
	public void setHotelId(long hotId) { hotelId = hotId; }
	public int getStartMonth() { return startMonth;	}
	public void setStartMonth(int inMonth) { startMonth = inMonth; }
	public int getEndMonth() { return endMonth;	}
	public void setEndMonth(int outMonth) { endMonth = outMonth; }
	public int getStartDay() { return startDay;	}
	public void setStartDay(int inDay) { startDay = inDay; }
	public int getEndDay() { return endDay;	}
	public void setEndDay(int outDay) {	endDay = outDay; }	
	
	public double Price(double money){
		
		return money;
	}
	
	public String toString(){
		return "Hotel ID: " + hotelId
			+ "\n\n Date Reserved: " + startMonth + "/" + startDay 
			+ "-" + endMonth + "/" + endDay;
	}
	
	public String getFormattedDisplayString (double currentPrice){
		String str = toString();
		str += "@ " + df.format(currentPrice)+ " per night";
		return str;
		
	}
}
