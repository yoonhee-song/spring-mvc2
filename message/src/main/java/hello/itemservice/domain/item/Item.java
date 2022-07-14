package hello.itemservice.domain.item;

import lombok.Data;

@Data
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;
    private String saveSuccessful;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    //저장 완료를 위해 따로 추가
    public Item(String saveSuccessful) {
        this.saveSuccessful = saveSuccessful;
    }
}
