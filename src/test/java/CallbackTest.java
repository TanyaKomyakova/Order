import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CallbackTest {
    @Test
    void shouldSubmitRequest(){
        open("http://localhost:9999");
        SelenideElement form = $("[data-test-id]");
        form.$("[data-test-id=name] input").setValue("Комякова Татьяна");
        form.$("[data-test-id=phone] input").setValue("+79631645544");
        form.$("[data-test-id=agreement]").click();
        form.$("[data-test-id=submit]").click();
        $(".alert-success").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время"));

    }

}
