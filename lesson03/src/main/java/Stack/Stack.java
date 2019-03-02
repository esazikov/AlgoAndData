package Stack;

public interface Stack<E> {

    void push(E value);

    E peek() throws Exception;
    E pop() throws Exception;


    int size();
    boolean isEmpty();
    boolean isFull();
}
