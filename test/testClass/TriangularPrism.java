package testClass;
/**
 * This class extends the Shape and represents a Triangular Prism.
 */

public class TriangularPrism extends Shape {
	@Override
	public String toString() {

		return "Triangular Prism [Base Area = " + baseArea() + ", Volume = " + volume() + ", Height = " + getHeight() + "]";
	}
	/**
	 * Constructs an object of Triangular Prism
	 * @param height
	 * @param edgeLength
	 */
	public TriangularPrism(double height, double edgeLength) {
		super(height);
		this.edgeLength = edgeLength;
	}
	/**
	 * Empty Constructor
	 */
	public TriangularPrism() {
		
	}
	/**
	 * Edge Length for Triangular Prism
	 */
	private double edgeLength;

	/** Getter for Edge Length
	 * @return the edgeLength
	 */
	public double getEdgeLength() {
		return edgeLength;
	}
	
	@Override
	public int compare(Shape o1, Shape o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double baseArea() {
		// TODO Auto-generated method stub
		return (edgeLength*edgeLength * Math.sqrt(3))/4;
	}

	@Override
	public double volume() {
		double baseArea = (edgeLength*edgeLength * Math.sqrt(3))/4;
		return baseArea*getHeight();
	}
	
	@Override
	public boolean equals(Object obj) {
		
	    if (this == obj) return true;
	    else if (obj == null || getClass() != obj.getClass()) return false;
	    TriangularPrism shape = (TriangularPrism) obj;
	    return Double.compare(this.volume(), shape.volume()) == 0 && Double.compare(this.volume(), shape.volume()) == 0 ;
	    
	}
	
}
