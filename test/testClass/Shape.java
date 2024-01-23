package testClass;
import java.util.*;


/**
 * This our Abstract Shape Super Class which represents the 3D objects being used in this assignment.
 */
public abstract class Shape implements Comparable<Shape>, Comparator<Shape>{
	
	private double height;
	public final double PI = Math.PI;

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	public Shape(double height) {
		this.height = height;
	}
	
	public Shape() {
		
	}
	/**
	 * Method to calculate Base Area
	 * @return Base Area of the Shape
	 */
	public abstract double baseArea();
	/**
	 * Method to calculate Volume
	 * @return Volume of the Shape
	 */
	public abstract double volume ();
	
	// Compares two shapes by their height.
	public int compareTo(Shape that){
		if (this.getHeight() > that.getHeight()) {
			return 1;
		}
		else if (this.getHeight() < that.getHeight()) {
			return -1;
		}
		else{
			return 0;
		}
		
	}
	
	
	// Compares two shapes by their base area and volume.
	public int compare;
}
