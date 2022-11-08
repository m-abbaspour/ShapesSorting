package problemdomain;

public class SquarePrism extends Prism{

	public SquarePrism() {

	}

	public SquarePrism(double height, double side) {
		setHeight(height);
		setSide(side);
	}

	@Override
	public double calcBaseArea() {
		return Math.pow(this.getSide(), 2);
	}

	
}
