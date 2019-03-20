import java.util.ArrayList;

public class Backpack {

    private int maxWeight;
    private int bestPrice;

    private ArrayList<Thing> bestThings = new ArrayList<Thing>();

    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    private int weightBackpack (ArrayList<Thing> things) {
        int weightBackpack = 0;
        for (Thing t: things) {
            weightBackpack += t.getWeight();
        }
        return weightBackpack;
    }

    private int priceBackpack (ArrayList<Thing> things) {
        int priceBackpack = 0;
        for (Thing t: things) {
            priceBackpack += t.getPrice();
        }
        return priceBackpack;
    }

    private void bestSet(ArrayList<Thing> things) {
        if (bestThings == null) {
            if (weightBackpack(things) <= maxWeight) {
                bestThings = things;
                bestPrice = priceBackpack(things);
            }
        } else {
            if (weightBackpack(things) <= maxWeight && priceBackpack(things) > bestPrice) {
                bestThings = things;
                bestPrice = priceBackpack(things);
            }
        }
    }

    public void findBestSet (ArrayList<Thing> things) {
        if (things.size() >0) {
            bestSet(things);
        }
        for (int i = 0; i < things.size(); i++) {
            ArrayList<Thing> newThings = new ArrayList<Thing>(things);
            newThings.remove(i);
            findBestSet(newThings);
        }
    }

    public ArrayList<Thing> getBestThings() {
        return bestThings;
    }

    public int getBestPrice() {
        return bestPrice;
    }
}
