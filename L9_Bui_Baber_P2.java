package lab9;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class L9_Bui_Baber_P2 extends JFrame{

	private JLabel l1,l2,l3;
	private JTextField t1,t2,t3;
	private JButton b1,b2,b3,b4;
	private Container contents;
	
	public L9_Bui_Baber_P2(){
		super("YOYOYO STETSON IN THE HISSSOUUUUSSE!");
		setSize(1000,100);
		contents = getContentPane();
		contents.setLayout(new FlowLayout());
		
		l1 = new JLabel("Operand 1:");
		t1 = new JTextField("" ,10);
		
		l2 = new JLabel("Operand 2:");
		t2 = new JTextField("", 10);
		contents.add(l1);
		contents.add(t1);
		contents.add(l2);
		contents.add(t2);
		
		
		b1 = new JButton("+");
		b2 = new JButton("-");
		b3 = new JButton("*");
		b4 = new JButton("/");
		contents.add(b1);
		contents.add(b2);
		contents.add(b3);
		contents.add(b4);
		
		l3 =new JLabel("Answer:");
		t3 = new JTextField("",10);
		contents.add(l3);
		contents.add(t3);
		t3.setEditable(false);
		
		actionPerformed();
		
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		L9_Bui_Baber_P2 Calc = new L9_Bui_Baber_P2();
		
	}



	
	public void actionPerformed() {
		try{
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try{
				double a = Double.parseDouble(t1.getText());	
				double b = Double.parseDouble(t2.getText());
				l3.setText(String.valueOf(a) + "+" + String.valueOf(b) + "=");
				//if(a+b > 0)
				t3.setText(String.valueOf(a+b));
				//else
					if(a+b < 0)
					t3.setForeground(Color.RED);
					else
						t3.setForeground(Color.BLACK);
				}
					catch(NumberFormatException err){
						JOptionPane.showMessageDialog(null, "SIKE! THAT'S THE WRONG NUMBAH!",
								"ERR!", JOptionPane.ERROR_MESSAGE);
						l3.setText("N/A");
					}
			}});
			
			
			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try{
				double a = Double.parseDouble(t1.getText());	
				double b = Double.parseDouble(t2.getText());
				l3.setText(String.valueOf(a) + "-" + String.valueOf(b) + "=");
				t3.setText(String.valueOf(a-b));
				if(a-b < 0)
					t3.setForeground(Color.RED);
				else
					t3.setForeground(Color.BLACK);
					
				}
					catch(NumberFormatException err){
						JOptionPane.showMessageDialog(null, "SIKE! THAT'S THE WRONG NUMBAH!",
								"ERR!", JOptionPane.ERROR_MESSAGE);
						l3.setText("N/A");
					}
			}});
			
			b3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try{
						
					
				double a = Double.parseDouble(t1.getText());	
				double b = Double.parseDouble(t2.getText());
				l3.setText(String.valueOf(a) + "*" + String.valueOf(b) + "=");
				t3.setText(String.valueOf(a*b));
				if(a*b < 0)
					t3.setForeground(Color.RED);
				else
					t3.setForeground(Color.BLACK);
					
				}
					catch(NumberFormatException err){
					JOptionPane.showMessageDialog(null, "SIKE! THAT'S THE WRONG NUMBAH!",
							"ERR!", JOptionPane.ERROR_MESSAGE);
					l3.setText("N/A");
				}
			}});
			
			b4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try{
				double a = Double.parseDouble(t1.getText());	
				double b = Double.parseDouble(t2.getText());
				l3.setText(String.valueOf(a) + "/" + String.valueOf(b) + "=");
				t3.setText(String.valueOf(a/b));
				if(a/b < 0)
					t3.setForeground(Color.RED);
				else
					t3.setForeground(Color.BLACK);
				}
					catch(NumberFormatException err){
						JOptionPane.showMessageDialog(null, "SIKE! THAT'S THE WRONG NUMBAH!",
								"ERR!", JOptionPane.ERROR_MESSAGE);
						l3.setText("N/A");
					}
			}});
		}
		catch(NumberFormatException err){
			JOptionPane.showMessageDialog(null, "SIKE! THAT'S THE WRONG NUMBAH!",
					"ERR!", JOptionPane.ERROR_MESSAGE);
			l3.setText("N/A");
		}
		
		
	}

}
