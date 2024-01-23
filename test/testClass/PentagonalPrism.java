package testClass;

/**
 * This class extends the Shape and represents a Pentagonal Prism
 */
public class PentagonalPrism extends Shape{
	/**
	 * Edge Length for Pentagonal Prism
	 */
	private double edgeLength;
	
	/**
	 * Empty Constructor
	 */
	public PentagonalPrism() {
	}
	
	/**
	 * Constructs an object representing Pentagonal Prism.
	 * @param height
	 * @param edgeLength
	 */
	public PentagonalPrism(double height, double edgeLength) {
		super(height);
		this.edgeLength = edgeLength;
	}

	@Override
	public int compare(Shape o1, Shape o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		
	    if (this == obj) return true;
	    else if (obj == null || getClass() != obj.getClass()) return false;
	    PentagonalPrism shape = (PentagonalPrism) obj;
	    return Double.compare(this.volume(), shape.volume()) == 0 && Double.compare(this.volume(), shape.volume()) == 0 ;
	    
	}
	
	@Override
	public double baseArea() {
		// TODO Auto-generated method stub
		return (5*edgeLength*edgeLength*Math.tan(0.942478))/4; // 54 degrees in Radians ~ 0.942478
	}

	@Override
	public double volume() {
		double baseArea = (5*edgeLength*edgeLength*Math.tan(0.942478))/4;
		return baseArea*getHeight();
	}
	@Override
	public String toString() {

		return "PentagonalPrism  [Base Area = " + baseArea() + ", Volume = " + volume() + ", Height = " + getHeight() + "]";
	}
	
}
