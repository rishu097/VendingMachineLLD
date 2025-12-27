package ChainOfResponsibility.ConcreteHandler;

import ChainOfResponsibility.Handler;
import CommonEnum.Coin;

public class OneHandler extends Handler {
    @Override
    public void handle(int amount) {
        int required = amount/ Coin.ONE.getValue();
        int left = amount%Coin.ONE.getValue();
        System.out.println("Dispensing "+required+" coins of One");
        if(nextHandler!=null) {
            this.nextHandler.handle(left);
        }
    }
}
