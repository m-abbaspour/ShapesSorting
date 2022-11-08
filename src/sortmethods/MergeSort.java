package sortmethods;

import java.util.Comparator;

import problemdomain.Shape;
import problemdomain.SquarePrism;
import utilities.BaseAreaCompare;


public class MergeSort {
	/** The method for sorting the numbers */
	public static <T> void sort(Comparable<T>[] list) {
		if (list.length > 1) {
			Comparable<T>[] firstHalf = new Comparable[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			sort(firstHalf);

			// Merge sort the second half
			int secondHalfLength = list.length - list.length / 2;
			Comparable<T>[] secondHalf = new Comparable[secondHalfLength];
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
			sort(secondHalf);

			// Merge firstHalf with secondHalf into list
			merge(firstHalf, secondHalf, list);
		}
	}

	public static <T> void merge(Comparable<T>[] list1, Comparable<T>[] list2, Comparable<T>[] temp) {
		int current1 = 0;
		int current2 = 0;
		int current3 = 0;

		while (current1 < list1.length && current2 < list2.length) {
			if (list1[current1].compareTo((T) list2[current2]) > 0)
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}

		while (current1 < list1.length)
			temp[current3++] = list1[current1++];

		while (current2 < list2.length)
			temp[current3++] = list2[current2++];
	}

	/**********************************************************************/

	public static <T> void sort(Comparable<T>[] list, Comparator<? super T> type) {
		if (type != null) {
			if (list.length > 1) {
				Comparable<T>[] firstHalf = new Comparable[list.length / 2];
				System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
				sort(firstHalf);

				// Merge sort the second half
				int secondHalfLength = list.length - list.length / 2;
				Comparable<T>[] secondHalf = new Comparable[secondHalfLength];
				System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
				sort(secondHalf, type);

				// Merge firstHalf with secondHalf into list
				merge(firstHalf, secondHalf, list, type);
			}
		} else {
			sort(list);
		}
	}

	public static <T> void merge(Comparable<T>[] list1, Comparable<T>[] list2, Comparable<T>[] temp,
			Comparator<? super T> type) {
		int current1 = 0;
		int current2 = 0;
		int current3 = 0;

		while (current1 < list1.length && current2 < list2.length) {
			if (type.compare((T) list1[current1], (T) list2[current2]) > 0)
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}

		while (current1 < list1.length)
			temp[current3++] = list1[current1++];

		while (current2 < list2.length)
			temp[current3++] = list2[current2++];
	}
}
