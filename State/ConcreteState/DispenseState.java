package State.ConcreteState;

import State.VendingMachineContext;
import State.VendingMachineState;

public class DispenseState implements VendingMachineState {
    @Override
    public String getState(){
        return "IdleState";
    }

    @Override
    public void setNextState(VendingMachineContext vendingMachineContext) {
        vendingMachineContext.setState(new IdleState());
    }
}
