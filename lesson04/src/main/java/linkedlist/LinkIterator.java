package linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

public class LinkIterator<E> implements Iterator<E> {
    private Entry<E> current;
    private Entry<E> previous;
    private SimpleLinkedListImpl list;

    public LinkIterator (SimpleLinkedListImpl list) {
        this.list = list;
        this.reset();
    }

    public void reset() {
        current = list.firstElement;
        previous = null;
    }

    public boolean atEnd() {

        return (current.getNext() == null);
    }

    public void nextEntry() {
        previous = current;
        current = current.getNext();
    }

    public Entry getCurrent() {

        return current;
    }

    public void insertAfter (E value) {
        Entry<E> newEntry = new Entry<>(value);
        if (list.isEmpty()) {
            list.setFirst(newEntry);
            current = newEntry;
        } else {
            newEntry.setNext(current.getNext());
            current.setNext(newEntry);
        }
        list.currentSize++;
    }

    public void insertBefore(E value) {
        Entry<E> newEntry = new Entry<>(value);
        if (previous == null) {
            newEntry.setNext(list.firstElement);
            list.setFirst(newEntry);
            reset();
        } else {
            newEntry.setNext(previous.getNext());
            previous.setNext(newEntry);
            current = newEntry;
        }
        list.currentSize++;
    }

    public E deleteCurrent() {
        E value = current.getValue();
        if (previous == null) {
            list.setFirst(current.getNext());
            reset();
        } else {
            previous.setNext(current.getNext());
            if (atEnd()) {
                reset();
            } else {
                current = current.getNext();
            }
        }
        list.currentSize--;
        return value;
    }

    @Override
    public void remove() {
        deleteCurrent();
    }

    @Override
    public void forEachRemaining(Consumer action) {

    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public E next() {
        E next = current.getValue();
        previous = current;
        current = current.getNext();
        return next;
    }
}
