package sortmethods;

import java.util.Comparator;

import problemdomain.Shape;
import problemdomain.SquarePrism;
import utilities.BaseAreaCompare;
import utilities.VolumeCompare;


public class SelectionSort {
	public static <T> void sort(Comparable<T>[] list) {
		for (int i = 0; i < list.length; i++) {
			int min = i;

			for (int j = i + 1; j < list.length; j++) {
				if (list[min].compareTo((T) list[j]) < 0) {
					min = j;
				}
			}
			if (min != i) {
				Comparable<T> temp = list[i];
				list[i] = list[min];
				list[min] = temp;
			}
		}
	}

	public static <T> void sort(Comparable<T>[] list, Comparator<? super T> type) {
		if (type != null) {
			for (int i = 0; i < list.length; i++) {
				int min = i;

				for (int j = i + 1; j < list.length; j++) {
					if (type.compare((T) list[min], (T) list[j]) < 0) { //
						min = j;
					}
				}
				if (min != i) {
					Comparable<T> temp = list[i];
					list[i] = list[min];
					list[min] = temp;
				}
			}
		} else {
			sort(list);
		}
	}
}
