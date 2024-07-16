package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailNameInput = $("#userEmail"),
            numberInput = $("#userNumber");

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

    public RegistrationPage setUserEmail (String value) {
        emailNameInput.setValue(value);
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





}
