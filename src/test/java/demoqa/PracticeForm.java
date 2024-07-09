package demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillPracticeForm() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        Selenide.executeJavaScript("$('.sidebar-content').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
        sleep(5000);
        $("#firstName").setValue("Patrick");
        $("#userEmail").setValue("star666@mail.ru");
        $("#lastName").setValue("Star");
        $("#gender-radio-2").ancestor("div").click();
        sleep(5000);
        $("#gender-radio-3").ancestor("div").click();
        sleep(5000);
        $("#userNumber").setValue("88005553535");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");//другой вариант
        //$(byText("March")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1961")).click();
        $(byText("13")).click();
        sleep(5000);
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbies-checkbox-1").ancestor("div").click();
        File cv = new File("src/test/resources/zat.jpg");
        $("#uploadPicture").uploadFile(cv);
        //$("#uploadPicture").uploadFile(new File("src/test/resources/zat.jpg")); //альтернативный вариант
        //$("#uploadPicture").uploadFromClasspath("zat.jpg"); //альтернативный вариант
        $("#currentAddress").setValue("Bikini Bottom 666");
        //$(byText("Select State")).click();
        $("#state").click();
        //$(byText("Rajasthan")).click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        //$(byText("Select City")).click();
        $("#city").click();
        //$(byText("Jaiselmer")).click();
        $("#stateCity-wrapper").$(byText("Jaiselmer")).click();
        sleep(8000);
        $("#submit").click();
        sleep(8000);
        $(".modal-content").should(appear);
        $(".modal-body").shouldHave((text("Patrick")));
        sleep(5000);
        $("#closeLargeModal").click();
    }
}
