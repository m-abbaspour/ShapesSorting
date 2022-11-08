package problemdomain;

public class Cone extends Shape{

	private double radius;

	public Cone() {
	}
	
	public Cone(double radius) {
		this.radius = radius;
	}
	
	public Cone(double height, double radius) {
		this.setHeight(height);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double calcBaseArea() {
		return Math.PI*Math.pow(radius, 2);
	}

	@Override
	public double calcVolume() {
		return calcBaseArea()*getHeight()/3.0;
	}

	@Override
	public String toString() {
		return "Cone [radius=" + getRadius() + ", calcBaseArea()=" + calcBaseArea() + ", calcVolume()=" + calcVolume()
				+ ", getHeight()=" + getHeight() + "]";
	}
	
	
}
