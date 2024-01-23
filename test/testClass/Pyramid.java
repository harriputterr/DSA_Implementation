package testClass;

/**
 * This class extends the Shape and represents a Pyramid
 */
public class Pyramid extends Shape{
	
	/**
	 * Edge Length for Pyramid
	 */
	private double edgeLength;

	/**
	 * Getter for Edge Length
	 * @return the edgeLength
	 */
	public double getEdgeLength() {
		return edgeLength;
	}

	/**
	 * Empty Constructor
	 */
	public Pyramid() {
		
	}
	
	/**
	 * Constructs an object representing Pyramid.
	 * @param height
	 * @param edgeLength
	 */
	public Pyramid(double height, double edgeLength) {
		super(height);
		this.edgeLength = edgeLength;
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
		return (edgeLength*edgeLength*getHeight())/3;
	}

	@Override
	public boolean equals(Object obj) {
		
	    if (this == obj) return true;
	    else if (obj == null || getClass() != obj.getClass()) return false;
	    Pyramid shape = (Pyramid) obj;
	    return Double.compare(this.volume(), shape.volume()) == 0 && Double.compare(this.volume(), shape.volume()) == 0 ;
	    
	}
	
	@Override
	public String toString() {
		
		return "Pyramid          [Base Area = " + baseArea() + ", Volume = " + volume() + ", Height = " + getHeight() + "]";
	}
	
}
