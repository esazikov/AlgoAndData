
import Deque.DequeImpl;
import Queue.QueueImpl;
import Stack.StackImpl;

import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String st = scanner.nextLine();
        char[] chars = st.toCharArray();
        StackImpl<Character> stack = new StackImpl(chars.length);
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
        }

        while (!stack.isEmpty()) {
            try {
                stringBuilder.append(stack.pop());
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.println(stringBuilder);

    }
}
