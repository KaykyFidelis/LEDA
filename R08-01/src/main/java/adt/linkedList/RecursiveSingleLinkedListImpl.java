package adt.linkedList;

import java.util.ArrayList;
import java.util.List;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		// Pq não funcionou o getData().equals(null)?
		return getData() == null;
	}

	@Override
	public void insert(T element) {
		if (!element.equals(null)) {
			if (isEmpty()) {
				setData(element);
				setNext(new RecursiveSingleLinkedListImpl<T>());
			} else {
				getNext().insert(element);
			}
		}
	}

	@Override
	public int size() {
		int retorno = 0;
		if (!isEmpty()) {
			retorno = 1 + getNext().size();
		}
		return retorno;
	}

	@Override
	public T search(T element) {
		T retorno = null;
		if (!isEmpty() && !element.equals(null)) {
			if (getData().equals(element)) {
				retorno = getData();
			} else {
				retorno = getNext().search(element);
			}
		}
		return retorno;
	}

	@Override
	public void remove(T element) {
		if (!isEmpty() && !element.equals(null)) {
			if (getData().equals(element)) {
				setData(getNext().getData());
				setNext(getNext().getNext());
			} else {
				getNext().remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		List<T> array = new ArrayList<>();
		return this.toArray(array);
	}

	@SuppressWarnings("unchecked")
	private T[] toArray(List<T> array) {
		if (!this.isEmpty()) {
			array.add(this.data);
			this.next.toArray(array);
		}
		return (T[]) array.toArray();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
