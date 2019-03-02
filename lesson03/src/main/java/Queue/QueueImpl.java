package Queue;

public class QueueImpl<E> implements Queue<E> {

    private E[] data;
    private int size;

    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
    }

    @Override
    public void insert(E value) {
        if (!isFull()) {
            this.data[size++] = value;
        } else System.out.println("Ваша очередь полна!");
    }

    @Override
    public E remove() {
        E temp = data[0];
        System.arraycopy(data, 1, data, 0, --size);
        return temp;
    }

    @Override
    public E peek() {
        return data[0];
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
