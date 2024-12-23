package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

public class RecursiveBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (rightIndex != 1 && array.length != 0) {
			trocasRecursivas(array, leftIndex, rightIndex, leftIndex);
			sort(array, leftIndex, rightIndex - 1);
		}
	}

	private void trocasRecursivas(T[] array, int leftIndex, int rightIndex, int currentIndex) {
		if (currentIndex < rightIndex) {
			if (array[currentIndex].compareTo(array[currentIndex + 1]) > 0) {
				util.Util.swap(array, currentIndex, currentIndex + 1);
			}
			trocasRecursivas(array, leftIndex, rightIndex, currentIndex + 1);
		}
	}
}
