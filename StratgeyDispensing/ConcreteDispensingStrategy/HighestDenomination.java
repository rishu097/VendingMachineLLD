package StratgeyDispensing.ConcreteDispensingStrategy;

import ChainOfResponsibility.ConcreteHandler.TenHandler;
import ChainOfResponsibility.HandlerChain;
import StratgeyDispensing.DispensingStrategy;

public class HighestDenomination extends DispensingStrategy {
    @Override
    public void buildChain() {
        FiftyHandler.setNextHandler(TenHandler);
        TenHandler.setNextHandler(FiveHandler);
        FiveHandler.setNextHandler(OneHandler);
    }

    @Override
    public void handle(int amount) {
        FiftyHandler.handle(amount);
    }
}
