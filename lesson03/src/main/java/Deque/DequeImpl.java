package Deque;

public class DequeImpl<E> implements Deque<E> {

    E[] data;
    int size;

    public DequeImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
    }

    @Override
    public void insertFront(E value) {
        if (isEmpty()) {
            data[size++] = value;
        } else  if (!isFull()){
            System.arraycopy(data,0, data, 1, size++);
            data[0] = value;
        } else System.out.println("Очередь заполнена.");
    }

    @Override
    public void insertRear(E value) {
        if (!isFull()){
            data[size++] = value;
        } else System.out.println("Очередь заполнена.");
    }

    @Override
    public E deleteFront() {
        E temp = data[0];
        System.arraycopy(data, 1, data, 0, --size);
        return temp;
    }

    @Override
    public E deleteRear() {
        return data[--size];
    }

    @Override
    public E getFront() {
        return data[0];
    }

    @Override
    public E getRear() {
        return data[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }
}
