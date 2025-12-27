import CommonEnum.Coin;
import UtilityClass.Item;

public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        Item item1 = new Item(1, "CocoCola", 10);
        Item item2 = new Item(2, "Pepsi", 20);
        Item item3 = new Item(3, "Pizza", 30);

        vendingMachine.addItem(item1,4);
        vendingMachine.addItem(item2,4);
        vendingMachine.addItem(item3,4);

        System.out.println("Welcome to the vending Machine!! Please Insert Money to get Started");
        vendingMachine.insertMoney(Coin.TEN);
        vendingMachine.insertMoney(Coin.FIVE);

        vendingMachine.cancelTransaction();
        vendingMachine.selectProduct(1);
        vendingMachine.cancelTransaction();
        vendingMachine.dispense();
    }

}
