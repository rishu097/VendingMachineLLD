import ChainOfResponsibility.HandlerChain;
import CommonEnum.Coin;
import State.ConcreteState.DispenseState;
import State.ConcreteState.HasMoneyState;
import State.ConcreteState.IdleState;
import State.ConcreteState.ProductSelectionState;
import State.VendingMachineContext;
import StratgeyDispensing.DispensingStrategy;
import UtilityClass.Inventory;
import UtilityClass.Item;

public class VendingMachine {

    private Inventory inventory;
    private VendingMachineContext vendingMachineContext;
    int currentAmount;
    int selectedProductItemCode;
    private static VendingMachine vendingMachine;
    private HandlerChain handlerChain;


    private VendingMachine() {
        this.inventory = new Inventory();
        this.vendingMachineContext = new VendingMachineContext();
        currentAmount = 0;
        handlerChain = new HandlerChain();
    }
    public static VendingMachine getInstance() {
        if(vendingMachine == null) {
            vendingMachine = new VendingMachine();
        }
        return vendingMachine;
    }
    public void addItem(Item item,int quantity) {
        inventory.addItem(item,quantity);
    }
    public void insertMoney(Coin coin) {
        if(vendingMachineContext.getVendingMachineState() instanceof IdleState || vendingMachineContext.getVendingMachineState() instanceof HasMoneyState){
            currentAmount = currentAmount + coin.getValue();
            if(vendingMachineContext.getVendingMachineState() instanceof IdleState) {
                vendingMachineContext.setNextState();
            }
            System.out.println("Current amount is " + currentAmount);
        }
        else{
            throw new IllegalStateException("Coin insertion not allowed Now");
        }
    }
    public void cancelTransaction() {

        handlerChain.handle(this.currentAmount);
        this.currentAmount = 0;
        vendingMachineContext.setState(new IdleState());
        this.selectedProductItemCode = -1;

    }
    public void selectProduct(int itemCode){
        if(vendingMachineContext.getVendingMachineState() instanceof HasMoneyState){
            if(inventory.hasStock(itemCode) && inventory.hasEnoughMoney(itemCode,currentAmount)){
                vendingMachineContext.setNextState();
                markSelectedProduct(itemCode);
            }
            else{
                throw new IllegalArgumentException("Item is Out of stock or More money is to be inserted");
            }

        }
        else{
            throw new IllegalStateException("Please insert coin First");
        }
    }
    private void markSelectedProduct(int itemCode){
        if(vendingMachineContext.getVendingMachineState() instanceof ProductSelectionState) {
            this.selectedProductItemCode = itemCode;
            System.out.println("Selected product code is " + selectedProductItemCode);
            vendingMachineContext.setNextState();
        }
        else{
            throw new IllegalStateException("Please insert coin First");
        }
    }

    public void dispense(){
        if(vendingMachineContext.getVendingMachineState() instanceof DispenseState){
            Item item = inventory.getItemCodeToItem().get(selectedProductItemCode);
            inventory.dispense(selectedProductItemCode);
            int extraAmount = currentAmount-item.getPrice();
            System.out.println("Your product is Dispensed :"+item.getItemName()+" and a refund of :"+item.getPrice());
            this.currentAmount=0;
            this.selectedProductItemCode=-1;
            vendingMachineContext.setNextState();
        }
        else{
            throw new IllegalStateException("Please insert coin First");
        }
    }
}
