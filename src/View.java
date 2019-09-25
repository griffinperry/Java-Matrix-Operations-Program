/* Assignment: Lab 1
 * Author: Griffin McPherson */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class View extends JFrame{
	//GUI Components, those needed at the class level (global)
	JLabel rowLabel1 = new JLabel("Matrix 1 rows/cols");
	JLabel rowLabel2 = new JLabel("Matrix 2 rows/cols");
	JTextField rows1 = new JTextField("enter #rows for M1");
	JTextField cols1 = new JTextField("enter #columns for M1");
	JTextField rows2 = new JTextField("enter #rows for M2");
	JTextField cols2 = new JTextField("enter #columns for M2");
	
	JButton createB = new JButton("Create Matrices");
	
	JComboBox operations = new JComboBox();
	JButton executeB = new JButton("Execute");
	JButton resetB = new JButton("Reset");
	JButton quitB = new JButton("QUIT");
	
	JTextField feedBack = new JTextField(100);
	JPanel centerPanel; JPanel m1Panel;JPanel m2Panel;
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel(); 
	public Color TCUColors = new Color(77,25,121);
	
	
	public static void main(String args[]) {
		new View();
	}
	//View Cosntructor Method
	public View() {
		setTitle("Matrix Operations Program");
		feedBack.setText("Feedback to the user");
		rowLabel1.setFont(new Font("Helvetica",Font.BOLD,18));
		rowLabel2.setFont(new Font("Helvetica",Font.BOLD,18));
		panel4.setLayout(new GridLayout(4,1));
		panel1.setBackground(TCUColors);
		panel2.setBackground(TCUColors);
		panel3.setBackground(TCUColors);
		panel4.setBackground(TCUColors);
		
		operations.addItem("Choose Operation");
		operations.addItem("Add");
		operations.addItem("Transpose");
		operations.addItem("Subtract");
		operations.addItem("Multiply");
	
		panel1.setLayout(new GridLayout(3,2));
		rowLabel1.setForeground(Color.WHITE);
		rowLabel2.setForeground(Color.WHITE);
		rowLabel1.setFont(new Font("Helvetica",Font.BOLD,18));
		rowLabel2.setFont(new Font("Helvetica", Font.BOLD, 18));
		
		panel1.add(rowLabel1); panel1.add(rowLabel2); 
		panel1.add(rows1); panel1.add(rows2); panel1.add(cols1);
		panel1.add(cols2);
		
		panel2.add(createB);
		
		panel3.setLayout(new GridLayout(2,2));
		panel3.add(operations); panel3.add(executeB); panel3.add(resetB); panel3.add(quitB);
		
		panel4.add(panel1); panel4.add(panel2); panel4.add(panel3); panel4.add(feedBack);
		
		add(panel4);
		
		setBounds(0,0,600,500);
		setVisible(true);
		validate();
	}
	

}
