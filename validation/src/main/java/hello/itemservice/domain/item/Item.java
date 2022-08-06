package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//@ScriptAssert: 오브젝트 관련 오류 처리해주는 어노테이션. but 실무에서 사용 시 어려움이 많고 복집하기 때문에 지양 -> 오브젝트 관련 오류는 자바 코드로 작성
//@ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 10000", message = "10000원 넘게 입력해주세요.")
@Data
public class Item {

    @NotNull
    private Long id;

    @NotBlank(message = "공백X")
    private String itemName;

    @NotNull
    @Range(min = 1000, max = 1000000)
    private Integer price;

    @NotNull
    @Max(value = 9999)
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
