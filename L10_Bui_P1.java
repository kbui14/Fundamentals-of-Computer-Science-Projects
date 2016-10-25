package windowBuilder;

/* CS 225 -  Fundamentals of Computer Science
 * File Name: L10_Kevin_Bui_P1.java
 * Java Programming
 * Lab 1 - Due 4/20/15
 * Instructor: Dan Grissom
 * 
 * Name 1: Kevin Bui
 * Description: Use Eclipse’s Java Window Builder to create a GUI which acts as a mail-to label creator. 
 *
 */

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class L10_Bui_P1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox comboBox;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblAdress;
	private JLabel lblNewLabel;
	private JLabel lblState;
	private JLabel lblZipCode;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_1;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnNext;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("Kevin Bui");
		System.out.println("Lab 10, Problem # 1");
		System.out.println("");
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					L10_Bui_P1 frame = new L10_Bui_P1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//constructor which holds the two methods that run the program
	public L10_Bui_P1() {
		initComponent();
		eventHandler();
		
		
	}
	
	//method that holds the framework of the GUI
	public void initComponent() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(L10_Bui_P1.class.getResource("/resource/Gmail_Icon.png")));
		setTitle("Mail Time! \n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTitle = new JLabel("Title:");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Dr.", "Mr.", "Mrs.", "Ms.", "Miss"}));
		
		lblFirstName = new JLabel("FIrst Name:");
		
		lblLastName = new JLabel("Last Name:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		lblAdress = new JLabel("Address:");
		
		lblNewLabel = new JLabel("City:\n");
		
		lblState = new JLabel("State:");
		
		lblZipCode = new JLabel("Zip Code:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Gender:");
		
		rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		
		btnNext = new JButton("Submit");
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		
		JLabel lblNewLabel_2 = new JLabel("Text Format:");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(0)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
									.addGap(54)
									.addComponent(lblFirstName, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
									.addGap(79)
									.addComponent(lblLastName, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
									.addGap(82))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboBox, 0, 113, Short.MAX_VALUE)
									.addGap(6)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
									.addGap(20)
									.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
									.addGap(35))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAdress, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
									.addGap(365))
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
									.addGap(95)
									.addComponent(lblState, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
									.addGap(111)
									.addComponent(lblZipCode, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
									.addGap(37))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
									.addGap(12)
									.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
									.addGap(24)
									.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
							.addGap(13))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnFemale)
								.addComponent(rdbtnMale)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(28)))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(266))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNext)
									.addGap(12))))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblFirstName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblLastName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(comboBox))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(lblAdress)
					.addGap(12)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblState)
						.addComponent(lblZipCode))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_3)
						.addComponent(textField_4)
						.addComponent(textField_5))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(rdbtnMale)
							.addGap(10)
							.addComponent(rdbtnFemale, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNext)
								.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
							.addGap(6))))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	//method that takes all the text fields and outputs it into a text area in format required
	public void eventHandler() {
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMale.isSelected()){
				getForeground();
				textArea.setForeground(Color.blue);
				textArea.setText((String)comboBox.getSelectedItem() + " " + textField.getText() + " " + textField_1.getText() + "\n" + textField_2.getText() + "\n" + textField_3.getText() +", " + textField_4.getText() + " " +  textField_5.getText());
				}
				if(rdbtnFemale.isSelected()){
					getForeground();
					textArea.setForeground(Color.pink);
					textArea.setText(((String)comboBox.getSelectedItem() + " " + textField.getText() + " " + textField_1.getText() + "\n" + textField_2.getText() + "\n" + textField_3.getText() +", " + textField_4.getText() + " " + textField_5.getText()));
				
				}

			}
		});
	}
}
