package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do
 * intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até
 * A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do
 * pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			int pivot = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivot - 1);
			sort(array, pivot + 1, rightIndex);
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		medianOfThree(array, leftIndex, rightIndex);
		int pivot_partition = rightIndex;
		int i = leftIndex + 1;
		int j = rightIndex - 1;

		while (i <= j) {
			if (array[j].compareTo(array[pivot_partition]) > 0) {
				j--;
			} else {
				if (array[pivot_partition].compareTo(array[i]) < 0) {
					util.Util.swap(array, i, j);
					j--;
				} else {
					i++;
				}
			}
		}

		util.Util.swap(array, i, pivot_partition);
		return i;
	}

	private void medianOfThree(T[] array, int leftIndex, int rightIndex) {
		int mid = (leftIndex + rightIndex) / 2;
		if (array[leftIndex].compareTo(array[mid]) > 0) {
			util.Util.swap(array, leftIndex, mid);
		}
		if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
			util.Util.swap(array, leftIndex, rightIndex);
		}
		if (array[mid].compareTo(array[rightIndex]) > 0) {
			util.Util.swap(array, mid, rightIndex);
		}
		util.Util.swap(array, mid, rightIndex - 1);
	}
}
