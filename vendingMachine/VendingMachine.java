package vendingMachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private State currentState;
    private final Inventory<Item> itemInventory = new Inventory<>();
    private final Inventory<Coin> cashInventory = new Inventory<>(); // For change
    private double currentBalance = 0.0;
    private Item selectedItem = null; // Item chosen by user in ReadyState
    private Map<String, Item> itemMap = new HashMap<>(); // Map code to Item object

    public VendingMachine() {
        // Initialize state
        currentState = new IdleState();
        // Load initial inventory (example)
        loadInitialItems();
        loadInitialCash();
         System.out.println("Vending Machine Ready. State: " + currentState.getName());
    }

    private void loadInitialItems() {
        Item cola = new Item("A1", "Cola", 1.50);
        Item chips = new Item("A2", "Chips", 1.00);
        Item candy = new Item("B1", "Candy", 0.75);
        itemMap.put(cola.getCode(), cola);
        itemMap.put(chips.getCode(), chips);
        itemMap.put(candy.getCode(), candy);

        itemInventory.add(cola, 5);
        itemInventory.add(chips, 10);
        itemInventory.add(candy, 0); // Candy is initially sold out
    }

     private void loadInitialCash() {
         // Load some initial change
         cashInventory.add(Coin.NICKEL, 20);
         cashInventory.add(Coin.DIME, 15);
         cashInventory.add(Coin.QUARTER, 10);
     }


    // --- Public Methods for User Interaction ---
    public void insertCoin(Coin coin) {
        currentState.insertCoin(this, coin);
    }

    public void selectItem(String itemCode) {
        currentState.selectItem(this, itemCode);
    }

    public void cancelRequest() {
        currentState.cancelRequest(this);
    }

    // --- Methods Called by State Objects ---
    void setState(State newState) {
        System.out.printf("Vending Machine: State changed from %s to %s%n", currentState.getName(), newState.getName());
        this.currentState = newState;
    }

    void addToBalance(double amount) {
        this.currentBalance += amount;
        System.out.printf("Vending Machine: Balance updated: $%.2f%n", this.currentBalance);
    }

     double getCurrentBalance() { return currentBalance; }

     void resetBalance() {
         this.currentBalance = 0.0;
         System.out.println("Vending Machine: Balance reset to $0.00");
     }

     void setSelectedItem(Item item) {
         this.selectedItem = item;
         System.out.println("Vending Machine: Selected item: " + item.getName());
     }

     Item getSelectedItem() { return selectedItem; }

     Inventory<Item> getItemInventory() { return itemInventory; }
     Inventory<Coin> getCashInventory() { return cashInventory; }

     Item getItemByCode(String itemCode) { return itemMap.get(itemCode); }


     // Dispensing logic (can be more complex)
     void dispenseItem() {
         if (selectedItem != null) {
             try {
                 itemInventory.deduct(selectedItem);
                 System.out.println("Vending Machine: Dispensing " + selectedItem.getName());
                 selectedItem = null; // Clear selection after dispense
             } catch (IllegalStateException e) {
                 System.err.println("Error: Tried to dispense sold out item: " + selectedItem.getName());
                 // Should ideally transition to an error state or refund
                 setState(new IdleState()); // Go back to idle for simplicity
             }
         }
     }

     void dispenseChange(double changeAmount) {
          if (changeAmount > 0) {
              System.out.printf("Vending Machine: Dispensing change: $%.2f%n", changeAmount);
              // TODO: Implement actual change calculation logic based on cashInventory
              // This involves figuring out the combination of coins.
              // For now, just log it. Need to deduct from cashInventory.
          }
     }

     void refund() {
         System.out.printf("Vending Machine: Refunding $%.2f%n", currentBalance);
         dispenseChange(currentBalance); // Use change mechanism for refund
         resetBalance();
     }
}

