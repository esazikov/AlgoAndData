package Deque;

public interface Deque<E> {

    void insertFront(E value);
    void insertRear(E value);

    E deleteFront();
    E deleteRear();

    E getFront();
    E getRear();

    int size();
    boolean isFull();
    boolean isEmpty();
}
