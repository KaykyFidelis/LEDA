package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return getHead().isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = getHead();
		while (!aux.isNIL()) {
			size++;
			aux = aux.getNext();
		}
		return size;
	}

	@Override
	public void insert(T element) {
		if (!element.equals(null)) {
			if (getHead().isNIL()) {
				SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>();
				newHead.setData(element);
				newHead.setNext(head);
				setHead(newHead);
			} else {
				SingleLinkedListNode<T> aux = getHead();
				while (!aux.getNext().isNIL()) {
					aux = aux.getNext();
				}
				SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>();
				newNode.setData(element);
				newNode.setNext(aux.getNext());
				aux.setNext(newNode);
			}
		}
	}

	@Override
	public T search(T element) {
		T retorno = null;
		if (!getHead().isNIL() && !element.equals(null)) {
			SingleLinkedListNode<T> aux = getHead();
			while (!aux.isNIL() && !aux.getData().equals(element)) {
				aux = aux.getNext();
			}
			if (!aux.isNIL()) {
				retorno = aux.getData();
			}
		}
		return retorno;
	}

	@Override
	public void remove(T element) {
		if (!getHead().isNIL() && !element.equals(null)) {
			if (getHead().getData().equals(element)) {
				setHead(getHead().getNext());
			} else {
				SingleLinkedListNode<T> aux = getHead();
				while (!aux.isNIL() && !aux.getData().equals(element)) {
					aux = aux.getNext();
				}
				if (!aux.isNIL()) {
					aux.setData(aux.getNext().getData());
					aux.setNext(aux.getNext().getNext());
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] result = (T[]) new Comparable[size()];
		SingleLinkedListNode<T> atual = getHead();
		for (int i = 0; i < size(); i++) {
			result[i] = atual.getData();
			atual = atual.getNext();
		}
		return result;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
