package sortmethods;

import java.util.Comparator;

public class HeapSort {
	public static <T> void sort(Comparable<T>[] list) {

		for (int i = list.length / 2 - 1; i >= 0; i--)
			heapify(list, list.length, i);

		for (int i = list.length - 1; i > 0; i--) {
			Comparable<T> temp = list[0];
			list[0] = list[i];
			list[i] = temp;
			heapify(list, i, 0);
		}
	}

	public static <T> void heapify(Comparable<T>[] list, int size, int index) {
		int largest = index;
		int left = 2 * index + 1;
		int right = 2 * index + 2;

		if (left < size && list[left].compareTo((T) list[largest]) < 0)
			largest = left;

		if (right < size && list[right].compareTo((T) list[largest]) < 0)
			largest = right;

		if (largest != index) {
			Comparable<T> temp = list[index];
			list[index] = list[largest];
			list[largest] = temp;

			heapify(list, size, largest);
		}
	}

	/************************************************************************************************/
	public static <T> void sort(Comparable<T>[] list, Comparator<? super T> type) {
		if (type != null) {
			for (int i = list.length / 2 - 1; i >= 0; i--)
				heapify(list, list.length, i, type);

			for (int i = list.length - 1; i > 0; i--) {
				Comparable<T> temp = list[0];
				list[0] = list[i];
				list[i] = temp;
				heapify(list, i, 0, type);
			}
		} else {
			sort(list);
		}
	}

	public static <T> void heapify(Comparable<T>[] list, int size, int index, Comparator<? super T> type) {
		int largest = index;
		int left = 2 * index + 1;
		int right = 2 * index + 2;

		if (left < size && type.compare((T) list[left], (T) list[largest]) < 0)
			largest = left;

		if (right < size && type.compare((T) list[right], (T) list[largest]) < 0)
			largest = right;

		if (largest != index) {
			Comparable<T> temp = list[index];
			list[index] = list[largest];
			list[largest] = temp;

			heapify(list, size, largest, type);
		}
	}
}
