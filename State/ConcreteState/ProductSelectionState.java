package State.ConcreteState;

import State.VendingMachineContext;
import State.VendingMachineState;
import org.springframework.context.annotation.DeferredImportSelector;

public class ProductSelectionState implements VendingMachineState {
    @Override
    public String getState(){
        return "Product Selection State";
    }

    @Override
    public void setNextState(VendingMachineContext vendingMachineContext) {
        vendingMachineContext.setState(new DispenseState());
    }
}
