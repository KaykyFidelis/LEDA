package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		try {
			stack1.push(element);
		} catch (Exception StackOverflowException) {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T retorno = null;
		if(isEmpty()){
			throw new QueueUnderflowException();
		} else{
			try {
				while (!stack1.isEmpty()) {
					T element = stack1.pop();
					stack2.push(element);
				}
			} catch (Exception StackUnderflowException) {
				StackUnderflowException.printStackTrace();
			}
		}

		try {
			retorno = stack2.pop();
		} catch (Exception StackUnderflowException) {
			StackUnderflowException.printStackTrace();
		}

		while (!stack2.isEmpty()) {
			try {
				T element = stack2.pop();
				stack1.push(element);
			} catch (Exception StackUnderflowException) {
				StackUnderflowException.printStackTrace();
			}
		}

		return retorno;
		
	}

	@Override
	public T head() {
		T frente = null;
		try {
			while (true) {
				T element = stack1.pop();
				stack2.push(element);
			}
		} catch (Exception StackUnderflowException) {
			frente = stack2.top();
		}
		return frente;
	}

	@Override
	public boolean isEmpty() {
		boolean retorno = false;
		if(stack1.isEmpty()){
			retorno = true;
		}
		return retorno;
	}

	@Override
	public boolean isFull() {
		boolean retorno = false;
		if(stack1.isFull()){
			retorno = true;
		}
		return retorno;
	}

}
