package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	@SuppressWarnings("unchecked")
	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		//Aplica o mod, para que o tail seja resetado caso chegue no fim do array
		array[++tail % array.length] = element;
		elements++;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		elements--;
		T frente = head();
		array[++head % array.length] = null;
		return frente;
	}

	@Override
	public T head() {
		T retorno = null;
		if (head == -1 && elements > 0) {
			retorno = array[++head];
		} else if (head != -1) {
			retorno = array[head];
		}
		return retorno;
	}

	@Override
	public boolean isEmpty() {
		boolean retorno = false;
		if (elements == 0) {
			retorno = true;
		}
		return retorno;
	}

	@Override
	public boolean isFull() {
		boolean retorno = false;
		if (elements == array.length) {
			retorno = true;
		}
		return retorno;
	}
}
