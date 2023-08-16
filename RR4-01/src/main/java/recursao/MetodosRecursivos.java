package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array) {
		int posicao = array.length;
		int result = calcularSomaArrayRec(array, posicao - 1);
		return result;
	}

	private int calcularSomaArrayRec(int[] array, int i) {
		if (i == 0) {
			return array[i];
		}
		return array[i] + calcularSomaArrayRec(array, i - 1);
	}

	public long calcularFatorial(int n) {
		if (n == 1) {
			return 1;
		}
		return n * calcularFatorial(n - 1);
	}

	int um = 0;

	public int calcularFibonacci(int n) {
		if (n == 1 || n == 2) {
			if (this.um < 2) {
				System.out.println(1);
				this.um += 1;
			}
			return 1;
		}
		int saida = calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
		System.out.println(saida);
		return saida;
	}

	public int countNotNull(Object[] array) {
		return countNotNullRec(array, 0);
	}

	private int countNotNullRec(Object[] array, int indice) {
		int zeros = 0;
		if (indice == array.length - 1) {
			if (array[indice] == null) {
				zeros = 1;
			}
		} else { // caso recursivo
			if (array[indice] == null) {
				zeros = 1;
			}
			zeros = zeros + countNotNullRec(array, indice + 1);
		}
		return zeros;
	}

	public long potenciaDe2(int expoente) {
		if (expoente == 1) {
			return 2;
		}
		return 2 * potenciaDe2(expoente - 1);
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		if (n == 1) {
			return termoInicial;
		}
		return razao + progressaoAritmetica(termoInicial, razao, n - 1);
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		if (n == 1) {
			return termoInicial;
		}
		return razao * progressaoAritmetica(termoInicial, razao, n - 1);
	}

}
