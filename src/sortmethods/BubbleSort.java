package sortmethods;

import java.util.Comparator;

import problemdomain.Shape;
import problemdomain.SquarePrism;
import utilities.BaseAreaCompare;
import utilities.VolumeCompare;

public class BubbleSort {
	public static <T> void sort(Comparable<T>[] list) {
		for(int i = 0; i < list.length; i++) {
			for(int j=1; j< list.length; j++) {
				if (list[j].compareTo((T) list[j-1]) > 0)  {
					//swap
					Comparable<T> temp = list[j];
					list[j]= list[j-1];
					list[j-1] = temp;
				}
			}
		}

	}
	
	public static <T> void sort(Comparable<T>[] list, Comparator<? super T> type) {
		if(type != null) {
		for(int i = 0; i < list.length; i++) {
			for(int j=1; j< list.length; j++) {
				if (type.compare((T) list[j], (T) list[j-1]) > 0)  {
					//swap
					Comparable<T> temp = list[j];
					list[j]= list[j-1];
					list[j-1] = temp;
				}
			}
		}
		} else {
			sort(list);
		}
	}
}
