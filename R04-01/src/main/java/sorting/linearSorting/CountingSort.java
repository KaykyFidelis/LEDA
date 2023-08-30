package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			int[] frequencia = new int[array.length];

			for (int i = leftIndex; i < rightIndex; i++) {
				frequencia[array[i] - 1] += 1;
			}
			
			for (int i = leftIndex + 1; i < rightIndex; i++) {
				frequencia[i] += frequencia[i-1];
			}

			int[] ordenados = new int[array.length];

			for (int i = rightIndex - 1; i >= leftIndex; i--) {
				ordenados[frequencia[array[i] - 1] - 1] = array[i];
				frequencia[array[i] - 1] -= 1;
			}

			for (int i = leftIndex; i < rightIndex; i++) {
				array[i] = frequencia[i];
			}
		}
	}
}
