import java.util.ArrayList;
import java.util.Arrays;

public class Main05 {
    public static void main(String[] args) {

        ArrayList<Thing> things = new ArrayList<Thing>(Arrays.asList(
                new Thing("Книга", 3, 600),
                new Thing("Бинокль", 2, 5000),
                new Thing("Аптечка",5,1500),
                new Thing("Ноутбук",7,40000),
                new Thing("Котелок",4,500)));

        Backpack backpack = new Backpack(15);
        backpack.findBestSet(things);

        System.out.println("Лучший набор вещей с ценой : " + backpack.getBestPrice());

        for (Thing t: backpack.getBestThings()) {
            System.out.println(t.name);
        }


    }
}
