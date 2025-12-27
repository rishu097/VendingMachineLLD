package State;

import State.ConcreteState.IdleState;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class VendingMachineContext {

    private VendingMachineState vendingMachineState;

    public VendingMachineContext() {
        this.vendingMachineState = new IdleState();
    }

    public void setNextState() {
        vendingMachineState.setNextState(this);
    }

    public void setState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }
}
