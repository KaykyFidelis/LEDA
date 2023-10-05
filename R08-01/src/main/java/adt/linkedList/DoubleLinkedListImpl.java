package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<T>();
		this.last = new DoubleLinkedListNode<T>();
	}

	@Override
	public void insert(T element) {
		if (!element.equals(null)) {
			if (getLast().isNIL()) {
				DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(element, getLast(),
						((DoubleLinkedListNode<T>) getHead()));
				setLast(newNode);
				setHead(newNode);
			} else {
				DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<T>(),
						getLast());
				getLast().setNext(newNode);
				setLast(newNode);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (!element.equals(null)) {
			if (getHead().isNIL()) {
				DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, getLast(),
						((DoubleLinkedListNode<T>) getHead()));
				setLast(newNode);
				setHead(newNode);
			} else {
				DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) getHead();
				DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(element, auxHead,
						new DoubleLinkedListNode<T>());
				((DoubleLinkedListNode<T>) getHead()).setPrevious(newNode);
				setHead(newNode);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (!getHead().isNIL() && !element.equals(null)) {
			if (getHead().getData().equals(element)) {
				removeFirst();
			} else {
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) getHead();
				while (!aux.isNIL() && !aux.getData().equals(element)) {
					aux = (DoubleLinkedListNode<T>) aux.getNext();
				}
				if (!aux.isNIL()) {
					aux.getPrevious().setNext(aux.getNext());
					((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux.getPrevious());
				}
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!getHead().isNIL()) {
			setHead(getHead().getNext());
			if (getHead().isNIL()) {
				setLast((DoubleLinkedListNode<T>) getHead());
			} else {
				((DoubleLinkedListNode<T>) getHead()).setPrevious(new DoubleLinkedListNode<T>());
			}
		}
	}

	@Override
	public void removeLast() {
		if (!getLast().isNIL()) {
			setLast(getLast().getPrevious());
			if (getLast().isNIL()) {
				setHead(getLast());
			} else {
				getLast().setNext(new DoubleLinkedListNode<T>());
			}
		}
	}

	@Override
	public T search(T element) {
		T retorno = null;
		DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) getHead();
		DoubleLinkedListNode<T> auxLast = getLast();
		while (!auxHead.getData().equals(auxLast.getData())
				&& !auxHead.getNext().getData().equals(auxLast.getData())
				&& !auxHead.getData().equals(element)
				&& !auxLast.getData().equals(element)) {
			auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
			auxLast = auxLast.getPrevious();
		}
		if(auxHead.getData().equals(element)) {
			retorno = auxHead.getData();
		} else if(auxLast.getData().equals(element)) {
			retorno = auxLast.getData();
		}
		return retorno;
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
