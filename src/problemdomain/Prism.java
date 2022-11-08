package problemdomain;

public abstract class Prism extends Shape{

	private double side;
	
	public Prism() {
		
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}
	
	@Override
	public double calcVolume() {
		return calcBaseArea()*getHeight();
		
	}

	@Override
	public String toString() {
		return "Prism [side=" + side + ", getSide()=" + getSide() + ", getHeight()=" + getHeight() + ", calcVolume()="
				+ calcVolume() + ", calcBaseArea()=" + calcBaseArea() + "]";
	}
}
