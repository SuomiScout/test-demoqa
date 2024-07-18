package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailNameInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            genderInput = $("#genterWrapper"),
            addressInput = $("#currentAddress"),
            stateInput = $("#stateCity-wrapper"),
            submitInput = $("#submit"),
            modalClose = $("#closeLargeModal");

    public RegistrationPage openPage () {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        Selenide.executeJavaScript("$('.sidebar-content').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName (String value) {
        firstNameInput.setValue(value);
        return this; //Через RegistrationPage registrationPage = new RegistrationPage ();
    }

    public RegistrationPage setLastName (String value) {
        lastNameInput.setValue(value);
        return this; //Через RegistrationPage registrationPage = new RegistrationPage ();
    }
    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserEmail (String value) {
        emailNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setSubjects () {
        $("#subjectsInput").setValue("Arts").pressEnter();
        return this;
    }

    public RegistrationPage setHobbies () {
        $("#hobbies-checkbox-1").ancestor("div").click();
        return this;
    }
    public RegistrationPage setUpload () {
        $("#uploadPicture").uploadFromClasspath("zat.jpg");
        return this;
    }

    public RegistrationPage setAddress (String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserNumber (String value) {
        numberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDay (String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        //calendarComponent.setDate (day, month, year);
        return this;
    }
    public RegistrationPage setState(String value) {
        $("#state").click();
        stateInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity(String value) {
        $("#city").click();
        stateInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setSubmit () {
        submitInput.click();
        return this;
    }
    public RegistrationPage verifyResultsModalAppears () {
        registrationResultsModal.verifyModalAppears();
        return this;
    }
    public RegistrationPage verifyResult(String key,String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }

    public RegistrationPage closeModal () {
        modalClose.click();
        return this;
    }





}
