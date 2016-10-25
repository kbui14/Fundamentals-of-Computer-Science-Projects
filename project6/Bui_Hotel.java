package project6;


/* CS 225 - Fundamentals of Computer Science
 * File Name: Bui_Hotel.java
 * Java Programming
 * Project 5 - Due 04/26/2015
 * Instructor: Dan Grissom
 * 
 * Name 1: Kevin Bui
 * Description: Create a java application which acts as a hotel reservation system with a GUI. 
 */

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Bui_Hotel
{
	// Instance Variables
	long uniqueId;
	String hotelName;
	String address;
	String city;
	String stateAbbrev;
	double pricePerNight;
	ArrayList<Bui_Reservation> reservations = new ArrayList<Bui_Reservation>();
	
	// Constructor
	Bui_Hotel(long id, String name, String addr, String cityName, String stAbbrev, double price)
	{
		uniqueId = id;
		hotelName = name;
		address = addr;
		city = cityName;
		stateAbbrev = stAbbrev;
		pricePerNight = price;
		//reservations = new ArrayList<Reservation>();
	}
	
	// Class Methods
	public boolean canBook(Bui_Reservation newRes)
	{
		if (uniqueId != newRes.getHotelId())
			return false;
		
		
		
		for (Bui_Reservation r : reservations)
			if (!(newRes.getEndDay() <= r.getStartDay() || newRes.getStartDay() >= r.getEndDay())){
				JOptionPane.showMessageDialog(null, "NO!");
			return false;	
			}
	
		return true;
		
	}
	public void addReservation(Bui_Reservation newRes)
	{
		reservations.add(newRes);
	}
	
	public void doNotAdd(Bui_Reservation newRes)
	{
		
	}
	public boolean addResIfCanBook(Bui_Reservation newRes)
	{
		if (canBook(newRes))
		{
			addReservation(newRes);
			return true;
		}
		else
			return false;
	}
	
	
	
	// Getters/Setters
	public long getUniqueId() { 
		return uniqueId; 
		}
	public void setUniqueId(long id) { 
		uniqueId = id; 
		}
	public String getHotelName() { 
		return hotelName; 
		}
	public void setHotelName(String name) {
		hotelName = name;
		}
	public String getAddress() { 
		return address; 
		}
	public void setAddress(String addr) {
		address = addr; 
		}
	public String getCity() { 
		return city; 
		}
	public void setCity(String cityName) { 
		city = cityName;	
		}
	public String getStateAbbrev() { 
		return stateAbbrev; 
		}
	public void setStateAbbrev(String stAbbrev) { 
		stateAbbrev = stAbbrev;
		}
	public double getPricePerNight() { 
		return pricePerNight; 
		}
	public void setPricePerNight(double price) { 
		pricePerNight = price;	
		}
	public ArrayList<Bui_Reservation> getReservations() { 
		return reservations; 
		}	
	public String toString(){
		return "Hotel ID: " + uniqueId + "\n"
				+ "Hotel Name: " + hotelName + "\n"
				+ "Hotel Address: " + address + "\n"
				+ "City: " + city + "\n"
				+ "State: " + stateAbbrev + "\n"
				+ "Price Per Night: " + pricePerNight + "\n\n";
		
	}
}
