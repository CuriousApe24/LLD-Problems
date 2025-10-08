package vendingMachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {
    private final Map<T, Integer> stock = new HashMap<>();

    public int getCount(T item) {
        return stock.getOrDefault(item, 0);
    }

    public boolean hasItem(T item) {
        return getCount(item) > 0;
    }

    public void add(T item, int count) {
        stock.put(item, getCount(item) + count);
         System.out.printf("Inventory: Added %d of %s, Count: %d%n", count, item, getCount(item));
    }

    public void deduct(T item) throws IllegalStateException {
        if (!hasItem(item)) {
            throw new IllegalStateException(item + " is out of stock.");
        }
        int currentCount = getCount(item);
        stock.put(item, currentCount - 1);
        System.out.printf("Inventory: Deducted 1 of %s, Count: %d%n", item, getCount(item) -1 );
    }

    public void load(Map<T, Integer> initialStock) {
        stock.putAll(initialStock);
    }

    public void clear() {
        stock.clear();
    }
}
