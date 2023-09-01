package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex != rightIndex && array.length != 0) {
			int indiceMenor = menorIndice(array, leftIndex, rightIndex, leftIndex + 1);
			Util.swap(array, leftIndex, indiceMenor);
			sort(array, leftIndex + 1, rightIndex);
		}
	}

	private int menorIndice(T[] array, int currentIndex, int rightIndex, int nextIndex) {
		int menorIndice = currentIndex;
		if (array[nextIndex].compareTo(array[currentIndex]) >= 0) {
			menorIndice =  menorIndice(array, nextIndex, rightIndex, nextIndex + 1);
		} else {
			menorIndice =  menorIndice(array, currentIndex, rightIndex, nextIndex + 1);
		}
		if (nextIndex > rightIndex) {
			menorIndice =  currentIndex;
		}
		return menorIndice;
	}
}
