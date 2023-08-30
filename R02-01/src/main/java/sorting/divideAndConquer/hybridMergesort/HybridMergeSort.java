package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de
 * forma
 * que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados.
 * E a cada chamada
 * interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 * INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			if (array.length <= 4) {
				INSERTIONSORT_APPLICATIONS++;
				insertionSort(array, leftIndex, rightIndex);
			} else {
				MERGESORT_APPLICATIONS++;
				mergeSort(array, leftIndex, rightIndex);
			}
		}
	}

	public void mergeSort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			if (array.length <= 4) {
				INSERTIONSORT_APPLICATIONS++;
				insertionSort(array, leftIndex, rightIndex);
			} else {
				MERGESORT_APPLICATIONS++;
				int mid = (leftIndex + rightIndex) / 2;
				mergeSort(array, leftIndex, mid);
				mergeSort(array, mid + 1, rightIndex);
				merge(array, leftIndex, mid, rightIndex);
			}
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

	public void insertionSort(T[] array, int leftIndex, int rightIndex) {
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
