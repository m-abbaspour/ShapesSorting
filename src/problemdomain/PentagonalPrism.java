package problemdomain;

public class PentagonalPrism extends Prism{

	private final int DEGREES = 54;
	
	public PentagonalPrism() {
		
	}
	
	public PentagonalPrism(double height, double side) {
		this.setHeight(height);
		this.setSide(side);
	}
	
	@Override
	public double calcBaseArea() {
		return (5 *
				Math.pow(getSide(), 2) * 
				Math.tan(Math.toRadians(DEGREES))
				)/4;
	}

	

}
