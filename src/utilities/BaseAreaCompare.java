package utilities;

import java.util.Comparator;

import problemdomain.Shape;

public class BaseAreaCompare implements Comparator<Shape> {

	public int compare(Shape shape1, Shape shape2) {
		if (shape1.calcBaseArea() > shape2.calcBaseArea()) {
			return 1;
		} else if (shape1.calcBaseArea() < shape2.calcBaseArea()) {
			return -1;
		} else {
		return 0;
		}
	}


}
