package problemdomain;

public class Cylinder extends Shape{
	
	private double radius;

	public Cylinder() {
	}
	
	public Cylinder(double radius) {
		this.radius = radius;
	}
	
	public Cylinder(double height, double radius) {
		this.setHeight(height);
		this.radius = radius;
	}

	@Override
	public double calcBaseArea() {
		return Math.PI*Math.pow(radius, 2);
	}

	@Override
	public double calcVolume() {
		return calcBaseArea()*this.getHeight();
	}
	

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Cylinder [radius=" + radius + ", calcBaseArea()=" + calcBaseArea() + ", calcVolume()=" + calcVolume()
				+ ", getHeight()=" + getHeight() + "]";
	}
	
	
}
