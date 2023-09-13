package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		quickSort(array, 0, array.length - 1);

		Integer busca = binarySearch(array, x, 0, array.length - 1);

		if (busca == -1) {
			busca = null;
		}

		return busca;
	}

	private Integer binarySearch(Integer[] array, Integer value, int leftIndex, int rightIndex) {
		int result = -1;
		if (leftIndex <= rightIndex) {
			int middle = (leftIndex + rightIndex) / 2;

			if (array[middle] == value) {
				result = middle;
			} else if (array[middle] < value) {
				result = binarySearch(array, value, middle + 1, rightIndex);
				if (result == -1) {
					result = middle;
				}
			} else {
				result = binarySearch(array, value, leftIndex, middle - 1);
			}
		}

		return result;
	}

	private void quickSort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			int pivot = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, pivot - 1);
			quickSort(array, pivot + 1, rightIndex);
		}
	}

	private int partition(Integer[] array, int leftIndex, int rightIndex) {
		Integer pivot = array[leftIndex];
		Integer i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				i += 1;
				util.Util.swap(array, i, j);
			}
		}

		util.Util.swap(array, leftIndex, i);
		return i;
	}
}
