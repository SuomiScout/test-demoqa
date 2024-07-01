package demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;

public class TextBox {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void fillFormTest () {
        String userName = "Patrick Star";
        //open("https://www.google.ru/?hl=ru");
        open("/text-box");
        Selenide.sleep(40000);
        $(".body-height").shouldHave(text("Text Box"));

        $("#userName").setValue(userName);
        $("#userEmail").setValue("star666@mail.ru");
        $("#currentAddress").setValue("Bikini Bottom 666");
        $("#permanentAddress").setValue("Bikini Bottom 666");
        $("#submit").click();

        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave((text(userName)));
        $("#output #email").shouldHave((text("star666@mail.ru")));

        Selenide.sleep(10000);
    }
}
