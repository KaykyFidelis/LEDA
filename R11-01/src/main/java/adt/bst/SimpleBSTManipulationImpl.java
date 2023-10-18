package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada
 * 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	public static void main(String[] args) {

	}

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		BSTNode<T> nodeT1 = (BSTNode<T>) tree1.getRoot();
		BSTNode<T> nodeT2 = (BSTNode<T>) tree2.getRoot();
		return equals(nodeT1, nodeT2);
	}

	private boolean equals(BSTNode<T> nodeT1, BSTNode<T> nodeT2) {
		boolean retorno = false;
		if (nodeT1.equals(nodeT2)) {
			retorno = true;
		}
		if (!nodeT1.isEmpty() && !nodeT2.isEmpty()) {
			retorno = equals((BSTNode<T>) nodeT1.getLeft(), (BSTNode<T>) nodeT2.getLeft())
					&& equals((BSTNode<T>) nodeT1.getRight(), (BSTNode<T>) nodeT2.getRight());
		}
		return retorno;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		BSTNode<T> nodeT1 = (BSTNode<T>) tree1.getRoot();
		BSTNode<T> nodeT2 = (BSTNode<T>) tree2.getRoot();
		return isSimilar(nodeT1, nodeT2);
	}

	private boolean isSimilar(BSTNode<T> nodeT1, BSTNode<T> nodeT2) {
		boolean retorno = true;
		if ((!nodeT1.isEmpty() && nodeT2.isEmpty()) || (nodeT1.isEmpty() && !nodeT2.isEmpty())) {
			retorno = false;
		} else {
			if (!nodeT1.isEmpty() && !nodeT2.isEmpty()) {
				retorno = isSimilar((BSTNode<T>) nodeT1.getLeft(), (BSTNode<T>) nodeT2.getLeft())
						&& isSimilar((BSTNode<T>) nodeT1.getRight(), (BSTNode<T>) nodeT2.getRight());
			}
		}
		return retorno;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		T retorno = null;
		if (!(tree.size() < k) && !(k <= 0)) {
			retorno = orderStatistic(tree, (BSTNode<T>) tree.minimum(), k);
		}
		return retorno;
	}

	private T orderStatistic(BST<T> tree, BSTNode<T> currentNode, int estatistica) {
		T retorno = null;
		if (estatistica == 1) {
			retorno = currentNode.getData();
		} else {
			retorno = orderStatistic(tree, tree.sucessor(currentNode.getData()), --estatistica);
		}
		return retorno;
	}

}
