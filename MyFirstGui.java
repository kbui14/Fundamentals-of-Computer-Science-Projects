package cs225;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFirstGui extends JFrame{

	public static void main(String[] args){
		
		MyFirstGui g = new MyFirstGui();
		
	}
	
	MyFirstGui(){
		intitComponents();
		createEvents();
	}

	//////////////////////////////////////
	//Creates components and layouts, etc.
	//////////////////////////////////////
	private void createEvents() {
		// TODO Auto-generated method stub
		
	}
	//////////////////////////////////////
	//Creates listeners and event handlers
	//////////////////////////////////////
	private void intitComponents() {
		// TODO Auto-generated method stub
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		this.setTitle("Stetson sucks!");
		
		//Create some object
		JButton b1 = new JButton("Hah GAAAAAAAAAY");
		b1.setToolTipText("Indeed he is...");
		b1.setForeground(Color.CYAN);
		b1.setBackground(Color.GREEN);
		//Add components to container
		c.add(b1);
		
		//Set initial display properties
		setSize(600,400);
		setVisible(true);
	}
	
}
