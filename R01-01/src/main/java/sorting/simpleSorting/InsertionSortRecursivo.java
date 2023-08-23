package sorting.simpleSorting;

import sorting.AbstractSorting;

public class InsertionSortRecursivo<T extends Comparable<T>> extends AbstractSorting<T> {
    int firstLeftIndex = -1;

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (firstLeftIndex == -1) {
            firstLeftIndex = leftIndex;
        }
        if (leftIndex != rightIndex && leftIndex < rightIndex && leftIndex > -1 && rightIndex < array.length) {
            trocasRecursivas(array, rightIndex, leftIndex + 1);
            sort(array, leftIndex + 1, rightIndex);
        }
    }

    private void trocasRecursivas(T[] array, int rightIndex, int currentIndex) {
        if (currentIndex > firstLeftIndex) {
            if (array[currentIndex].compareTo(array[currentIndex - 1]) < 0) {
                util.Util.swap(array, currentIndex, currentIndex - 1);
            }
            trocasRecursivas(array, rightIndex, currentIndex - 1);
        }
    }
}
