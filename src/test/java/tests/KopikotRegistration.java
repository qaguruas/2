package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.*;

public class KopikotRegistration {

    String base_url = "https://www.kopikot.ru/home";
    String email = getRandomEmail();
    String pass = getRandomString(20);

    @Test
    void registrationSuccess() {

        open(base_url);

        $(byText("Регистрация")).click();
        $("#signup-modal-email").setValue(email);
        $("[value='agree']").click();
        $(".authenticationButton").click();

        $(".welcome-modalContent").shouldHave(Condition.text("Спасибо за регистрацию! Теперь вы можете получать кэшбэк за каждую покупку онлайн."));

    }
}
