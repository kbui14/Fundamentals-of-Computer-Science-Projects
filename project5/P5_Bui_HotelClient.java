package project5;

/* CS 225 - Fundamentals of Computer Science
 * File Name: P5_Bui_HotelClient.java
 * Java Programming
 * Project 5 - Due 06/10/2015
 * Instructor: Dan Grissom
 * 
 * Name 1: Kevin Bui
 * Description: Create a java application which acts as a hotel reservation system. 
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Scanner;



public class P5_Bui_HotelClient {

	public static int hotelChosen;
	public static int startDay;
	public static int startMonth;
	public static int daysWantToStay;
	public static double pricePaid;
	public static boolean ableToBook;
	public static int count = 0;
	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<P5_Bui_Reservations> tempRes = new ArrayList<P5_Bui_Reservations>();
	public static ArrayList<P5_Bui_Reservations> reservation = new ArrayList<P5_Bui_Reservations>();
	public static ArrayList<P5_Bui_Hotel> Hotel = new ArrayList<P5_Bui_Hotel>();

	
	public static void main(String[] args) throws ConcurrentModificationException {
		System.out.println("Kevin Bui");
		System.out.println("Project 4");
		System.out.println("");
		
		try{
		reserveSpot();
		}
		catch(ConcurrentModificationException e){
			e.printStackTrace();
		}
	}
	

	//FileInputStream fis = new FileInputStream("Hotels.txt");
	public static void readHotels(){
		Scanner fs;
		try {
			fs = new Scanner(new File("Hotels.txt"));
			
			
			while (fs.hasNext())
			{
				
				
				String HotelStr = fs.nextLine();
				HotelStr = HotelStr.replace("Hotel(", "");
				HotelStr = HotelStr.replace(")", "");
				Scanner a = new Scanner(HotelStr);
				a.useDelimiter(",");	
				int Id = Integer.parseInt(a.next().trim());
				String Name = a.next().trim();
				String Address = a.next().trim();
				String city = a.next().trim();
				String state = a.next().trim();
				double price = Double.parseDouble(a.next().trim());
				
				P5_Bui_Hotel h = new P5_Bui_Hotel(Id, Name, Address, city, state, price);
				Hotel.add(h);
				
				a.close();
				
			}
			for (P5_Bui_Hotel fr : Hotel)
				System.out.println(fr.toString());
		
		
		} 
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
			
		
		
		
		//Ask user for reservation date
		public static void reserveSpot() throws ConcurrentModificationException   {
			readHotels();

			do{
				try{
					count = 0;
					System.out.println("Welcome to the Hotel California! Please select a hotel you wish to stay in: ");
					hotelChosen = scan.nextInt();
					
					if(hotelChosen > 0 && hotelChosen < 6)
					System.out.println("You have chosen: " + Hotel.get(hotelChosen-1).toString());
					
					System.out.println("Which MONTH do you wish to make a reservation? (1-12)");
					startMonth = scan.nextInt();
					System.out.println("Which DAY do you wish to make a reservation? (1-31)");
					startDay = scan.nextInt();
					System.out.println("How long do you wish to stay?");
					daysWantToStay = scan.nextInt();
					
					reservation.clear();
					P5_Bui_Reservations agh = new P5_Bui_Reservations(hotelChosen,startMonth,startDay,daysWantToStay);
					reservation.add(agh);
					
					tempRes.clear();
					try{
						
						
						Scanner rs = new Scanner(new File("Reservations.txt"));
						
						while (rs.hasNextLine()){
							
					String Read = rs.nextLine();
					//Read = Read.replace("Hotel(", "");
					//Read = Read.replace(")", "");
					Scanner a = new Scanner(Read);
					a.useDelimiter(",");	
					int Id = Integer.parseInt(a.next().trim());
					int Sm = Integer.parseInt(a.next().trim());
					int Sd = Integer.parseInt(a.next().trim());
					int L = Integer.parseInt(a.next().trim());
					for(int i=0; i<daysWantToStay; i++){
						P5_Bui_Reservations r = new P5_Bui_Reservations(Id,Sm,Sd+i,L);
						tempRes.add(r);
					}
						}
					}
					catch(FileNotFoundException e){
						createNewFile();
					}
					
					//check for time confliction
					for(P5_Bui_Reservations res: reservation){
						for(P5_Bui_Reservations res1: tempRes){
							if(res.toString().equals(res1.toString())){
								System.out.println("Sorry this date has already been booked!");
								ableToBook = false;
								reservation.clear();
								tempRes.clear();
							}
						}
					}
					
					
					
					if(startMonth > 12 || startMonth < 1){
						System.out.println("Sorry, that is not a valid month!");
						ableToBook = false;
						reservation.clear();
						count++;
					}
					else if (count == 0)
						ableToBook = true;
					if(startDay > 31 || startDay < 1){
						System.out.println("Sorry, that is not a valid day!");
						ableToBook = false;
						reservation.clear();
						count++;
					}
					else if (count == 0)
						ableToBook = true;
					//if(hotelChosen > Hotel.size() || hotelChosen < 1){
						//System.out.println("Sorry, that is not a valid hotel!");
						//ableToBook = false;
						//reservation.clear();
						//count++;
				//	}
					//else if (count == 0)
						//ableToBook = true;
					if(((daysWantToStay-1) + startDay) > 31){
						System.out.println("Sorry, the Hotel California does not allow you to check out in a different month because reasons...");
						ableToBook = false;
						reservation.clear();
						count++;
					}
					else if (count == 0)
						ableToBook = true;
					
					
						
					
				}
				catch(FileNotFoundException e){
					e.printStackTrace();
					ableToBook = false;
				}
				catch(ConcurrentModificationException e){
					
					ableToBook = false;
				}
				
				finally{
					if(ableToBook == true){
					if(hotelChosen > 0 && hotelChosen < 6){
					System.out.println("Your reservation is complete! Thank you for choosing Hotel California!\nYour Price will be: " + (Hotel.get(hotelChosen-1).pricePerNight*daysWantToStay));
					bookRes();
					}
					else{
						ableToBook = false;
						System.out.println("Sorry, that is not a valid hotel!");
					}
				}
			}
				
			}
			while(!ableToBook);
		}
		
		public static void bookRes(){
			FileOutputStream fos;
			try {
				fos = new FileOutputStream("Reservations.txt", true);
				PrintWriter pw = new PrintWriter(fos);
				pw.print(hotelChosen + ", ");
				pw.print(startMonth + ", ");
				pw.print(startDay + ", ");
				pw.print(daysWantToStay);
				pw.println();
				pw.close();
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		public static void createNewFile() throws FileNotFoundException{
			FileOutputStream fos = new FileOutputStream("Reservations.txt", false);
			PrintWriter pw = new PrintWriter(fos);
			pw.print("");
			pw.close();
		}
			
}
