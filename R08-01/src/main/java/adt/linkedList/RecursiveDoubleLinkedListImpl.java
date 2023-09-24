package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insert(T element) {
		if (!element.equals(null)) {
			if (isEmpty()) {
				setData(element);
				setNext(new RecursiveDoubleLinkedListImpl<T>());
				((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(this);
				if (getPrevious() == null) {
					setPrevious(new RecursiveDoubleLinkedListImpl<T>());
					getPrevious().setNext(this);
				}
			} else {
				getNext().insert(element);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (!element.equals(null)) {
			if (isEmpty()) {
				setData(element);
				setNext(new RecursiveDoubleLinkedListImpl<T>());
				((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(this);
				setPrevious(new RecursiveDoubleLinkedListImpl<T>());
				getPrevious().setNext(this);
			} else {
				RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<T>();
				newNode.setData(getData());
				newNode.setNext(getNext());
				newNode.setPrevious(this);
				((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(newNode);
				setData(element);
				setNext(newNode);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty() && !element.equals(null)) {
			if (getData().equals(element)) {
				if (getPrevious().isEmpty() && getNext().isEmpty()) {
					setData(null);
					setNext(null);
					setPrevious(null);
				} else {
					setData(getNext().getData());
					setNext(getNext().getNext());
					if (getNext() != null) {
						((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(this);
					}
				}
			} else {
				getNext().remove(element);
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			if (getPrevious().isEmpty() && getNext().isEmpty()) {
				setData(null);
				setNext(null);
				setPrevious(null);
			} else {
				setData(getNext().getData());
				setNext(getNext().getNext());
				if (!getNext().equals(null)) {
					((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(this);
				}
			}
		}
	}

	@Override
	public void removeLast() {
		if (!getNext().equals(null)) {
			if (!getNext().isEmpty()) {
				((RecursiveDoubleLinkedListImpl<T>) getNext()).removeLast();
			} else {
				setData(null);
				setNext(null);
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
