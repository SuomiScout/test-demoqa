package demoqa;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;


public class PracticeForm2 extends TestBase {


    @Test
    void fillPracticeForm() {
        String userName = "Patrick";
        String userLastName = "Star";
        String fullName = userName + " " + userLastName;
        String gender = "Other";
        String userEmail = "star666@mail.ru";
        String userNumber = "88005553535";
        String birthYear = "1961";
        String birthMonth = "March";
        String birthDay = "13";
        String birthDate = birthDay + " " + birthMonth + "," + birthYear;
        String userAddress = "Bikini Bottom 666";
        String userState = "Rajasthan";
        String userCity = "Jaiselmer";
        String userUpload = "zat.jpg";
        String userSubjects ="Arts";

        registrationPage.openPage() //Через RegistrationPage registrationPage = new RegistrationPage ();
                .setFirstName(userName)
                .setLastName(userLastName)
                .setGender (gender)
                .setUserEmail(userEmail)
                .setUserNumber(userNumber)
                .setBirthDay(birthDay,birthMonth,birthYear)
                .setSubjects (userSubjects)
                .setHobbies ()
                .setUpload (userUpload)
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .setSubmit();

        registrationPage.verifyResultsModalAppears()
                        .verifyResult("Student Name", fullName)
                        .verifyResult("Student Email", userEmail)
                        .verifyResult("Gender", gender)
                        .verifyResult("Mobile", userNumber)
                        .verifyResult("Date of Birth",  birthDate)
                        .verifyResult("Subjects", "Arts")
                        .verifyResult("Hobbies", "Sports")
                        .verifyResult("Picture", "images/zat.jpg")
                        .verifyResult("Address", userAddress)
                        .verifyResult("State and City", userState + userCity );
        registrationPage.closeModal();
    }
}
//        File cv = new File("src/test/resources/zat.jpg");
//        $("#uploadPicture").uploadFile(cv);
//$("#uploadPicture").uploadFile(new File("src/test/resources/zat.jpg")); //альтернативный вариант
//$("#uploadPicture").uploadFromClasspath("zat.jpg"); //альтернативный вариант