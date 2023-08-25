package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			int mid = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, mid);
			sort(array, mid + 1, rightIndex);
			merge(array, leftIndex, mid, rightIndex);
		}
	}

	private void merge(T[] array, int left, int middle, int right) {
		@SuppressWarnings("unchecked")
		T[] arrayAuxiliar = (T[]) new Comparable[array.length];
		for (int i = left; i <= right; i++) {
			arrayAuxiliar[i] = array[i];
		}
		int i = left;
		int j = middle + 1;
		int k = left;

		while (i <= middle && j <= right) {
			if (arrayAuxiliar[i].compareTo(arrayAuxiliar[j]) <= 0) {
				array[k] = arrayAuxiliar[i];
				i++;
			} else {
				array[k] = arrayAuxiliar[j];
				j++;
			}
			k++;
		}

		while (i <= middle) {
			array[k] = arrayAuxiliar[i];
			i++;
			k++;
		}

		while (j <= right) {
			array[k] = arrayAuxiliar[j];
			j++;
			k++;
		}

	}
}
