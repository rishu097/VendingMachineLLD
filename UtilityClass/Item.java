package UtilityClass;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
public class Item {

    private int itemCode;
    private String itemName;
    private int price;
}
