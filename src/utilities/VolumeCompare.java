package utilities;

import java.util.Comparator;

import problemdomain.Shape;

public class VolumeCompare implements Comparator<Shape>{
    public int compare(Shape shape1, Shape shape2) {
        if (shape1.calcVolume() > shape2.calcVolume())
            return 1;
        if (shape1.calcVolume() < shape2.calcVolume())
            return -1;
        return 0;
    }
}
