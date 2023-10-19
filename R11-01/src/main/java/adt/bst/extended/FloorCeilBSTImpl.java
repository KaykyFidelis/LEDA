package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		BSTImpl<Integer> bst = new BSTImpl<Integer>();
		for (Integer element : array) {
			bst.insert(element);
		}
		return floor(bst.getRoot(), null, numero);
	}

	private Integer floor(BSTNode<Integer> node, Integer ultimoNumero, double numero) {
		Integer result = ultimoNumero;
		if (node != null && !node.isEmpty()) {
			if (node.getData() < numero) {
				ultimoNumero = node.getData();
				result = floor((BSTNode<Integer>) node.getRight(), ultimoNumero, numero);
			} else if (node.getData() > numero) {
				result = floor((BSTNode<Integer>) node.getLeft(), ultimoNumero, numero);
			} else {
				result = node.getData();
			}
		}
		return result;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		BSTImpl<Integer> bst = new BSTImpl<Integer>();
		for (Integer element : array) {
			bst.insert(element);
		}
		return ceil(bst.getRoot(), null, numero);
	}

	private Integer ceil(BSTNode<Integer> node, Integer ultimoNumero, double numero) {
		Integer result = ultimoNumero;
		if (node != null && !node.isEmpty()) {
			if (node.getData() < numero) {
				result = ceil((BSTNode<Integer>) node.getRight(), ultimoNumero, numero);
			} else if (node.getData() > numero) {
				ultimoNumero = node.getData();
				result = ceil((BSTNode<Integer>) node.getLeft(), ultimoNumero, numero);
			} else {
				result = node.getData();
			}
		}
		return result;
	}
}
