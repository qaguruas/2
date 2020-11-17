package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;

public class EpnRegistration {

    String base_url = "https://backit.me/ru/cashback";
    String email = getRandomEmail();
    String pass = getRandomString(12);

    @Test
    void registrationSuccess() {

        open(base_url);
        sleep(3000);
        $("#signUpBtn").click();
        $("[placeholder='Введите эл.почту']").setValue(email);
        $("[type='password']").setValue(pass);
        $(byText("Создать аккаунт")).click();
        sleep(5000);
        $("html").shouldHave(Condition.text("Привет!"));

    }
}
