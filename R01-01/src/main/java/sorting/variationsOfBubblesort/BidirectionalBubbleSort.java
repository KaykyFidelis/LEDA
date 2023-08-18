package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

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

			if (!changes)
				break;

			for (int x = rightIndex; x > leftIndex; x--) {
				if (array[x].compareTo(array[x - 1]) < 0) {
					util.Util.swap(array, x, x - 1);
					changes = true;
				}
			}
			leftIndex++;
		}
	}
}
