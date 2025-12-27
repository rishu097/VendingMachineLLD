package ChainOfResponsibility.ConcreteHandler;

import ChainOfResponsibility.Handler;
import ChainOfResponsibility.HandlerChain;
import CommonEnum.Coin;

public class FiftyHandler extends Handler {

    @Override
    public void handle(int amount) {
        int required = amount/ Coin.FIFTY.getValue();
        int left = amount%Coin.FIFTY.getValue();
        System.out.println("Dispensing "+required+" coins of Fifty");
        if(nextHandler!=null) {
            this.nextHandler.handle(left);
        }
    }
}
