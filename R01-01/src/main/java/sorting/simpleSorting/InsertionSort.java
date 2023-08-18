package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex + 1; i < rightIndex + 1; i++) {
			int elemento = i;
			while (elemento > 0 && (array[elemento].compareTo(array[elemento - 1]) < 0)) {
				T aux = array[elemento];
				array[elemento] = array[elemento - 1];
				array[elemento - 1] = aux;
				elemento -= 1;
			}
		}
	}
}
