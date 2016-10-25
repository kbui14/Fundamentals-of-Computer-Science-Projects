package project5;



/* CS 225 - Fundamentals of Computer Science
 * File Name: P5_Bui_Hotel.java
 * Java Programming
 * Project 5 - Due 06/10/2015
 * Instructor: Dan Grissom
 * 
 * Name 1: Kevin Bui
 * Description: Create a java application which acts as a hotel reservation system. 
 */


public class P5_Bui_Hotel {
	
	
	public int uniqueId;
	public String hotalName;
	public String streetAddress;
	public String city;
	public String stateAbbreviation;
	public double pricePerNight;
	
	public P5_Bui_Hotel(int Id, String Name, String Address,
			String cityName, String state, double price) {
		
		uniqueId = Id;
		hotalName = Name;
		streetAddress = Address;
		city = cityName;
		stateAbbreviation = state;
		pricePerNight = price;
		
	}
	public int getUniqueId() {
		return uniqueId;
	}
	public String getHotalName() {
		return hotalName;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public String getCity() {
		return city;
	}
	public String getStateAbbreviation() {
		return stateAbbreviation;
	}
	public double getPricePerNight() {
		return pricePerNight;
	}
	
	public String toString(){
		return "Unique ID: " + uniqueId
				+"\tHotel Name: " + hotalName
				+"\tStreet Address: " + streetAddress
				+"\tCity: " + city
				+"\tState: " + stateAbbreviation
				+"\tpricePerNight: " + pricePerNight;
	}
	
	
	
}
