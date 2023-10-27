package adt.bt;

import adt.bst.BSTNode;

public class Util {

	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * 
	 * @param node
	 * @return - noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		BSTNode<T> pivot = (BSTNode<T>) node.getRight();

		// Atualiza o filho direito do nó original para ser o filho esquerdo do pivot.
		node.setRight(pivot.getLeft());

		// Define o node como o filho esquerdo do pivot, concluindo a rotação direita.
		pivot.setLeft(node);

		// Atualiza o pai do pivot para ser o mesmo pai de antes da rotação.
		pivot.setParent(node.getParent());

		// Define o pivot como o novo pai do node.
		node.setParent(pivot);

		// Se acontecer do pai do novo node não ser null, precisa avisar pra ele
		if (pivot.getParent() != null) {
			if (pivot.getParent().getRight().equals(node)) {
				pivot.getParent().setRight(pivot);
			} else {
				pivot.getParent().setLeft(pivot);
			}
		}

		return pivot;
	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * 
	 * @param node
	 * @return noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		BSTNode<T> pivot = (BSTNode<T>) node.getLeft();

		// Atualiza o filho esquerdo do nó original para ser o filho direito do pivot.
		node.setLeft(pivot.getRight());

		// Define o node como o filho direito do pivot, concluindo a rotação esquerda.
		pivot.setRight(node);

		// Atualiza o pai do pivot para ser o mesmo pai de antes da rotação.
		pivot.setParent(node.getParent());

		// Define o pivot como o novo pai do node.
		node.setParent(pivot);

		// Se acontecer do pai do novo node não ser null, precisa avisar pra ele
		if (pivot.getParent() != null) {
			if (pivot.getParent().getLeft().equals(node)) {
				pivot.getParent().setLeft(pivot);
			} else {
				pivot.getParent().setRight(pivot);
			}
		}
		return pivot;
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}
