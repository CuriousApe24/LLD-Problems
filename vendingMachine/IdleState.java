package vendingMachine;

class IdleState implements State {
    @Override
    public void insertCoin(VendingMachine machine, Coin coin) {
        System.out.println("IdleState: Coin inserted.");
        machine.addToBalance(coin.getValue());
        machine.getCashInventory().add(coin, 1);
        machine.setState(new ReadyState());
    }
    @Override
    public void selectItem(VendingMachine machine, String itemCode) {
        System.out.println("IdleState: Please insert coins first.");
    }
    @Override
    public void cancelRequest(VendingMachine machine) {
        System.out.println("IdleState: Nothing to cancel.");
    }
    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("IdleState: Please select an item first.");
    }
    @Override public String getName() { return "Idle"; }
}
