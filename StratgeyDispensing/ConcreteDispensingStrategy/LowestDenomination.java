package StratgeyDispensing.ConcreteDispensingStrategy;

import ChainOfResponsibility.HandlerChain;
import StratgeyDispensing.DispensingStrategy;

public class LowestDenomination extends DispensingStrategy {
    @Override
    public void buildChain(){
        OneHandler.setNextHandler(FiveHandler);
        FiveHandler.setNextHandler(TenHandler);
        TenHandler.setNextHandler(FiftyHandler);
    }

    @Override
    public void handle(int amount) {
        OneHandler.handle(amount);
    }
}
