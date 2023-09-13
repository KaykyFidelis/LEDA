package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		T retorno = null;
		if (tail != -1){
			retorno = array[0];
		}
		return retorno;
	}

	@Override
	public boolean isEmpty() {
		boolean retorno = false;
		if (tail == -1){
			retorno = true;
		}
		return retorno;
	}

	@Override
	public boolean isFull() {
		boolean retorno = false;
		if (tail == array.length - 1){
			retorno = true;
		}
		return retorno;
	}

	private void shiftLeft() {
		array[tail] = null;
		for (int i = 0; i < tail - 1; i++){
			array[i] = array[i + 1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		array[++tail] = element;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()){
			throw new QueueUnderflowException();
		}
		T frente = head();
		shiftLeft();
		tail--;
		return frente;
	}

}
