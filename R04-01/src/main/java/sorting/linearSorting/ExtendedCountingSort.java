package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex <= array.length - 1) {
			int[] minimoMaximo = minMaxElement(array, leftIndex, rightIndex);
			int minimo = minimoMaximo[0];
			int maximo = minimoMaximo[1];
			int[] frequencia = new int[maximo - minimo + 1];
			int[] ordenado = new int[rightIndex - leftIndex + 1];

			// Pega a frequência de cada número
			for (int i = leftIndex; i <= rightIndex; i++) {
				frequencia[array[i] - minimo]++;
			}

			// Calcula a soma acumuladad de cada número
			for (int i = 1; i < frequencia.length; i++) {
				frequencia[i] += frequencia[i - 1];
			}

			// Pega a posição do elemento e o posiciona no array ordenado
			for (int i = rightIndex; i >= leftIndex; i--) {
				ordenado[frequencia[array[i] - minimo] - 1] = array[i];
				frequencia[array[i] - minimo]--;
			}

			// Copia o array auxiliar para o array
			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = ordenado[i - leftIndex];
			}
		}
	}

	int[] minMaxElement(Integer[] array, int leftIndex, int rightIndex) {
		int maximo = array[leftIndex];
		int minimo = array[leftIndex];
		for (int x = leftIndex + 1; x <= rightIndex; x++) {
			if (maximo < array[x]) {
				maximo = array[x];
			}
			if (minimo > array[x]) {
				minimo = array[x];
			}
		}
		return new int[] { minimo, maximo };
	}
}