package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (isFull()) {
			System.out.println(elements);
			System.out.println(table.length);
			throw new HashtableOverflowException();
		}
		if (element != null) {
			int probe = 0;
			int hash = calculaHash(element, probe);
			while (probe < capacity()) {
				if (table[hash] != null) {
					if (table[hash].equals(element)) {
						probe = capacity();
					} else if (table[hash].equals(deletedElement)) {
						table[hash] = element;
						probe = capacity();
						elements++;
					} else {
						probe++;
						hash = calculaHash(element, probe);
						COLLISIONS++;
					}
				} else {
					table[hash] = element;
					probe = capacity();
					elements++;
				}
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			int probe = 0;
			int hash = calculaHash(element, probe);
			while (probe != capacity() && table[hash] != null) {
				if (table[hash].equals(element)) {
					table[hash] = new DELETED();
					probe = capacity();
					elements--;
				} else {
					probe++;
					hash = calculaHash(element, probe);
					COLLISIONS++;
				}
			}
		}
	}

	@Override
	public T search(T element) {
		T retorno = null;
		if (element != null && indexOf(element) != -1) {
			retorno = element;
		}
		return retorno;
	}

	@Override
	public int indexOf(T element) {
		int indice = -1;
		if (element != null) {
			int probe = 0;
			int hash = calculaHash(element, probe);
			while (probe != capacity() && table[hash] != null) {
				if (table[hash].equals(element)) {
					indice = hash;
				}
				probe++;
				hash = calculaHash(element, probe);
			}
		}
		return indice;
	}

	public int calculaHash(T element, int probe) {
		int hash = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);
		return hash;
	}
}
