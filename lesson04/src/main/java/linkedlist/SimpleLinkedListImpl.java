package linkedlist;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected Entry<E> firstElement;
    protected int currentSize;

    @Override
    public void insert(E value) {
        Entry<E> newElement = new Entry<>(value);
        newElement.setNext(firstElement);
        firstElement = newElement;
        currentSize++;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        Entry<E> removedElement = firstElement;
        firstElement = firstElement.getNext();
        currentSize--;
        return removedElement.getValue();
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public boolean find(E value) {
        Entry<E> current = firstElement;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
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
        } else {
            previous.setNext(current.getNext());
        }

        currentSize--;
        return false;
    }

    @Override
    public void display() {
        System.out.println("----------");
        System.out.println("display " + this.getClass().getSimpleName());
        Entry<E> current = firstElement;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
        System.out.println("----------");
    }
}
