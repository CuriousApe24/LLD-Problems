package vendingMachine;

public class DispensingState implements State{
    @Override
    public void insertCoin(VendingMachine machine, Coin coin) {
        System.out.println("DispensingState: Cannot insert coin during dispense.");
    }
    @Override
    public void selectItem(VendingMachine machine, String itemCode) {
        System.out.println("DispensingState: Cannot select item during dispense.");
    }
    @Override
    public void cancelRequest(VendingMachine machine) {
        System.out.println("DispensingState: Cannot cancel during dispense.");
    }

    @Override
    public void dispense(VendingMachine machine) {
        Item item = machine.getSelectedItem();
        if (item == null) {
             System.err.println("Error: DispensingState reached without selected item.");
             machine.setState(new IdleState()); // Recover
             return;
        }

        System.out.println("DispensingState: Processing dispense for " + item.getName());
        double price = item.getPrice();
        double balance = machine.getCurrentBalance();
        double change = balance - price;

        machine.dispenseItem();
        machine.dispenseChange(change);
        machine.resetBalance();
        machine.setState(new IdleState()); // Transaction complete
    }
     @Override public String getName() { return "Dispensing"; }   
}
