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
		for (int i = 1; i < rightIndex + 1; i++) {
			T elemento = array[i];
			for (int j = i; j > leftIndex - 1; j--) {
				if(array[j].compareTo(elemento) > 0){
					util.Util.swap(array, j, j + 1);
				}
				break;
			}
			//Eu num sei o que tá acontecendo, mas certo não tá KKKKKKKKK
		}
	}
}
