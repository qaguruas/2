package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

import static utils.RandomUtils.*;

public class RegistrationForm {

    String base_url = "https://testpages.herokuapp.com/";
    String m = getRandomEmail();
    @Test
    void registrationSuccess() {

        open(base_url);

        $("#htmlformtest").click(); //id
        $(byName("username")).setValue("sometestname"); //name
        $(byName("password")).setValue("sometestpass"); //name
        $("[value='submit']").click(); //attributes

        $(".explanation") //classname
                .shouldHave(Condition.text("You submitted a form. The details below show the values you entered for processing."));
    }
}
