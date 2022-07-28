package hello.itemservice.validation;

import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.ObjectError;

import static org.assertj.core.api.Assertions.*;

public class MessageCodesResolverTest {

    //MessageCodeResolver: 검증 오류 코드로 메시지 코드들을 생성 (객체오류, 필드오류에 따라 순서 존재)
    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodesResolverObject() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");
//        for (String messageCode : messageCodes) {
//            //new ObjectError("item", new String[]{"required.item", "required"}); --> 이게 출력
//            System.out.println("messageCode = " + messageCode);
//        }
        assertThat(messageCodes).containsExactly("required.item", "required");
    }

    @Test
    void messageCodesResolverField() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
//        for (String messageCode : messageCodes) {
//            //1.rejectValue가 codesResolver 호출 --> bindingResult.rejectValue("itemName", "required");
//            //2.messageCodes에 들어감 --> new FieldError("item", "itemName", null, false, messageCodes, null, null);
//            System.out.println("messageCode = " + messageCode);
//        }
        assertThat(messageCodes).containsExactly(
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required"
        );
    }
}
