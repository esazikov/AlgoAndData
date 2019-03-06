package linkedlist;

import Stack.Stack;

public class LinkStackImpl<E> implements Stack<E> {

    private final LinkedList<E> data;

    public LinkStackImpl() {

        this.data = new SimpleLinkedListImpl<>();
    }

    @Override
    public void push(E value) {
        data.insert(value);
    }

    @Override
    public E peek() throws Exception {
        return data.getFirstElement();
    }

    @Override
    public E pop() throws Exception {
        return data.remove();
    }

    @Override
    public int size() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {

        return false;
    }
}
