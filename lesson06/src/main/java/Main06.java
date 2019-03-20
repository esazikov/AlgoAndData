import java.util.Random;

public class Main06 {
    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            int temp = i;
            Thread thread = new Thread(() -> {
                Tree<Integer> tree = new TreeImpl<Integer>(4);
                Random random = new Random();
                for (int j = 0; j < 15; j++) {
                    tree.add(random.nextInt(40) - 20);
                }
                System.out.println("Дерево №" + temp + " " + (((TreeImpl<Integer>) tree).isBalanced() ? "сбалансировано" : "несбалансировано"));
            });
            thread.start();
        }

    }


}

