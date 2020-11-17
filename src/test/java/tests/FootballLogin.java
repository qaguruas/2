package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FootballLogin {

    String base_url = "https://football.ua/";
    String email = "test.artem2016@gmail.com";
    String pass = "9379992";

    @Test
    void footballUaLoginSuccess() {

        open(base_url);

        $("#enter-link").click();
        $("#loginemail").setValue(email);
        $("#loginpassword").setValue(pass);
        $(".submit").click();

        $(".registerArea").shouldHave(Condition.text("Выход"));
    }
}
