package vendingMachine;

import java.util.Objects;

public class Item {
    private final String code;
    private final String name;
    private final double price;

    public Item(String code, String name, double price) {
        this.code = code; this.name = name; this.price = price;
    }
    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }

     @Override public boolean equals(Object o) { /* Based on code */ return o instanceof Item && code.equals(((Item) o).code); }
     @Override public int hashCode() { return Objects.hash(code); }
}
