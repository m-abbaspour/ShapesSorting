package problemdomain;


public abstract class Shape implements Comparable<Shape>{

	private double height;

	public Shape() {
		super();
	}
	
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public abstract double calcBaseArea();
	public abstract double calcVolume();

	@Override
	public int compareTo(Shape shape) {
		if (this.getHeight() > shape.getHeight()) {
			return 1;
		} else if (this.getHeight() < shape.getHeight()) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "GeometricalShape [height=" + height + "]";
	}
}
