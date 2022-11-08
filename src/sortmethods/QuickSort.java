package sortmethods;

import java.util.Comparator;

public class QuickSort {
	public static <T> void sort(Comparable<T>[] list) {
		quickSort(list, 0, list.length - 1);
	}

	private static <T> void quickSort(Comparable<T>[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}

	/** Partition the array list[first..last] */
	private static <T> int partition(Comparable<T>[] list, int first, int last) {
		Comparable<T> pivot = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; // Index for backward search

		while (high > low) {
			// Search forward from left
			while (low <= high && list[low].compareTo((T) pivot) > 0)
				low++;

			// Search backward from right
			while (low <= high && list[high].compareTo((T) pivot) <= 0)
				high--;

			// Swap two elements in the list
			if (high > low) {
				Comparable<T> temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}

		while (high > first && list[high].compareTo((T) pivot) < 0)
			high--;

		// Swap pivot with list[high]
		if (pivot.compareTo((T) list[high]) <= 0) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		} else {
			return first;
		}
	}

	/************************************************************************************************/

	public static <T> void sort(Comparable<T>[] list, Comparator<? super T> type) {
		if (type != null)
			quickSort(list, 0, list.length - 1, type);
		else
			sort(list);
	}

	private static <T> void quickSort(Comparable<T>[] list, int first, int last, Comparator<? super T> type) {
		if (last > first) {
			int pivotIndex = partition(list, first, last, type);
			quickSort(list, first, pivotIndex - 1, type);
			quickSort(list, pivotIndex + 1, last, type);
		}
	}

	/** Partition the array list[first..last] */
	private static <T> int partition(Comparable<T>[] list, int first, int last, Comparator<? super T> type) {
		Comparable<T> pivot = list[first]; 
		int low = first + 1;
		int high = last; 

		while (high > low) {
			while (low <= high && type.compare((T) list[low], (T) pivot) > 0)
				low++;

			while (low <= high && type.compare((T) list[high], (T) pivot) <= 0)
				high--;

			if (high > low) {
				Comparable<T> temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}

		while (high > first && type.compare((T) list[high], (T) pivot) < 0)
			high--;

		if (type.compare((T) pivot, (T) list[high]) <= 0) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		} else {
			return first;
		}
	}
}
