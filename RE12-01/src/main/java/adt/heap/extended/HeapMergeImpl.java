package adt.heap.extended;

import java.util.Comparator;
import java.util.List;

import adt.heap.HeapImpl;

public class HeapMergeImpl extends HeapImpl<Integer> implements HeapMerge {

	public HeapMergeImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer[] mergeArraysAndOrder(List<Integer[]> arrays) {
		for (Integer[] array : arrays) {
			for (Integer element : array) {
				insert((Integer) element);
			}
		}

		Integer[] retorno = new Integer[size()];
		if (rootElement().compareTo(lastElement()) > 0) {
			for (int i = index; i >= 0; i--) {
				retorno[i] = extractRootElement();
			}
		} else {
			for (int i = 0; i <= index; i++) {
				retorno[i] = extractRootElement();
			}
		}
		return retorno;
	}

	@Override
	public int sumRange(int k1, int k2) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
