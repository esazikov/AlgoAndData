package Stack;

public class StackImpl<E> implements Stack<E> {

    private E[] data;
    private int size;

    public StackImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
    }

    @Override
    public void push(E value) {
        if (!isFull()) {
            this.data[size++] = value;
        } else System.out.println("Ваш стэк полон!");
    }

    @Override
    public E peek() throws Exception {
        if (!isEmpty()) {
            return data[size - 1];
        } else throw new Exception("Ваш стэк пуст!");
    }

    @Override
    public E pop() throws Exception {
        if (!isEmpty()) {
            return data[--size];
        } else throw new Exception("Ваш стэк пуст!");
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
