package vendingMachine;

public class SoldOutState implements State {
    @Override
    public void insertCoin(VendingMachine machine, Coin coin) {
        System.out.println("SoldOutState: Cannot insert coin now."); // Or maybe accept it? Depends.
    }
    @Override
    public void selectItem(VendingMachine machine, String itemCode) {
         System.out.println("SoldOutState: Cannot select item now.");
    }
     @Override
    public void cancelRequest(VendingMachine machine) {
         // Allow cancellation even if last item selected was sold out
         System.out.println("SoldOutState: Request cancelled.");
         machine.refund();
         machine.setState(new IdleState());
    }
    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("--- ITEM SOLD OUT ---");
         try { Thread.sleep(1500); } catch (InterruptedException e) {} // Simulate display time
         machine.setState(new ReadyState()); // Go back to ready state
    }
     @Override public String getName() { return "SoldOut"; }
}
