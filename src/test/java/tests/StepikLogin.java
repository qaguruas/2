package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepikLogin {

    String base_url = "https://stepik.org/";
    String email = "test.artem2016@gmail.com";
    String pass = "9379992";

    @Test
    void loginSuccess() {

        open(base_url);

        $("#ember298").click(); //bad selector, need refactor
        $(byName("login")).setValue(email);
        $(byName("password")).setValue(pass);
        $(".sign-form__btn.button_with-loader").click();

        $(".navbar__links").shouldHave(Condition.text("Мои курсы"));
    }
}
