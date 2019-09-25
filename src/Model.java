import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Model {
	public Model(Control fromC) {
		c = fromC;
	}
	 JFrame matrixFrame3 = new JFrame("Result Matrix");
	 JButton clearB1 = new JButton("Clear");JButton clearB2 = new JButton("Clear"); JButton clearB3 = new JButton("Clear");
	 JButton readB1 = new JButton("Read");JButton readB2 = new JButton("Read");
	 JButton saveB3 = new JButton("Save");
	 JButton openB1 = new JButton("Open");JButton openB2 = new JButton("Open"); JButton openB3 = new JButton("Open");
	 JLabel fileName1 = new JLabel("File");JLabel fileName2 = new JLabel("File"); JLabel fileName3 = new JLabel("File");
	 JTextField fileField1 = new JTextField(10);JTextField fileField2 = new JTextField(10); 
	 JTextField fileField3 = new JTextField(10);
	 JFrame matrixFrame1 = new JFrame("X Matrix");
     JFrame matrixFrame2 = new JFrame("Y Matrix"); 
     JFrame resultFrame = new JFrame("Result Matrix");
     JTextField[][] elements1 ; JTextField[][] elements2; JTextField[][] resultElements; JTextField[][] savedElements;
	 int rowData1;
	 int rowData2; 
	 int colData1;
	 int colData2;
     double[][] data;
     double[][] data2;
     double[][] resultData;
	 public Control c;
	 
	 // objects needed for persistence
	// private MatrixInfo[] matrixDataModel = new MatrixInfo[50];
	 private MatrixInfo matrixDataModel;
	 private MatrixPers persistence;
	 private int numStatus = 0;
	 /* method definition for adding the initial two matrices after user input for rows and columns */
	public void addFrames()
	   {  
	      if(validateInteger(c.rows1) && validateInteger(c.rows2) && validateInteger(c.cols1) && validateInteger(c.cols2))
	           {   
	    	   c.feedBack.setText("Feedback to the user");
	    	   rowData1 = Integer.parseInt(c.rows1.getText());
          	   rowData2 = Integer.parseInt(c.rows2.getText());
          	   colData1 = Integer.parseInt(c.cols1.getText());
          	   colData2 = Integer.parseInt(c.cols2.getText());
          	   
          	   elements1 = new JTextField[rowData1][colData1];
          	   elements2 = new JTextField[rowData2][colData2];
 	           
 	           matrixFrame1.setLayout(new BorderLayout());
 	           
 	           matrixFrame2.setLayout(new BorderLayout());
     	       c.m1Panel = new JPanel(new GridLayout(rowData1,colData1,2,2));
     		   c.m2Panel = new JPanel(new GridLayout(rowData2,colData2,2,2));
     		   JPanel bottomPanel1 = new JPanel();
     		   JPanel bottomPanel2 = new JPanel();
          	 
               c.m1Panel.setBackground(Color.red);
               c.m2Panel.setBackground(Color.blue);
               
               bottomPanel1.add(clearB1); bottomPanel1.add(readB1);bottomPanel1.add(fileName1);bottomPanel1.add(fileField1);
               bottomPanel1.add(openB1);
               
               bottomPanel2.add(clearB2); bottomPanel2.add(readB2);bottomPanel2.add(fileName2);bottomPanel2.add(fileField2);
               bottomPanel2.add(openB2);
               
               matrixFrame1.add(c.m1Panel, BorderLayout.CENTER);
               matrixFrame1.add(bottomPanel1, BorderLayout.SOUTH);
               matrixFrame2.add(c.m2Panel, BorderLayout.CENTER);
               matrixFrame2.add(bottomPanel2, BorderLayout.SOUTH);
    
               //System.out.println(dataR +  " " + numData);
               for( int i = 0; i<rowData1 ; i++ )
            	   for (int j=0; j<colData1; j++){
	                  {  elements1[i][j] = new JTextField(10);
	                     c.m1Panel.add( elements1[i][j]);
	                  }
            	   }
               for (int i =0; i<rowData2 ; i++) {
            	   for (int j=0; j<colData2; j++) {
	            	   elements2[i][j] = new JTextField(10);
	            	   c.m2Panel.add(elements2[i][j]);
            	   }
               }
                
               matrixFrame1.setBounds(0,0,600,300);
               matrixFrame2.setBounds(0,0,600,300);
               matrixFrame1.setVisible(true);
               matrixFrame2.setVisible(true);
	            } 
	   }
	/* method definition for validating an integer */
	public boolean validateInteger(JTextField datum)
	   { try
	         {  int  d =  Integer.parseInt(datum.getText());
	            return true;
	         }
	      catch (NumberFormatException e)
	         { System.out.println("invalid Integer" );
	            c.feedBack.setText("Invalid integer retype");
	            return false;
	         }
	   }
   public boolean validateNumber(JTextField datum)
   { try
         {  double  d =  Double.parseDouble(datum.getText());
            return true;
         }
      catch (NumberFormatException e)
         { System.out.println("invalid Integer " );
            c.feedBack.setText("Invalid number please retype");
            return false;
         }
   }
   /* method definition for resetting the program */
	public void reset()
	   {   
		   c.rows1.setText("enter #rows for M1");
		   c.cols1.setText("enter #columns for M1");
		   c.rows2.setText("enter #rows for M2");
		   c.cols2.setText("enter #columns for M2");
		   if(c.centerPanel!=null)resultFrame.remove(c.centerPanel);
	       matrixFrame1.remove(c.m1Panel);
	       matrixFrame2.remove(c.m2Panel);
	       
	       data = null; 
	       data2 = null;
	       resultData = null;
	       if(matrixFrame1!=null) matrixFrame1.dispose();
	       if(matrixFrame2!=null) matrixFrame2.dispose();
	       if(resultFrame!=null) resultFrame.dispose();
	       c.operations.setSelectedIndex(0);
	       c.feedBack.setText("Program has been reseted.");
		   
	    } 
	/* method definition for quitting out of the matrix frames */
	public void quit() {
		matrixFrame1.dispose();
		matrixFrame2.dispose();
		resultFrame.dispose();
		c.feedBack.setText("Matrix frames have been quitted.");}
	public void clear1() {
		
		for( int i = 0; i<rowData1 ; i++ )
     	   for (int j=0; j<colData1; j++){
               { 
                  elements1[i][j].setText(null);
                  
               }
     	   }
	}
public void clear2() {
		
		for( int i = 0; i<rowData2 ; i++ )
     	   for (int j=0; j<colData2; j++){
               { 
                  elements2[i][j].setText(null);
                  
               }
     	   }
	}
public void clear3() {
	
	for( int i = 0; i<resultData.length ; i++ )
 	   for (int j=0; j<resultData[0].length; j++){
           { 
              resultElements[i][j].setText(null);
              
           }
 	   }
}
	/* method definition for reading the first, 
	parsing the integers, and putting the data into an array */
	public void procReadM1() {
	     data = new double [rowData1][colData1];
	     
		for (int i = 0; i < rowData1; i++) {
			for (int j=0; j<colData1; j++) {
				if (validateNumber(elements1[i][j])) {
				data[i][j] = Integer.parseInt(elements1[i][j].getText());
				System.out.println("element [" +i+ "][" +j+ "] in matrix 1 is " + data[i][j]);
				
				}
				else c.feedBack.setText("invalid integer inputs in matrix 1");
			}
		}	
		}
	/* method definition for reading the first, 
	parsing the integers, and putting the data into an array */
	public void procReadM2() {
		data2= new double [rowData2][colData2];
		for (int i = 0; i < rowData2; i++) {
			for (int j = 0; j < colData2; j++) {
				if (validateNumber(elements2[i][j])) {
				data2[i][j] = Integer.parseInt(elements2[i][j].getText());
				System.out.println("element [" +i+ "][" +j+ "] in matrix 2 is " + data2[i][j]);
				
				}
				else c.feedBack.setText("invalid integer inputs in matrix 2");
			}
		}	
		}
	
	/* method definition for adding the elements in the two matrices */
	public void addMatrices() {
		
		if(rowData1==rowData2 && colData1==colData2) {
			resultFrame.setLayout(new BorderLayout());
			c.centerPanel = new JPanel(new GridLayout(rowData1, rowData2, 2,2));
			c.centerPanel.setBackground(Color.GREEN);
			JPanel bottomPanel = new JPanel();
			bottomPanel.add(clearB3); bottomPanel.add(fileName3); bottomPanel.add(fileField3); bottomPanel.add(saveB3); bottomPanel.add(openB3);
			resultData = new double [rowData1][colData2];
			resultElements = new JTextField[rowData1][colData1];
			
		for (int i=0; i<rowData1; i++) {
			for (int j=0; j<colData1; j++) {
				resultData[i][j] = data[i][j]+data2[i][j];
				System.out.println("element [" +i+ "][" +j+ "] in result matrix is " + resultData[i][j]);
				resultElements[i][j] = new JTextField(10);
				resultElements[i][j].setText(String.valueOf(resultData[i][j]));
				c.centerPanel.add(resultElements[i][j]);
			}
		}
			resultFrame.add(c.centerPanel, BorderLayout.CENTER);
			resultFrame.add(bottomPanel, BorderLayout.SOUTH);
			resultFrame.setBounds(0,0,600,300);
			resultFrame.setVisible(true);	
			c.feedBack.setText("Matrices have been added and the resulting matrix is displayed");
			
			//code needed for persistence
			MatrixInfo tempMatrix = new MatrixInfo(); // this is the object you are storing in 
			tempMatrix.setMatrix(resultData);
			matrixDataModel = tempMatrix;
		      //matrixDataModel[numStatus] = tempMatrix;
		      numStatus++;
		}
		else {
			c.feedBack.setText("The matrix dimensions must be the same for addition.");
		}
	}
	
	/* method definition for transposing the first matrix */
	public void transposeMatrices() {
			resultFrame.setLayout(new BorderLayout());
			c.centerPanel = new JPanel(new GridLayout(colData1, rowData2, 2,2));
			c.centerPanel.setBackground(Color.GREEN);
			JPanel bottomPanel = new JPanel();
			bottomPanel.add(clearB3); bottomPanel.add(fileName3); bottomPanel.add(fileField3); bottomPanel.add(saveB3); bottomPanel.add(openB3);
			resultData = new double [data[0].length][data.length];
			resultElements = new JTextField[data[0].length][data.length];
			
			for (int i=0; i<data.length; i++) {
				for (int j=0; j<data[0].length; j++) {
					System.out.println(data[i][j]);
					resultData[j][i] = data[i][j];
					//System.out.println(resultData[j][i]);
					//System.out.println(resultData[i][j]);
					System.out.println("element [" +j+ "][" +i+ "] in result matrix is " + resultData[j][i]);
					resultElements[j][i] = new JTextField(10);
					resultElements[j][i].setText(String.valueOf(resultData[j][i]));
				}
			}
			for (int j=0; j<data[0].length; j++) {
				for (int i=0; i<data.length; i++) {
			c.centerPanel.add(resultElements[j][i]);
			}
				}
			
			resultFrame.add(c.centerPanel, BorderLayout.CENTER);
			resultFrame.add(bottomPanel, BorderLayout.SOUTH);
			resultFrame.setBounds(0,0,600,300);
			resultFrame.setVisible(true);	
			c.feedBack.setText("Matrix X has been transposed and the resulting matrix is displayed.");
			
			//code needed for persistence
			MatrixInfo tempMatrix = new MatrixInfo(); // this is the object you are storing in 
			tempMatrix.setMatrix(resultData);
			matrixDataModel = tempMatrix;
		      //matrixDataModel[numStatus] = tempMatrix;
		      numStatus++;
		
	}
	/* method definition for subtracting the second matrix from the first matrix*/
	public void subtractMatrices() {
		if(rowData1==rowData2 && colData1==colData2) {
			resultFrame.setLayout(new BorderLayout());
			c.centerPanel = new JPanel(new GridLayout(rowData1, rowData2, 2,2));
			c.centerPanel.setBackground(Color.GREEN);
			JPanel bottomPanel = new JPanel();
			bottomPanel.add(clearB3); bottomPanel.add(fileName3); bottomPanel.add(fileField3); bottomPanel.add(saveB3); bottomPanel.add(openB3);
			resultData = new double [rowData1][colData2];
			resultElements = new JTextField[rowData1][colData1];
			
		for (int i=0; i<rowData1; i++) {
			for (int j=0; j<colData1; j++) {
				resultData[i][j] = data[i][j]-data2[i][j];
				System.out.println("element [" +i+ "][" +j+ "] in result matrix is " + resultData[i][j]);
				resultElements[i][j] = new JTextField(10);
				resultElements[i][j].setText(String.valueOf(resultData[i][j]));
				c.centerPanel.add(resultElements[i][j]);
			}
		}
			resultFrame.add(c.centerPanel, BorderLayout.CENTER);
			resultFrame.add(bottomPanel, BorderLayout.SOUTH);
			resultFrame.setBounds(0,0,600,300);
			resultFrame.setVisible(true);	
			c.feedBack.setText("Matrices have been subtracted and the resulting matrix is displayed");
			
			//code needed for persistence
			MatrixInfo tempMatrix = new MatrixInfo(); // this is the object you are storing in 
			tempMatrix.setMatrix(resultData);
			matrixDataModel = tempMatrix;
		    //matrixDataModel[numStatus] = tempMatrix;
		    numStatus++;
		}
		else {
			c.feedBack.setText("The matrix dimensions must be the same for addition.");
		}
		
	}
	/* method definition for multiplying the two matrices */
	public void multMatrices() {
		if (colData1 == rowData2) {
			resultFrame.setLayout(new BorderLayout());
			c.centerPanel = new JPanel(new GridLayout(rowData1, colData2, 2,2));
			c.centerPanel.setBackground(Color.GREEN);
			JPanel bottomPanel = new JPanel();
			bottomPanel.add(clearB3); bottomPanel.add(fileName3); bottomPanel.add(fileField3); bottomPanel.add(saveB3); bottomPanel.add(openB3);
			resultData = new double [rowData1][colData2];
			resultElements = new JTextField[rowData1][colData2];
			
			for(int i = 0; i< rowData1; i++) {
				 for(int j = 0; j< colData2; j++) {
					 for(int k = 0; k< colData1; k++)
					 { resultData[i][j] += data[i][k]*data2[k][j];
					 }
					 	System.out.println("element [" +i+ "][" +j+ "] in result matrix is " + resultData[i][j]);
						resultElements[i][j] = new JTextField(10);
						resultElements[i][j].setText(String.valueOf(resultData[i][j]));
						c.centerPanel.add(resultElements[i][j]);
					 
				 }
			}
			resultFrame.add(c.centerPanel, BorderLayout.CENTER);
			resultFrame.add(bottomPanel, BorderLayout.SOUTH);
			resultFrame.setBounds(0,0,600,300);
			resultFrame.setVisible(true);
			c.feedBack.setText("Matrices have been multiplied and the resulting matrix is displayed");
			
			//code needed for persistence
			MatrixInfo tempMatrix = new MatrixInfo(); // this is the object you are storing in 
			tempMatrix.setMatrix(resultData);
			matrixDataModel = tempMatrix;
		   // matrixDataModel[numStatus] = tempMatrix;
		    numStatus++;
		}
		else {
			c.feedBack.setText("The number of rows of Matrix 1 must equal the number of columns of Matrix 2");
		}
		
	}
	/* method definition for saving the resultant matrix */
	 public void saveFileModel(String fileName)
	  {   
		 matrixDataModel.getMatrix();
		 persistence = new MatrixPers(matrixDataModel);
	     persistence.saveFile(fileName);
	     System.out.println("file has been saved");
	  }
	 /* method definition for opening the resultant matrix */
	 public void openFile(String fileName) {
		 try {
			 persistence = new MatrixPers(matrixDataModel);
			 matrixDataModel = persistence.readFile(fileName);
			 
			 double[][] openedMatrix = matrixDataModel.getMatrix();
			 savedElements = new JTextField[openedMatrix.length][openedMatrix[0].length];
			 System.out.println(openedMatrix.length);
			 System.out.println(openedMatrix[0].length);
			 /*the following code was for trying to present the saved matrix in the GUI, which I found to be unnecessary
			 and not explicitly described as a requirement.
			 matrixFrame1.setLayout(new BorderLayout());
				c.m1Panel = new JPanel(new GridLayout(openedMatrix.length, openedMatrix[0].length, 2,2));
				c.m1Panel.setBackground(Color.RED);
				JPanel bottomPanel = new JPanel();
				bottomPanel.add(clearB1); bottomPanel.add(fileName1); bottomPanel.add(fileField1); bottomPanel.add(openB1);
			for( int i = 0; i<rowData1 ; i++ )
            	   for (int j=0; j<colData1; j++){
	                  { 
	                     c.m1Panel.remove( elements1[i][j]);
	                  }
            	   } */
			 System.out.println("The matrix for the opened file is:");
			 for (int i=0; i<openedMatrix.length; i++) {
				 for (int j=0; j<openedMatrix[0].length; j++) {
					System.out.println( "[" + i + "] ["+j+"] :"+ String.valueOf(openedMatrix[i][j]));
				 }
				 /*the following code was for trying to present the saved matrix in the GUI, which I found to be unnecessary
				 and not explicitly described as a requirement.
					savedElements[i][j] = new JTextField(10);
					savedElements[i][j].setText(String.valueOf(openedMatrix[i][j]));
					c.m1Panel.add(savedElements[i][j]);
				 }
				 System.out.println("saved matrix has been added");	 
			 /*matrixFrame1.add(c.m1Panel, BorderLayout.CENTER);
			 matrixFrame1.add(bottomPanel, BorderLayout.SOUTH);
			 matrixFrame1.setBounds(0,0,600,300);
			 matrixFrame1.setVisible(true); */
			 }
			 
			 System.out.println("The saved matrix has been opened in the console.");
			 c.feedBack.setText("The saved matrix has been opened in the console");
		 }
		 catch (NullPointerException e) {System.out.println("file could not be found"); }
		 
	 }
}
