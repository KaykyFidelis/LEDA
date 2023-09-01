package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a
	 * estrategia
	 * de usar o selection sem modificar o array original. Note que seu algoritmo
	 * vai
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de
	 * ordem
	 * desejada sem modificar o array original.
	 * 
	 * Restricoes:
	 * - Voce NÃO pode modificar o aray original
	 * - Voce NÃO pode usar memória extra: nenhum array auxiliar deve ser criado e
	 * utilizado.
	 * - Você NÃO pode usar métodos já prontos de manipulação de arrays
	 * - Voce NÃO pode encontrar a k-esima estatistica de ordem por contagem de
	 * elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar
	 * um elemento
	 * usando a ideia do selection sort).
	 * - Considere que k varia de 1 a N
	 * - Voce DEVE usar recursão para resolver o problema. Nenhum laço poderá ser
	 * utilizado.
	 * - Você pode implementar métodos auxiliares, desde que seja apenas nesta
	 * classe.
	 * - Os métodos auxiliares NÃO PODEM ter mais que três parâmetros.
	 * Dica: procure pensar como usar a ideia do selection sort para resolver esse
	 * problema,
	 * identifique que métodos você precisará para resolver o problema
	 * e pense no template da recursão em cada método que voce vai implementar.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {
		int minimo = 0;
		if (k > -1 && k < array.length) {
			for (int i = 0; i < k; i++) {
				minimo = i;
				if (calculaMinimo(array, i + 1, minimo) <= minimo && i != 0) {
					minimo = getNext(array, minimo);
				}
			}
			return array[minimo];
		} else {
			return null;
		}
	}

	private int getNext(T[] array, int minimo) {
		int maior = minimo;
		for (int x = 0; x < array.length; x++) {
			if (array[x].compareTo(array[minimo]) > 0) {
				if (array[maior].compareTo(array[x]) > 0 || maior == minimo) {
					maior = x;
				}
			}
		}
		return maior;
	}

	private int calculaMinimo(T[] array, int leftIndex, int minimo) {
		if (leftIndex < array.length) {
			if (array[leftIndex].compareTo(array[minimo]) < 0) {
				minimo = calculaMinimo(array, leftIndex++, leftIndex);
			} else {
				minimo = calculaMinimo(array, leftIndex++, minimo);
			}
		}
		return minimo;
	}
}
