import java.util.Arrays;

public class ArrayImpl<E extends Object & Comparable<? super E>> implements Array<E> {

    private static final int DEFAULT_CAPACITY = 16;
    protected static final int INVALID_VALUE = -1;

    protected E[] data;
    protected int currentSize;

    public ArrayImpl () {
        this(DEFAULT_CAPACITY);
    }

    public ArrayImpl (int initialCapacity) {
        this.data = (E[]) new Object[initialCapacity];
    }

    @Override
    public void add(E value) {
        checkGrow();
        data[currentSize++] = value;
    }

    protected void checkGrow() {
        if (currentSize < data.length)
            return;

        data = Arrays.copyOf(data, data.length * 2);
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        if (index == INVALID_VALUE)
            return false;
        remove(index);
        return true;
    }

    @Override
    public void remove(int index) {
        if (index > currentSize) throw new ArrayIndexOutOfBoundsException(index);
        System.arraycopy(data, index + 1, data, index, currentSize - 1 - index );
        data[--currentSize] = null;
    }

    @Override
    public E get(int index) {
        return data[index];
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < currentSize ; i++) {
            if (data[i].equals(value))
                return i;
        }
        return INVALID_VALUE;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != INVALID_VALUE ? true : false;
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public void sortBubble() {
        for (int i = 0; i < currentSize - 1; i++) {
            for (int j = 0; j < currentSize - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    exchange(j, j + 1);
                }
            }
        }
    }

    @Override
    public void sortSelect() {
        for (int i = 0; i < currentSize - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < currentSize ; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            exchange(minIndex, i);
        }

    }

    @Override
    public void sortInsert() {
        for (int i = 1; i < currentSize; i++) {
            E temp = data[i];

            int in = i;

            while (in > 0 && data[in - 1].compareTo(temp) >= 0) {
                data[in] = data[in -1];
                in--;
            }
            data[in] = temp;
        }

    }

    private void exchange(int index1, int index2) {
        E temp = data[index1];
        data[index1] = data [index2];
        data[index2] = temp;
    }
}
