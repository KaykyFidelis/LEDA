package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean changes = true;
		while (changes) {
			changes = false;
			for (int x = leftIndex; x < rightIndex; x++) {
				if (array[x].compareTo(array[x + 1]) > 0) {
					util.Util.swap(array, x, x + 1);
					changes = true;
				}
			}
			rightIndex--;
		}
	}
}
