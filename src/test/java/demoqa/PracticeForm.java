package demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
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
        $("#firstName").setValue("Patrick");
        $("#userEmail").setValue("star666@mail.ru");
        $("#lastName").setValue("Star");
        $("#gender-radio-2").ancestor("div").click();
        sleep(5000);
        $("#gender-radio-3").ancestor("div").click();
        sleep(5000);
        $("#userNumber").setValue("88005553535");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("March")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1961")).click();
        $(byText("13")).click();
        sleep(5000);
        //$("#subjectsInput").setValue("Один из самых главных персонажей «Губка Боб Квадратные Штаны»");
        $("#hobbies-checkbox-1").ancestor("div").click();
        File cv = new File("src/test/resources/zat.jpg");
        $("#uploadPicture").uploadFile(cv);
        $("#currentAddress").setValue("Bikini Bottom 666");
        $(byText("Select State")).click();
        $(byText("Rajasthan")).click();
        $(byText("Select City")).click();
        $(byText("Jaiselmer")).click();
        sleep(8000);
        $("#submit").click();
        sleep(8000);
        $(".modal-content").shouldBe(visible);
        $(".modal-body").shouldHave((text("Patrick")));
        sleep(5000);
        $("#closeLargeModal").click();
    }
}
