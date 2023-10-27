package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 * - insert
 * - preOrder
 * - postOrder
 * - remove
 * - height
 * - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	@Override
	public void insert(T element) {
		if (element != null) {
			insert(getRoot(), element);
		}
	}

	private void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.setRight(new BSTNode<T>());
			node.getRight().setParent(node);
		} else {
			if (node.getData().compareTo(element) > 0) {
				insert((BSTNode<T>) node.getLeft(), element);
			} else if (node.getData().compareTo(element) < 0) {
				insert((BSTNode<T>) node.getRight(), element);
			}
			rebalance(node);
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			BSTNode<T> node = search(element);
			if (!node.isEmpty()) {
				if (node.isLeaf()) {
					node.setData(null);
					rebalanceUp(node);
				} else if ((!node.getLeft().isEmpty() && node.getRight().isEmpty())
						|| (node.getLeft().isEmpty() && !node.getRight().isEmpty())) {
					if (node.getParent() != null) {
						if (!node.getParent().getLeft().equals(node)) {
							if (!node.getLeft().isEmpty()) {
								node.getParent().setRight(node.getLeft());
								node.getLeft().setParent(node.getParent());
							} else {
								node.getParent().setRight(node.getRight());
								node.getRight().setParent(node.getParent());
							}

						} else {
							if (!node.getLeft().isEmpty()) {
								node.getParent().setLeft(node.getLeft());
								node.getLeft().setParent(node.getParent());
							} else {
								node.getParent().setLeft(node.getRight());
								node.getRight().setParent(node.getParent());
							}
						}
					} else {
						if (node.getLeft().isEmpty()) {
							root = (BSTNode<T>) node.getRight();
						} else {
							root = (BSTNode<T>) node.getLeft();
						}
						getRoot().setParent(null);
					}
					rebalanceUp(node);
				} else {
					T sucessorNode = sucessor(node.getData()).getData();
					remove(sucessorNode);
					node.setData(sucessorNode);
				}
			}
		}
	}

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int result = 0;

		if (!node.isEmpty())
			result = height((BSTNode<T>) node.getLeft()) - height((BSTNode<T>) node.getRight());

		return result;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		BSTNode<T> novo = null;
		int balance = calculateBalance(node);
		if (balance != 0) {
			if (balance > 1) {
				if (calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
					novo = Util.rightRotation(node);
				} else {
					Util.leftRotation((BSTNode<T>) node.getLeft());
					novo = Util.rightRotation(node);
				}
			} else if (balance < -1) {
				if (calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
					novo = Util.leftRotation(node);
				} else {
					Util.rightRotation((BSTNode<T>) node.getRight());
					novo = Util.leftRotation(node);
				}
			}
		}
		if (getRoot().equals(node) && novo != null) {
			root = novo;
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if (node.getParent() != null) {
			BSTNode<T> parent = (BSTNode<T>) node.getParent();
			rebalance(parent);
			rebalanceUp(parent);
		}
	}
}
