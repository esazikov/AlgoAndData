package linkedlist.twosidelinkedlist;

import linkedlist.Entry;
import linkedlist.SimpleLinkedListImpl;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E> {

    private Entry lastElement;

    @Override
    public void insertLeft(E value) {
        super.insert(value);
        if (getSize() == 1) {
            lastElement = firstElement;
        }
    }

    @Override
    public void insertRight(E value) {
        Entry<E> newElement = new Entry<>(value);
        if (isEmpty()) {
            firstElement = newElement;
        } else {
            lastElement.setNext(newElement);
        }

        lastElement.setNext(newElement);
        lastElement = newElement;
        currentSize++;
    }

    @Override
    public E removeLeft() {
        E removedElement = super.remove();
        if (isEmpty()) {
            lastElement = null;
        }

        return removedElement;
    }

    public boolean remove(E value) {

        Entry<E> current = firstElement;
        Entry<E> previous = null;

        while (current != null) {
            if (current.getValue().equals(value)) {
                break;
            }
            previous = current;
            current = current.getNext();
        }

        if (current == null) {
            return false;
        }

        if (previous == null) {
            if (current.getNext() == null){
                firstElement = null;
            } else {
                firstElement = current.getNext();
            }
        } else if (current == lastElement) {
            lastElement = previous;
            previous.setNext(null);
        } else {
            previous.setNext(current.getNext());
        }

        currentSize--;
        return false;
    }
}