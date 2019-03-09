package linkedlist;

public class LinkIteratorApp {
    public static void main(String[] args) {
        SimpleLinkedListImpl<Integer> linkedList = new SimpleLinkedListImpl<>();
        LinkIterator iterator = new LinkIterator(linkedList);



        iterator.insertAfter(1);
        iterator.insertBefore(2);
        iterator.insertAfter(3);
        iterator.insertBefore(4);
        iterator.insertAfter(5);

        linkedList.display();

        System.out.println(iterator.getCurrent());
        iterator.deleteCurrent();

        linkedList.display();

        System.out.println(iterator.getCurrent());
        iterator.nextEntry();
        System.out.println(iterator.getCurrent());

        iterator.reset();

        int size = linkedList.getSize();
        for (int i = 0; i < size; i++) {
            iterator.deleteCurrent();
        }

        linkedList.display();

    }
}
