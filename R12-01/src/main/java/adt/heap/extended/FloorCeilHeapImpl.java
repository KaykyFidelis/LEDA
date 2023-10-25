package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		for (Integer value : array) {
			insert(value);
		}
		return floor(numero, null);
	}

	private Integer floor(double numero, Integer ultimoNumero) {
		Integer root = extractRootElement();
		if (root != null) {
			if (numero >= root && (ultimoNumero == null || root >= ultimoNumero)) {
				ultimoNumero = floor(numero, root);
			} else {
				ultimoNumero = floor(numero, ultimoNumero);
			}
		}
		return ultimoNumero;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		for (Integer value : array) {
			insert(value);
		}
		return ceil(numero, null);
	}

	private Integer ceil(double numero, Integer ultimoNumero) {
		Integer root = extractRootElement();
		if (root != null) {
			if (numero <= root && (ultimoNumero == null || root <= ultimoNumero)) {
				ultimoNumero = ceil(numero, root);
			} else {
				ultimoNumero = ceil(numero, ultimoNumero);
			}
		}
		return ultimoNumero;
	}
}
