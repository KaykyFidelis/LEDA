package adt.stack;

public class StackImpl<T> implements Stack<T> {
	//null
	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		T retorno = null;
		if(top != -1){
			retorno = array[top];
		}
		return retorno;
	}

	@Override
	public boolean isEmpty() {
		boolean retorno = true;
		if (top != -1){
			retorno = false;
		}
		return retorno;
	}

	@Override
	public boolean isFull() {
		boolean retorno = false;
		if (top == array.length - 1){
			retorno = true;
		}
		return retorno;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(isFull()) {
			throw new StackOverflowException();
		}
		array[++top] = element;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		T topo = top();
		array[top--] = null;
		return topo;
	}

}
