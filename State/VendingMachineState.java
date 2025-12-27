package State;

public interface VendingMachineState {

    String getState();
    void setNextState(VendingMachineContext vendingMachineContext);
}
