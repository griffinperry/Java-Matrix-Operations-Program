import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Control extends View implements ActionListener{
	public Model m;
	public static void main(String args[]) {
		new Control();
	}
	public Control() {
		m = new Model(this);
		setButtons();
	}
	/* method definition for adding ActionListeners to the buttons being interacted with*/
	public void setButtons() {
		createB.addActionListener(this);
		executeB.addActionListener(this);
		resetB.addActionListener(this);
		quitB.addActionListener(this);
		m.clearB1.addActionListener(this);
		m.clearB2.addActionListener(this);
		m.readB1.addActionListener(this);
		m.readB2.addActionListener(this);
		m.clearB1.addActionListener(this);
		m.clearB2.addActionListener(this);
		m.clearB3.addActionListener(this);
		m.openB1.addActionListener(this);
		m.openB2.addActionListener(this);
		m.openB3.addActionListener(this);
		m.saveB3.addActionListener(this);
	}
	/* method definition for ActionEvent- clicking button */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		int index = operations.getSelectedIndex();
		if (o == createB) m.addFrames();
		
		else if (o == executeB && index ==1) m.addMatrices();
		else if (o == executeB && index == 2) m.transposeMatrices();
		else if (o == executeB && index == 3) m.subtractMatrices();
		else if (o == executeB && index == 4) m.multMatrices();
		
		else if (o == resetB) m.reset();
		else if (o == quitB) m.quit();
		else if (o == m.readB1) m.procReadM1();
		else if (o == m.readB2) m.procReadM2();
		else if (o== m.clearB1) m.clear1();
		else if (o == m.clearB2) m.clear2();
		else if (o == m.clearB3)m.clear3();
		else if (o == m.saveB3) m.saveFileModel(m.fileField3.getText());
		else if (o == m.openB1) m.openFile(m.fileField1.getText());
		else if (o == m.openB2) m.openFile(m.fileField2.getText());
		else if (o == m.openB3) m.openFile(m.fileField3.getText());
	}	   
	 
}
