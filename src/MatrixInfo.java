import java.io.Serializable;

public class MatrixInfo implements Serializable{
	private double[][] matrix;
	public MatrixInfo() {};
	 /* method definition for setting the 2d array for the matrix */
	public void setMatrix(double[][] d) {
		matrix = d;
		System.out.println("Matrix stored in an array");
	}
	/* method definition for getting the 2d array for the matrix */
	public double[][] getMatrix() {
		System.out.println("The stored matrix has been read");
		return matrix;
	}

}
