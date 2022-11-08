package problemdomain;

public class TriangularPrism extends Prism{
	
	public TriangularPrism() {

	}
	
	public TriangularPrism(double height, double side) {
		setHeight(height);
		setSide(side);
	}

	@Override
	public double calcBaseArea() {
		return Math.pow(getSide(), 2)*Math.sqrt(3)/4.0;
	}
}
