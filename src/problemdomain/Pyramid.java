package problemdomain;

public class Pyramid extends Shape{

	private double side;
	
	public Pyramid() {

	}
	
	public Pyramid(double side) {
		super();
		this.side = side;
	}
	
	public Pyramid(double height, double side) {
		setHeight(height);
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	@Override
	public double calcBaseArea() {
		return Math.pow(getSide(), 2);
	}

	@Override
	public double calcVolume() {
		return calcBaseArea()*getHeight()/3.0;
	}

	@Override
	public String toString() {
		return "Pyramid [side=" + side + ", getSide()=" + getSide() + ", calcBaseArea()=" + calcBaseArea()
				+ ", calcVolume()=" + calcVolume() + ", getHeight()=" + getHeight() + "]";
	}

}
