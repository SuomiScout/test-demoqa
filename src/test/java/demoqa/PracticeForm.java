package demoqa;


import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class PracticeForm extends TestBase {


    @Test
    void fillPracticeForm() {
        String userName = "Patrick";
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        Selenide.executeJavaScript("$('.sidebar-content').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Patrick");
        $("#userEmail").setValue("star666@mail.ru");
        $("#lastName").setValue("Star");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");//другой вариант
        //$(byText("March")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1961")).click();
        $(byText("13")).click();
        registrationPage.openPage() //Через RegistrationPage registrationPage = new RegistrationPage ();
                .setFirstName(userName)
                .setLastName("Star");
        new RegistrationPage().setUserEmail("star666@mail.ru"); //Оставлю одну через registrationPage new RegistrationPage()

        $("#gender-radio-2").ancestor("div").click();
        sleep(5000);
        $("#userNumber").setValue("88005553535");

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
