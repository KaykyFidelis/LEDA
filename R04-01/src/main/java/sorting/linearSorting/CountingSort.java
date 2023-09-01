package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de
 * contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de
 * entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a
 * ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros
 * negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex <= array.length - 1) {
			int maximo = maxElement(array, leftIndex, rightIndex) + 1;
			int[] frequencia = new int[maximo];
			int[] ordenado = new int[rightIndex - leftIndex + 1];

			// Pega a frequência de cada número
			for (int i = leftIndex; i <= rightIndex; i++) {
				frequencia[array[i]]++;
			}

			// Calcula a soma acumuladad de cada número
			for (int i = 1; i < frequencia.length; i++) {
				frequencia[i] += frequencia[i - 1];
			}

			// Pega a posição do elemento e o posiciona no array ordenado
			for (int i = rightIndex; i >= leftIndex; i--) {
				ordenado[frequencia[array[i]] - 1] = array[i];
				frequencia[array[i]]--;
			}

			// Copia o array auxiliar para o array
			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = ordenado[i - leftIndex];
			}
		}
	}

	int maxElement(Integer[] array, int leftIndex, int rightIndex) {
		int maximo = array[leftIndex];
		for (int x = leftIndex + 1; x <= rightIndex; x++) {
			if (maximo < array[x]) {
				maximo = array[x];
			}
		}
		return maximo;
	}
}
