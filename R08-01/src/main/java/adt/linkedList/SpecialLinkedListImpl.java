package adt.linkedList;

public class SpecialLinkedListImpl<T> extends SingleLinkedListImpl<T> implements SpecialLinkedList<T> {
    public static void main(String[] args) {
        SpecialLinkedListImpl<Integer> linkedList = new SpecialLinkedListImpl<Integer>();
        linkedList.insert(new Integer(1));

        System.out.println(linkedList.elementFromTheEnd(2));
    }

    @Override
    public void swap(T elem1, T elem2) {
        SingleLinkedListNode<T> aux1 = getHead();
        SingleLinkedListNode<T> aux2 = getHead();
        while ((!aux1.getData().equals(elem1) || !aux2.getData().equals(elem2)) && (!aux1.isNIL() || !aux2.isNIL())) {
            if (!aux1.getData().equals(elem1)) {
                aux1 = aux1.getNext();
            }
            if (!aux2.getData().equals(elem2)) {
                aux2 = aux2.getNext();
            }
        }
        T aux3 = aux1.getData();
        aux1.setData(aux2.getData());
        aux2.setData(aux3);
    }

    @Override
    public T elementFromTheEnd(int k) {
        SingleLinkedListNode<T> aux = getHead();
        SingleLinkedListNode<T> aux2 = getHead();
        T retorno = null;
        while (k > 0 && !aux.isNIL()) {
            aux = aux.getNext();
            k--;
        }
        if (k == 0) {
            while (!aux.isNIL()) {
                aux2 = aux2.getNext();
                aux = aux.getNext();
            }
            retorno = aux2.getData();
        }
        return retorno;
    }
}