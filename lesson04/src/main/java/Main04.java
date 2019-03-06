import linkedlist.Entry;
import linkedlist.LinkedList;
import linkedlist.SimpleLinkedListImpl;

public class Main04 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();

        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);

        linkedList.display();

        linkedList.remove(5);
        linkedList.remove(3);

        linkedList.display();

        for (Integer e : linkedList) {
            System.out.println(e);
        }

    }
}
