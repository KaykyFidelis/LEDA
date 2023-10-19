package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(getRoot());
	}

	public int height(BSTNode<T> node) {
		int height = -1;
		if (!node.isEmpty()) {
			height = Math.max(1 + height((BSTNode<T>) node.getLeft()), 1 + height((BSTNode<T>) node.getRight()));
		}
		return height;
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> retorno = new BSTNode<T>();
		if (element != null) {
			retorno = search(getRoot(), element);
		}
		return retorno;
	}

	private BSTNode<T> search(BSTNode<T> node, T element) {
		BSTNode<T> retorno = new BSTNode<T>();
		if (!node.isEmpty()) {
			if (node.getData().compareTo(element) == 0) {
				retorno = node;
			} else if (node.getData().compareTo(element) > 0) {
				retorno = search((BSTNode<T>) node.getLeft(), element);
			} else {
				retorno = search((BSTNode<T>) node.getRight(), element);
			}
		}
		return retorno;
	}

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
		} else if (node.getData().compareTo(element) > 0) {
			insert((BSTNode<T>) node.getLeft(), element);
		} else {
			insert((BSTNode<T>) node.getRight(), element);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> retorno = null;
		if (!getRoot().isEmpty()) {
			retorno = maximum(getRoot());
		}
		return retorno;
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		BSTNode<T> maximo = node;
		if (!node.getRight().isEmpty()) {
			maximo = maximum((BSTNode<T>) node.getRight());
		}
		return maximo;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> retorno = null;
		if (!getRoot().isEmpty()) {
			retorno = minimum(getRoot());
		}
		return retorno;
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		BSTNode<T> minimo = node;
		if (!node.getLeft().isEmpty()) {
			minimo = minimum((BSTNode<T>) node.getLeft());
		}
		return minimo;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> retorno = null;
		if (!search(element).isEmpty()) {
			retorno = search(element);
			if (!retorno.getRight().isEmpty()) {
				retorno = minimum((BSTNode<T>) retorno.getRight());
			} else {
				retorno = sucessor(retorno, element);
			}
		}
		return retorno;
	}

	private BSTNode<T> sucessor(BSTNode<T> node, T element) {
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		if (parent != null && parent.getData().compareTo(node.getData()) < 0) {
			parent = sucessor(parent, element);
		}
		return parent;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> retorno = null;
		if (!search(element).isEmpty()) {
			retorno = search(element);
			if (!retorno.getLeft().isEmpty()) {
				retorno = maximum((BSTNode<T>) retorno.getLeft());
			} else {
				retorno = predecessor(retorno, element);
			}
		}
		return retorno;
	}

	private BSTNode<T> predecessor(BSTNode<T> node, T element) {
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		if (parent != null && parent.getData().compareTo(node.getData()) > 0) {
			parent = predecessor(parent, element);
		}
		return parent;
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			BSTNode<T> node = search(element);
			if (!node.isEmpty()) {
				if (node.isLeaf()) {
					node.setData(null);
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
				} else {
					T sucessorNode = sucessor(node.getData()).getData();
					remove(sucessorNode);
					node.setData(sucessorNode);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] preOrder() {
		T[] lista = (T[]) new Comparable[size()];
		ArrayList<T> lista2 = new ArrayList<>();
		if (!getRoot().isEmpty()) {
			preOrder(lista2, getRoot()).toArray(lista);
		}
		return lista;
	}

	private ArrayList<T> preOrder(ArrayList<T> lista, BSTNode<T> currentNode) {
		if (!currentNode.isEmpty()) {
			lista.add(currentNode.getData());
			preOrder(lista, (BSTNode<T>) currentNode.getLeft());
			preOrder(lista, (BSTNode<T>) currentNode.getRight());
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] order() {
		T[] lista = (T[]) new Comparable[size()];
		ArrayList<T> lista2 = new ArrayList<>();
		if (!getRoot().isEmpty())
			order(lista2, getRoot()).toArray(lista);
		return lista;
	}

	private ArrayList<T> order(ArrayList<T> lista, BSTNode<T> currentNode) {
		if (!currentNode.isEmpty()) {
			order(lista, (BSTNode<T>) currentNode.getLeft());
			lista.add(currentNode.getData());
			order(lista, (BSTNode<T>) currentNode.getRight());
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] postOrder() {
		T[] lista = (T[]) new Comparable[size()];
		ArrayList<T> lista2 = new ArrayList<>();
		if (!getRoot().isEmpty())
			postOrder(lista2, getRoot()).toArray(lista);
		return lista;
	}

	private ArrayList<T> postOrder(ArrayList<T> lista, BSTNode<T> currentNode) {
		if (!currentNode.isEmpty()) {
			postOrder(lista, (BSTNode<T>) currentNode.getLeft());
			postOrder(lista, (BSTNode<T>) currentNode.getRight());
			lista.add(currentNode.getData());
		}
		return lista;
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(getRoot());
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
