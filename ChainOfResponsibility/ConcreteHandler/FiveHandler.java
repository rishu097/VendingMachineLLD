package ChainOfResponsibility.ConcreteHandler;

import ChainOfResponsibility.Handler;
import CommonEnum.Coin;

public class FiveHandler extends Handler {
    @Override
    public void handle(int amount) {
        int required = amount/ Coin.FIVE.getValue();
        int left = amount%Coin.FIVE.getValue();
        System.out.println("Dispensing "+required+" coins of Five");
        if(nextHandler!=null) {
            this.nextHandler.handle(left);
        }
    }
}
