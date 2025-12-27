package State.ConcreteState;

import State.VendingMachineContext;
import State.VendingMachineState;

public class HasMoneyState implements VendingMachineState {
    @Override
    public String getState(){
        return "Has Money State";
    }

    @Override
    public void setNextState(VendingMachineContext vendingMachineContext) {
        vendingMachineContext.setState(new ProductSelectionState());
    }
}
