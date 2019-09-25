import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MatrixPers implements Serializable{
	private MatrixInfo matrixData;
	public MatrixPers(MatrixInfo mData) {
		matrixData = mData;
	}
	 /* method definition for saving the file using object persistence */
	public void saveFile(String file) {
		try {
		FileOutputStream fo = new FileOutputStream(new File(file));
		ObjectOutputStream o = new ObjectOutputStream(fo);
		o.writeObject(matrixData);
  
	o.close();
	fo.close();
	System.out.println("file saved as object");
		}
		catch (FileNotFoundException e) {System.out.println("File not found");}
		catch (IOException e) {System.out.println("Error initializing stream");}	 
	}
	 /* method definition for reading the file using object persistence */
	public MatrixInfo readFile(String file) {
		try {
		FileInputStream fi = new FileInputStream(new File(file));
		ObjectInputStream oi = new ObjectInputStream(fi);
		matrixData = (MatrixInfo) oi.readObject();

	
      oi.close();
	  fi.close();
	  System.out.println("file opened as an object");
		}
		catch (ClassNotFoundException e) {System.out.println("Class not found"); }
	    catch (FileNotFoundException e) {System.out.println("File not found"); }
		catch (IOException e) {System.out.println("Error initializing stream"); }

		return matrixData;
	}
	
}
