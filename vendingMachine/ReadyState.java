package vendingMachine;

public class ReadyState implements State {
    @Override
    public void insertCoin(VendingMachine machine, Coin coin) {
        System.out.println("ReadyState: Coin inserted.");
        machine.addToBalance(coin.getValue());
        machine.getCashInventory().add(coin, 1);
        // Stay in ReadyState
    }

    @Override
    public void selectItem(VendingMachine machine, String itemCode) {
        Item item = machine.getItemByCode(itemCode);
        if (item == null) {
            System.out.println("ReadyState: Invalid item code selected.");
            return;
        }

        if (!machine.getItemInventory().hasItem(item)) {
            System.out.println("ReadyState: Item " + item.getName() + " is SOLD OUT.");
            machine.setState(new SoldOutState()); // Go to SoldOutState
        } else if (machine.getCurrentBalance() < item.getPrice()) {
            System.out.printf("ReadyState: Insufficient funds for %s ($%.2f). Current balance: $%.2f%n",
                              item.getName(), item.getPrice(), machine.getCurrentBalance());
        } else {
            System.out.println("ReadyState: Item selected: " + item.getName());
            machine.setSelectedItem(item);
            machine.setState(new DispensingState());
        }
    }

    @Override
    public void cancelRequest(VendingMachine machine) {
        System.out.println("ReadyState: Request cancelled.");
        machine.refund();
        machine.setState(new IdleState());
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("ReadyState: Please select an item first.");
    }
     @Override public String getName() { return "Ready"; }
}
