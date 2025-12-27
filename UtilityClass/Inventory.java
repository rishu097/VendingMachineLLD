package UtilityClass;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Data
@Getter
@Setter
public class Inventory {

    private HashMap<Integer, Item> itemCodeToItem;
    private HashMap<Integer,Integer> itemCodeToQuantity;
    public Inventory() {
        itemCodeToItem = new HashMap<>();
        itemCodeToQuantity = new HashMap<>();
    }

    public boolean hasEnoughMoney(int itemCode,int moneyInserted){
        Item item = itemCodeToItem.get(itemCode);
        return item.getPrice()<=moneyInserted;
    }

    public boolean hasStock(int itemCode){
        if(!itemCodeToQuantity.containsKey(itemCode)){
            return false;
        }
        return itemCodeToQuantity.get(itemCode)>0;
    }

    public void dispense(int itemCode){
        Item item = itemCodeToItem.get(itemCode);
        Integer curQuantity =  itemCodeToQuantity.get(itemCode);
        if(curQuantity==1){
            itemCodeToItem.remove(itemCode);
            itemCodeToQuantity.remove(itemCode);
        }
        else{
            itemCodeToQuantity.remove(itemCode);
            itemCodeToQuantity.put(itemCode,curQuantity-1);
        }
    }

    public void addItem(Item item,int quantity){
        Integer itemCode = item.getItemCode();
        itemCodeToItem.put(itemCode,item);
        itemCodeToQuantity.put(itemCode,quantity);
    }

}
