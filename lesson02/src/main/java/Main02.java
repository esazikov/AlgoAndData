import java.util.Random;

public class Main02 {
    public static void main(String[] args) {

        ArrayImpl<Integer> arraySortBubble = new ArrayImpl<>();
        ArrayImpl<Integer> arraySortSelect = new ArrayImpl<>();
        ArrayImpl<Integer> arraySortInsert = new ArrayImpl<>();

        Random random = new Random();
        long startTime;

        for (int i = 0; i < 100000 ; i++) {
            int newValue = random.nextInt(500000);
            arraySortBubble.add(newValue);
            arraySortSelect.add(newValue);
            arraySortInsert.add(newValue);
        }

        startTime = System.currentTimeMillis();
        arraySortBubble.sortBubble();
        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        arraySortSelect.sortSelect();
        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        arraySortInsert.sortInsert();
        System.out.println(System.currentTimeMillis() - startTime);

    }
}
