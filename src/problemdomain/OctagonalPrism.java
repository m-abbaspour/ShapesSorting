package problemdomain;

public class OctagonalPrism extends Prism{

	private final int NUMBER = 2;

	public OctagonalPrism() {
		
	}
	
	public OctagonalPrism(double height, double side) {
		this.setHeight(height);
		this.setSide(side);
	}
	
	@Override
	public double calcBaseArea() {
		return 2.0*(
					1 + Math.sqrt(NUMBER)
				)*Math.pow(getSide(), 2);
	}

	
}
