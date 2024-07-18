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
        String userLastName = "Star";
        String gender = "Other";
        String userEmail = "star666@mail.ru";
        String userNumber = "88005553535";
        //String userBirthday = "13","March","1961";
        String userAddress = "Bikini Bottom 666";
        String userState = "Rajasthan";
        String userCity = "Jaiselmer";

        registrationPage.openPage() //Через RegistrationPage registrationPage = new RegistrationPage ();
                .setFirstName(userName)
                .setLastName(userLastName)
                .setGender (gender)
                .setUserEmail(userEmail)
                .setUserNumber(userNumber)
                .setBirthDay("13","March","1961")
                .setSubjects ()
                .setHobbies ()
                .setUpload ()
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .setSubmit();

        registrationPage.verifyResultsModalAppears()
                        .verifyResult("Student Name", "Patrick Star") //userName +
                        .verifyResult("Student Email", "star666@mail.ru")
                        .verifyResult("Gender", "Other")
                        .verifyResult("Mobile", "8800555353")
                        .verifyResult("Date of Birth",  "13 March,1961")
                        .verifyResult("Subjects", "Arts")
                        .verifyResult("Hobbies", "Sports")
                        .verifyResult("Picture",  "zat.jpg")
                        .verifyResult("Address", "Bikini Bottom 666")
                        .verifyResult("State and City", "Rajasthan Jaiselmer");
        registrationPage.closeModal();
    }
}
//        File cv = new File("src/test/resources/zat.jpg");
//        $("#uploadPicture").uploadFile(cv);
//$("#uploadPicture").uploadFile(new File("src/test/resources/zat.jpg")); //альтернативный вариант
//$("#uploadPicture").uploadFromClasspath("zat.jpg"); //альтернативный вариант