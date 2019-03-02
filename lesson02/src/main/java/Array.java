public interface Array<E> {

    void add (E value);

    boolean remove (E value);
    void remove (int index);

    E get (int index);

    int indexOf (E value);
    boolean contains (E value);

    int getSize();
    boolean isEmpty();

    void sortBubble();
    void sortSelect();
    void sortInsert();
}
