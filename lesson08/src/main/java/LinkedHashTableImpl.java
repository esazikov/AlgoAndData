import java.util.LinkedList;

public class LinkedHashTableImpl implements HashTable {

    public static final Integer INVALID_INDEX = -1;
    public static final Integer INVALID_COST = null;

    private class Entry {

        private Item key;
        private int value;

        public Entry(Item key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private LinkedList<Entry>[] data;
    private int size;
    private int maxSize;

    public LinkedHashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        this.data = new LinkedList[maxSize];
        for (int i = 0; i < maxSize; i++) {
            data[i] = new LinkedList<>();
        }
    }

    private int hashFunc(int key) {

        return key % data.length;
    }

    @Override
    public boolean put(Item item, Integer cost) {

        if (size == maxSize) {
            return false;
        }

        int index = hashFunc(item.hashCode());
        System.out.println(index);

        data[index].add(new Entry(item, cost));
        size++;
        return true;
    }

    @Override
    public Integer get(Item item) {

        int index = hashFunc(item.hashCode());
        for (Entry e: data[index]) {
            if (e.key.equals(item)) {
                return e.value;
            }
        }
            return INVALID_COST;
    }

    @Override
    public boolean remove(Item item) {
        int index = hashFunc(item.hashCode());
        for (Entry e: data[index]) {
            if (e.key.equals(item)) {
                size--;
                return data[index].remove(e);
            }
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(String.format("%d = [%s] ", i, data[i]));
        }
        System.out.println("------------------");
    }

}