package vendingMachine;

public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        System.out.println("\n--- Scenario 1: Buy Cola ---");
        vm.insertCoin(Coin.DOLLAR);
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER); // Balance: 1.50
        vm.selectItem("A1"); // Select Cola (1.50)

        System.out.println("\n--- Scenario 2: Buy Chips, Cancel ---");
        vm.insertCoin(Coin.DOLLAR); // Balance: 1.00
        vm.selectItem("A2"); // Select Chips (1.00) - Should dispense
        // Now try cancelling after buying chips
        // vm.cancelRequest(); // Should do nothing as it's Idle now

        System.out.println("\n--- Scenario 3: Insufficient Funds ---");
        vm.insertCoin(Coin.QUARTER); // Balance: 0.25
        vm.selectItem("A2"); // Select Chips (1.00) - Insufficient funds

        System.out.println("\n--- Scenario 4: Cancel Request ---");
        vm.insertCoin(Coin.DIME);    // Balance: 0.35
        vm.cancelRequest();         // Refund 0.35

        System.out.println("\n--- Scenario 5: Sold Out ---");
        vm.insertCoin(Coin.DOLLAR); // Balance: 1.00
        vm.selectItem("B1");        // Select Candy (0.75) - Sold Out
        // Machine should show Sold Out, then return to Ready state
        System.out.println("Current balance after Sold Out message: " + vm.getCurrentBalance()); // Should still be 1.00
        vm.selectItem("A2"); // Select Chips (1.00) - Now should dispense
    }
}