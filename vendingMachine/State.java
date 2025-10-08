package vendingMachine;

public interface State {
    void insertCoin(VendingMachine machine, Coin coin);
    void selectItem(VendingMachine machine, String itemCode);
    void cancelRequest(VendingMachine machine);
    void dispense(VendingMachine machine);
    String getName();
}
