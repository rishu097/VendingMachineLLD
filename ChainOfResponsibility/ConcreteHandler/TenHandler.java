package ChainOfResponsibility.ConcreteHandler;

import ChainOfResponsibility.Handler;
import CommonEnum.Coin;

public class TenHandler extends Handler {
    @Override
    public void handle(int amount) {
        int required = amount/ Coin.TEN.getValue();
        int left = amount%Coin.TEN.getValue();
        System.out.println("Dispensing "+required+" coins of One");
        if(nextHandler!=null) {
            this.nextHandler.handle(left);
        }
    }
}
