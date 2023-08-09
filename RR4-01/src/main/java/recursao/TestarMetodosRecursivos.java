package recursao;

public class TestarMetodosRecursivos {
	public static void main(String[] args) {
		MetodosRecursivos recursividade = new MetodosRecursivos();
		int[] array = { 1, 0, 1, 0, 1 };
		Object[] arrayNull = { 1, null, 1, 0, null };
		System.out.println("Soma de array: " + recursividade.calcularSomaArray(array));
		System.out.println("Fatorial: " + recursividade.calcularFatorial(4));
		System.out.println("Fibonacci: " + recursividade.calcularFibonacci(4));
		System.out.println("Elementos Nulos: " + recursividade.countNotNull(arrayNull));
		System.out.println("Potência de 2: " + recursividade.potenciaDe2(5));
		System.out.println("Progressão Aritmética: " + recursividade.progressaoAritmetica(1, 2, 5));
		System.out.println("Progressão Geométrica: " + recursividade.progressaoGeometrica(1, 2, 5));
	}
}
