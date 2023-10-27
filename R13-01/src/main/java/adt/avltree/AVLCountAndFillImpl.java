package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {
		this.LLcounter = 0;
		this.LRcounter = 0;
		this.RRcounter = 0;
		this.RLcounter = 0;
	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		BSTImpl<T> bst1 = new BSTImpl<>();
		T[] arrayBST = order();

		//Esse 'for' serve para verificar o caso em que tenha sido adicionado algum elemento na AVL antes de chamar o fillWithoutRebalance.
		//Caso esse teste não seja feito, o for não vai entrar, sendo assim, não consumirá tempo de execução :)
		for (int i = 0; i < arrayBST.length; i++) {
			bst1.insert(arrayBST[i]);
		}

		for (int i = 0; i < array.length; i++) {
			bst1.insert(array[i]);
		}

		array = bst1.order();
		int nivel = 0;
		while (buscaBinaria(array, 0, array.length, nivel)) {
			nivel++;
		}
	}

	private boolean buscaBinaria(T[] array, int left, int right, int nivel) {
		boolean retorno = false;
		if (right > left) {
			int middle = (left + right) / 2;
			if (nivel == 0) {
				insert(array[middle]);
				retorno = true;
			} else {
				retorno = buscaBinaria(array, left, middle, nivel - 1)
						&& buscaBinaria(array, middle + 1, right, nivel - 1);
			}
		}
		return retorno;
	}

	@Override
	public void rebalance(BSTNode<T> node) {
		BSTNode<T> novo = null;
		int balance = calculateBalance(node);
		if (balance != 0) {
			if (balance > 1) {
				if (calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
					novo = Util.rightRotation(node);
					LLcounter++;
				} else {
					Util.leftRotation((BSTNode<T>) node.getLeft());
					novo = Util.rightRotation(node);
					LRcounter++;
				}
			} else if (balance < -1) {
				if (calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
					novo = Util.leftRotation(node);
					RRcounter++;
				} else {
					Util.rightRotation((BSTNode<T>) node.getRight());
					novo = Util.leftRotation(node);
					RLcounter++;
				}
			}
		}
		if (getRoot().equals(node) && novo != null) {
			root = novo;
		}
	}
}
