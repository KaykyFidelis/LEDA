package adt.avltree;

import adt.bst.BSTNode;
import adt.bst.BSTVerifierImpl;

/**
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeVerifierImpl<T extends Comparable<T>> extends BSTVerifierImpl<T> implements AVLTreeVerifier<T> {

	private AVLTreeImpl<T> avlTree;

	public AVLTreeVerifierImpl(AVLTree<T> avlTree) {
		super(avlTree);
		this.avlTree = (AVLTreeImpl<T>) avlTree;
	}

	@SuppressWarnings("unused")
	private AVLTreeImpl<T> getAVLTree() {
		return avlTree;
	}

	@Override
	public boolean isAVLTree() {
		return this.isBST() && this.isAVL(avlTree.getRoot());
	}

	private boolean isAVL(BSTNode<T> node) {
		boolean retorno = true;
		if (!node.isEmpty()) {
			if ((avlTree.calculateBalance(node) <= 1) && (avlTree.calculateBalance(node) >= -1)) {
				retorno = isAVL((BSTNode<T>) node.getLeft()) && isAVL((BSTNode<T>) node.getRight());
			} else {
				retorno = false;
			}
		}
		return retorno;
	}

}
