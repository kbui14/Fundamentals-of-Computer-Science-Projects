package part1;
/* CS 225 -  Fundamentals of Computer Science
 * File Name: L10_Kevin_Bui_P2.java
 * Java Programming
 * Lab 1 - Due 4/20/15
 * Instructor: Dan Grissom
 * 
 * Name 1: Kevin Bui
 * Description:  Use Eclipse�s Java Window Builder to create a GUI which looks similar to the one
 * seen below, which allows you to select a starting lineup from a roster of basketball players.
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class L10_Bui_P2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String[] players = new String[] {"Matthew Dellavedova (G)", "Joe Harris (G)",
			"Brendan Haywood (C)", "Kyrie Irving (G)", "LeBron James (F)", "James Jones (F)",
			"Kevin Love (F)", "Shawn Marion (F)", "Mike Miller (F)", "Timofey Mozgov (C)",
			"Kendrick Perkins (C)", "Iman Shumpert (G)", "J.R. Smith (G)", "Tristan Thompson(C)",
			"Anderson Varejao (C)"};
	
		private JList list;
		DefaultListModel model;
		DefaultListModel model2;
		private JButton button;
		private JButton button_1;
		private JList list_1;
		private JCheckBox chckbxG1;
		private JCheckBox chckbxG2;
		private JCheckBox chckbxF1;
		private JCheckBox chckbxF2;
		private JCheckBox chckbxC;
		private JButton btnStartGame;
		private int G = 0;
		private int F = 0;
		private int C = 0;
	  
	  
	public static void main(String[] args) {
		System.out.println("Kevin Bui");
		System.out.println("Lab 10, Problem # 2");
		System.out.println("");
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					L10_Bui_P2 frame = new L10_Bui_P2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	//Constructor holding two methods that run the entire program
	public L10_Bui_P2() {
		setTitle("Kevin Bui's BasketBall Roster");
		initComponent();
		eventHandler();
	}

	
	
	//Framework of the GUI
	private void initComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		model = new DefaultListModel();
		model2 = new DefaultListModel();
		list = new JList(model);
		
		
		JLabel lblRoster = new JLabel("Roster:");
		
		button = new JButton(">>>");
		
		
		button_1 = new JButton("<<<");
		
		
		JLabel lblStarter = new JLabel("Starters:");
		
		list_1 = new JList(model2);
		
		chckbxG1 = new JCheckBox("G1\n");
		chckbxG1.setEnabled(false);
		
		chckbxG2 = new JCheckBox("G2");
		chckbxG2.setEnabled(false);
		
		chckbxF1 = new JCheckBox("F1");
		chckbxF1.setEnabled(false);
		
		chckbxF2 = new JCheckBox("F2");
		chckbxF2.setEnabled(false);
		
		chckbxC = new JCheckBox("C");
		chckbxC.setEnabled(false);
		
		btnStartGame = new JButton("Start Game");

		btnStartGame.setEnabled(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRoster, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(button_1)
								.addComponent(button))))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStarter)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxG1)
								.addComponent(chckbxF1))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxF2)
								.addComponent(chckbxG2)))
						.addComponent(chckbxC)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addComponent(btnStartGame))
						.addComponent(list_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRoster)
						.addComponent(lblStarter))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(list, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxG1)
								.addComponent(chckbxG2))
							.addGap(2)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxF1)
								.addComponent(chckbxF2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxC)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnStartGame)
					.addGap(23))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(130)
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button_1)
					.addContainerGap(328, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	// Actual action handling method
	private void eventHandler() {
		for(int i=0;i<players.length;i++){
			model.addElement(players[i]);
			}
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				int click = 0;//counts if a player has already been selected so no exception problems
				//checks the G players
				if (!chckbxF2.isSelected() || !chckbxG2.isSelected() || !chckbxC.isSelected()){
			          if(chckbxG1.isSelected() && G<2 && model.elementAt(list.getSelectedIndex()).toString().endsWith("(G)")){
			        	  chckbxG2.setSelected(true);
			        	  model2.addElement(model.elementAt(list.getSelectedIndex()));
				          model.removeElementAt(list.getSelectedIndex());
				          click++;
				          G++;
			          }
			          else if(click == 0 && G<2 && model.elementAt(list.getSelectedIndex()).toString().endsWith("(G)")){
			        	  chckbxG1.setSelected(true);
			        	  model2.addElement(model.elementAt(list.getSelectedIndex()));
				          model.removeElementAt(list.getSelectedIndex());
				          click++;
				          G++;
			          }
			          
			          //checks F players
			          if(chckbxF1.isSelected() && F<2 && model.elementAt(list.getSelectedIndex()).toString().endsWith("(F)")){
			        	  chckbxF2.setSelected(true);
			        	  model2.addElement(model.elementAt(list.getSelectedIndex()));
				          model.removeElementAt(list.getSelectedIndex());
				          click++;
				          F++;
			          }
			          else if(click == 0 && F<2 && model.elementAt(list.getSelectedIndex()).toString().endsWith("(F)")){
			        	  chckbxF1.setSelected(true);
			        	  model2.addElement(model.elementAt(list.getSelectedIndex()));
				          model.removeElementAt(list.getSelectedIndex());
				          click++;
				          F++;
			          }
			          
			          
			          //checks the C player
			          if(!chckbxC.isSelected() && click == 0 && C<1 && model.elementAt(list.getSelectedIndex()).toString().endsWith("(C)")){
			        	  chckbxC.setSelected(true);
			        	  model2.addElement(model.elementAt(list.getSelectedIndex()));
				          model.removeElementAt(list.getSelectedIndex());
				          click++;
				          C++;
			          }
			          
			          
			          //if all check boxes are selected then enables Start Game button, but if it becomes unselected then it will be unable to be clicked
			          if(chckbxG2.isSelected() && chckbxF2.isSelected() && chckbxC.isSelected())
			        	  btnStartGame.setEnabled(true);
			          else 
			        	  btnStartGame.setEnabled(false);
				}
			}
				catch(Exception e1){
					//catches generic exception
				}
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int click = 0;//checks to see if player has already been added so no exception problems
				try{
					//checks G players in list 2
			          if(click == 0 && chckbxG2.isSelected() && model2.elementAt(list_1.getSelectedIndex()).toString().endsWith("(G)")){
			        	  chckbxG2.setSelected(false);
			        	  model.addElement(model2.elementAt(list_1.getSelectedIndex()));
				          model2.removeElementAt(list_1.getSelectedIndex());
				          click++;
				          G--;
			          }
			          else if(click == 0 && model2.elementAt(list_1.getSelectedIndex()).toString().endsWith("(G)")){
			        	  chckbxG1.setSelected(false);
			        	  model.addElement(model2.elementAt(list_1.getSelectedIndex()));
				          model2.removeElementAt(list_1.getSelectedIndex());
				          click++;
				          G--;
			          }
			          
			          //checks F players in list 2
			          if(click == 0 && chckbxF2.isSelected() && model2.elementAt(list_1.getSelectedIndex()).toString().endsWith("(F)")){
			        	  chckbxF2.setSelected(false);
			        	  model.addElement(model2.elementAt(list_1.getSelectedIndex()));
				          model2.removeElementAt(list_1.getSelectedIndex());
				          click++;
				          F--;
			          }
			          else if(click == 0 && model2.elementAt(list_1.getSelectedIndex()).toString().endsWith("(F)")){
			        	  chckbxF1.setSelected(false);
			        	  model.addElement(model2.elementAt(list_1.getSelectedIndex()));
				          model2.removeElementAt(list_1.getSelectedIndex());
				          click++;
				          F--;
			          }
			          
			          //checks C player in list 2
			          if(chckbxC.isSelected() && click == 0 && model2.elementAt(list_1.getSelectedIndex()).toString().endsWith("(C)")){
			        	  chckbxC.setSelected(false);
			        	  model.addElement(model2.elementAt(list_1.getSelectedIndex()));
				          model2.removeElementAt(list_1.getSelectedIndex());
				          click++;
				          C--;
			          }
			          
			          if(!chckbxG2.isSelected() || !chckbxF2.isSelected() || !chckbxC.isSelected())
			        	  btnStartGame.setEnabled(false);
			          
			          
				}
			catch(ArrayIndexOutOfBoundsException a){
				//catches exception and returns nothing
			}
			}
				
			
		});
		
		
		//if Start Game has been clicked
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Gotta get your head in the game!");
			}
		});
	
	}

}	