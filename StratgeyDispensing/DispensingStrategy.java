package StratgeyDispensing;

import ChainOfResponsibility.ConcreteHandler.FiftyHandler;
import ChainOfResponsibility.ConcreteHandler.FiveHandler;
import ChainOfResponsibility.ConcreteHandler.OneHandler;
import ChainOfResponsibility.ConcreteHandler.TenHandler;
import ChainOfResponsibility.Handler;
import ChainOfResponsibility.HandlerChain;

public abstract class DispensingStrategy {
    protected Handler OneHandler;
    protected Handler FiveHandler;
    protected Handler TenHandler;
    protected Handler FiftyHandler;
    public DispensingStrategy() {
        OneHandler = new OneHandler();
        FiveHandler = new FiveHandler();
        TenHandler = new TenHandler();
        FiftyHandler = new FiftyHandler();
    }
    public abstract void buildChain();
    public abstract void handle(int amount);
}
