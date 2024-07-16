package demoqa;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


public class PracticeForm2 extends TestBase {


    @Test
    void fillPracticeForm() {
        String userName = "Patrick";
        registrationPage.openPage() //Через RegistrationPage registrationPage = new RegistrationPage ();
                .setFirstName(userName)
                .setLastName("Star")
                .setUserEmail("star666@mail.ru")
                .setUserNumber("88005553535")
                .setBirthDay("13","March","1961");

        sleep(8000);
        $("#gender-radio-2").ancestor("div").click();

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
