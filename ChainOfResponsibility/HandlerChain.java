package ChainOfResponsibility;

import ChainOfResponsibility.ConcreteHandler.FiftyHandler;
import ChainOfResponsibility.ConcreteHandler.FiveHandler;
import ChainOfResponsibility.ConcreteHandler.OneHandler;
import ChainOfResponsibility.ConcreteHandler.TenHandler;
import CommonEnum.DispensingStrategyEnum;
import StratgeyDispensing.ConcreteDispensingStrategy.HighestDenomination;
import StratgeyDispensing.ConcreteDispensingStrategy.LowestDenomination;
import StratgeyDispensing.DispensingStrategy;

public class HandlerChain {

    private DispensingStrategy dispensingStrategy;
    public HandlerChain() {
        this.dispensingStrategy = new HighestDenomination();
    }
    public void buildChain(DispensingStrategyEnum dispensingStrategyEnum) {
        if(dispensingStrategyEnum == DispensingStrategyEnum.HIGHEST) {
            this.dispensingStrategy = new HighestDenomination();
        }
        else{
            this.dispensingStrategy = new LowestDenomination();
        }
        this.dispensingStrategy.buildChain();

    }
    public void handle(int amount){
        this.dispensingStrategy.handle(amount);
    }
}
