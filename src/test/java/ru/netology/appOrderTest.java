package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class appOrderTest {
    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");
        SelenideElement form = $("form");
        form.$("[data-test-id=name] input").setValue("Булин Алексей");
        form.$("[data-test-id=phone] input").setValue("+79293020000");
        form.$("[data-test-id=agreement]").click();
        form.$("[type='button']").click();
        $("[data-test-id='order-success']").shouldHave(exactText("  Ваша заявка успешно отправлена!" +
                " Наш менеджер свяжется с вами в ближайшее время."));
    }
}

