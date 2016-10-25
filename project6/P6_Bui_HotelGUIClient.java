package project6;

/* CS 225 - Fundamentals of Computer Science
 * File Name: P6_Bui_HotelGUIClient.java
 * Java Programming
 * Project 5 - Due 04/26/2015
 * Instructor: Dan Grissom
 * 
 * Name 1: Kevin Bui
 * Description: Create a java application which acts as a hotel reservation system with a GUI. 
 */


import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;







public class P6_Bui_HotelGUIClient extends JFrame {

	
	
	//Components
	
	private JPanel contentPane;
	private JComboBox comboBox;
	private JList list;
	private JSpinner sMonth;
	private JSpinner sDay;
	private JSpinner eMonth;
	private JSpinner eDay;
	private JButton btnGetHotelInfo;
	private JButton btnMakeReservation;
	
	//Models
	
	DefaultComboBoxModel BoxModel;
	DefaultListModel listModel;
	SpinnerNumberModel stMonth;	
	SpinnerNumberModel stDay;
	SpinnerNumberModel edMonth;
	SpinnerNumberModel edDay;

	//Array Lists
	public static ArrayList<Bui_Hotel> Hotels = new ArrayList<Bui_Hotel>();
	public static ArrayList<Bui_Reservation> tempRes = new ArrayList<Bui_Reservation>();
	public static ArrayList<Bui_Reservation> reservation = new ArrayList<Bui_Reservation>();
	

	
	public static void main(String[] args) {
		System.out.println("Kevin Bui");
		System.out.println("Project 6");
		System.out.println("");
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P6_Bui_HotelGUIClient frame = new P6_Bui_HotelGUIClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Constructor
	public P6_Bui_HotelGUIClient() throws FileNotFoundException {
		setTitle("Hotel California's Reservation Menu\n");
		initComponent();
		eventHandler();
	}
	
	
	//Gui Frame Components
	private void initComponent() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		BoxModel = new DefaultComboBoxModel();
		comboBox = new JComboBox(BoxModel);
		
		JLabel lblChooseAHotel = new JLabel("Choose a Hotel:");
		
		listModel = new DefaultListModel();
		list = new JList(listModel);
		list.setEnabled(false);
		
		stMonth = new SpinnerNumberModel(1,1,12,1);
		sMonth = new JSpinner(stMonth);
		
		stDay = new SpinnerNumberModel(1,1,31,1);
		sDay = new JSpinner(stDay);
		
		edMonth = new SpinnerNumberModel(1,1,12,1);
		eMonth = new JSpinner(stMonth);
		eMonth.setEnabled(false);
		
		edDay = new SpinnerNumberModel(1,1,31,1);
		eDay = new JSpinner(edDay);
		
		btnMakeReservation = new JButton("Make Reservation");
		
		JLabel lblReservations = new JLabel("Reservations:");
		
		JLabel lblCheckinDay = new JLabel("Check-in Day:");
		
		JLabel lblCheckinMonth = new JLabel("Check-in Month:");
		
		JLabel lblCheckoutDay = new JLabel("Check-out Day:");
		
		JLabel lblCheckoutMonth = new JLabel("Check-out Month:");
		
		btnGetHotelInfo = new JButton("Get Hotel Info.");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblChooseAHotel)
								.addComponent(lblReservations, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(104)
									.addComponent(btnGetHotelInfo, GroupLayout.PREFERRED_SIZE, 117, Short.MAX_VALUE)))
							.addGap(25)
							.addComponent(lblCheckinMonth, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addComponent(sMonth, GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE)
							.addGap(13))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(list, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(13)
									.addComponent(lblCheckinDay, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addComponent(sDay, GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE)
									.addGap(13))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(13)
									.addComponent(lblCheckoutMonth, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addComponent(eMonth, GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE)
									.addGap(13))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(13)
									.addComponent(lblCheckoutDay, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addComponent(eDay, GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE)
									.addGap(13))
								.addComponent(btnMakeReservation, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))))
					.addGap(14))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblChooseAHotel)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(24)
									.addComponent(lblReservations))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addComponent(btnGetHotelInfo)
							.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addComponent(lblCheckinMonth))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addComponent(sMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(list, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
							.addGap(3))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(12)
									.addComponent(lblCheckinDay))
								.addComponent(sDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(12)
									.addComponent(lblCheckoutMonth))
								.addComponent(eMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(12)
									.addComponent(lblCheckoutDay))
								.addComponent(eDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(12)
							.addComponent(btnMakeReservation, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
		);
		contentPane.setLayout(gl_contentPane);

	}

	
	
	////////////////////////////////////////////////////////
	//Method for Event Handling as well as handling Models
	////////////////////////////////////////////////////////
	private void eventHandler() throws FileNotFoundException {
		
		
		readHotels();
	for(int i=0;i<Hotels.size();i++){
			
			BoxModel.addElement(Hotels.get(i).getHotelName());
			}
	listModel.clear();
	comboBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
	try{
		readReservations();
		
		listModel.clear();
		for(int i=0;i<tempRes.size();i++){
		if(comboBox.getSelectedIndex()+1 == tempRes.get(i).getHotelId() || tempRes.get(i).getHotelId() == comboBox.getSelectedIndex()+1){
			listModel.addElement(tempRes.get(i).toString());
			
			
				
			}
		}
		}
		
		
		
		catch( FileNotFoundException  e1){
			
		} 
		}
	});
	
	
	//Clicks button to obtain the Hotel information (i.e. price per night)
	btnGetHotelInfo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
				JOptionPane.showMessageDialog(null,Hotels.get(0).toString()
						+ Hotels.get(1).toString()
						+ Hotels.get(2).toString()
						+ Hotels.get(3).toString()
						+ Hotels.get(4).toString(), "Hotel Information", EXIT_ON_CLOSE);
		}
	});
	
	//sets the Reservations Text Field to correspond to selected Hotel
	
	
	
	//Add the Reservation
	btnMakeReservation.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//reservation.clear();
			int Month = (int) stMonth.getNumber();
			int startDay = (int) stDay.getNumber();
			int endDay = (int) edDay.getNumber();
			Bui_Reservation res = new Bui_Reservation(Hotels.get(comboBox.getSelectedIndex()).getUniqueId(),Month,startDay,endDay);
			for(int i=0;i<Hotels.size();i++){
				
				if(Hotels.get(i).canBook(res)){
				Hotels.get(i).addResIfCanBook(res);
				printReservations();
				}
				else{
					Hotels.get(i).doNotAdd(res);
				}
			}
			
		}
	});
	
	}
	
	
	

	////////////////////////////////////////////////////////
	//Reads in the Hotel.txt and inputs it into an array
	////////////////////////////////////////////////////////
	public static void readHotels(){
		Scanner fs;
		try {
			fs = new Scanner(new File("Hotels.txt"));
			
			
			while (fs.hasNextLine())
			{
				
				
				String HotelStr = fs.nextLine();
				HotelStr = HotelStr.replace("Hotel(", "");
				HotelStr = HotelStr.replace(')', ' ');
				Scanner a = new Scanner(HotelStr);
				a.useDelimiter(",");
				long Id = Long.parseLong(a.next().trim());
				String Name = a.next().trim();
				String Address = a.next().trim();
				String city = a.next().trim();
				String state = a.next().trim();
				double price = Double.parseDouble(a.next().trim());
				
				Bui_Hotel h = new Bui_Hotel(Id, Name, Address, city, state, price);
				Hotels.add(h);
				
				a.close();
				
			}
		} 
		
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	////////////////////////////////////////////////////////
	//Creates a new File
	////////////////////////////////////////////////////////
	public static void createNewFile() throws FileNotFoundException{
		FileOutputStream fos = new FileOutputStream("Reservations.txt", false);
		PrintWriter pw = new PrintWriter(fos);
		pw.print("");
		pw.close();
	}
	
	
	////////////////////////////////////////////////////////
	//Reads Reservation.text
	////////////////////////////////////////////////////////
	public static void readReservations() throws FileNotFoundException{
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
	int Em = Integer.parseInt(a.next().trim());
	int Sd = Integer.parseInt(a.next().trim());
	int Ed = Integer.parseInt(a.next().trim());
	
	Bui_Hotel addHotel = new Bui_Hotel(Id, Hotels.get(Id).getHotelName(), Hotels.get(Id).getAddress(), Hotels.get(Id).getCity(), Hotels.get(Id).getStateAbbrev(), Hotels.get(Id).getPricePerNight());
	Bui_Reservation r = new Bui_Reservation(Id,Sm,Em,Sd,Ed);
		//addHotel.addReservation(r);
		//addHotel.getReservations();
		tempRes.add(r);
		
		
		

		
	}
	
	}
	catch(FileNotFoundException e){
		createNewFile();
	}
	}
	
	
	////////////////////////////////////////////////////////
	//Prints new Reservation to new text file
	////////////////////////////////////////////////////////
	public void printReservations(){
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("Reservations.txt", true);
			PrintWriter pw = new PrintWriter(fos);
			pw.print( Hotels.get(comboBox.getSelectedIndex()).getUniqueId() + ", ");
			pw.print((int) stMonth.getNumber() + ", ");
			pw.print((int) stMonth.getNumber() + ", ");
			pw.print((int) stDay.getNumber() + ", ");
			pw.print((int) edDay.getNumber());
			pw.println();
			pw.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
