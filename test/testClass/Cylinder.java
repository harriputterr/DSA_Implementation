package testClass;

/**
 * This class extends the Shape and represents a Cylinder.
 */
public class Cylinder extends Shape{
	/**
	 * Cylinder radius
	 */
	private double radius;

	/**
	 * Getter for the radius
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * Constructor for Cylinder.
	 * @param height
	 * @param radius
	 */
	public Cylinder(double height, double radius) {
		super(height);
		this.radius = radius;
	}
	
	/**
	 * Empty Constructor.
	 */
	public Cylinder() {
		
	}
	
	public double baseArea() {
		return PI*radius*radius;
	}

	@Override
	public double volume() {
		// TODO Auto-generated method stub
		return PI*radius*radius*getHeight();
	}

	@Override
	public int compare(Shape o1, Shape o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {

		return "Cylinder         [Base Area = " + baseArea() + ", Volume = " + volume() + ", Height = " + getHeight() + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		
	    if (this == obj) return true;
	    else if (obj == null || getClass() != obj.getClass()) return false;
	    Cylinder shape = (Cylinder) obj;
	    return Double.compare(this.getHeight(), shape.getHeight()) == 0 && Double.compare(this.getRadius(), shape.getRadius()) == 0 ;
	    
	}
}
