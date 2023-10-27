package adt.bst;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {

	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}

	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		return isBST(getBSt().getRoot());
	}

	public boolean isBST(BSTNode<T> node) {
		boolean retorno = true;
		if (!node.isEmpty()) {
			if (this.verificaLeft((BSTNode<T>) node.getLeft(), node)
					&& this.verificaRight((BSTNode<T>) node.getRight(), node)) {
				retorno = isBST((BSTNode<T>) node.getLeft()) && isBST((BSTNode<T>) node.getRight());
			} else {
				retorno = false;
			}
		}
		return retorno;
	}

	private boolean verificaLeft(BSTNode<T> node, BSTNode<T> pai) {
		boolean retorno = true;
		if (!node.isEmpty()) {
			if (node.getData().compareTo(pai.getData()) < 0) {
				retorno = verificaLeft((BSTNode<T>) node.getLeft(), pai)
						&& verificaLeft((BSTNode<T>) node.getRight(), pai);
			} else {
				retorno = false;
			}
		}
		return retorno;
	}

	private boolean verificaRight(BSTNode<T> node, BSTNode<T> pai) {
		boolean retorno = true;
		if (!node.isEmpty()) {
			if (node.getData().compareTo(pai.getData()) > 0) {
				retorno = verificaRight((BSTNode<T>) node.getLeft(), pai)
						&& verificaRight((BSTNode<T>) node.getRight(), pai);
			} else {
				retorno = false;
			}
		}
		return retorno;
	}

}
