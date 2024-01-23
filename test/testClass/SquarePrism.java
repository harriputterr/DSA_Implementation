package testClass;

/**
 * This class extends the Shape and represents a Square Prism
 */
public class SquarePrism extends Shape{
	@Override
	public String toString() {
		
		return "SquarePrism      [Base Area = " + baseArea() + ", Volume = " + volume() + ", Height = " + getHeight() + "]";
	}
	
	/**
	 * Edge Length for Square Prism
	 */
	private double edgeLength;
	
	/**
	 * Empty Constructor
	 */
	public SquarePrism() {
		
	}
	
	/**
	 * Constructs an object of Square Prism
	 * @param height
	 * @param edgeLength
	 */
	public SquarePrism(double height, double edgeLength) {
		super(height);
		this.edgeLength = edgeLength;
	}

	/**
	 * Getter for Edge Length
	 * @return the edgeLength
	 */
	public double getEdgeLength() {
		return edgeLength;
	}

	@Override
	public boolean equals(Object obj) {
		
	    if (this == obj) return true;
	    else if (obj == null || getClass() != obj.getClass()) return false;
	    SquarePrism shape = (SquarePrism) obj;
	    return Double.compare(this.volume(), shape.volume()) == 0 && Double.compare(this.volume(), shape.volume()) == 0 ;
	    
	}
	

	@Override
	public int compare(Shape o1, Shape o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double baseArea() {
		// TODO Auto-generated method stub
		return edgeLength*edgeLength;
	}

	@Override
	public double volume() {
		// TODO Auto-generated method stub
		return edgeLength*edgeLength*getHeight();
	}
	
}
