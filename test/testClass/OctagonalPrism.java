package testClass;

/**
 * This class extends the Shape and represents an Octagonal Prism.
 */
public class OctagonalPrism extends Shape{
	
	/**
	 * Edge Length for Octagonal Prism
	 */
	private double edgeLength;
	
	/**
	 * Empty Constructor
	 */
	public OctagonalPrism() {
		
	}
	
	/**
	 * Constructs an object representing Octagonal prism
	 * @param height
	 * @param edgeLength
	 */
	public OctagonalPrism(double height, double edgeLength) {
		super(height);
		this.edgeLength = edgeLength;
	}

	@Override
	public int compare(Shape o1, Shape o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {

		return "OctagonalPrism   [Base Area = " + baseArea() + ", Volume = " + volume() + ", Height = " + getHeight() + "]";
	}

	@Override
	public double baseArea() {
		// TODO Auto-generated method stub
		return 2*(1+Math.sqrt(2))*edgeLength*edgeLength;
	}

	@Override
	public boolean equals(Object obj) {
		
	    if (this == obj) return true;
	    else if (obj == null || getClass() != obj.getClass()) return false;
	    OctagonalPrism shape = (OctagonalPrism) obj;
	    return Double.compare(this.volume(), shape.volume()) == 0 && Double.compare(this.volume(), shape.volume()) == 0 ;
	    
	}
	
	@Override
	public double volume() {
		double baseArea = 2*(1+Math.sqrt(2))*edgeLength*edgeLength;
		return baseArea*getHeight();
	}

}
