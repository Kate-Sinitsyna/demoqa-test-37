package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.component.CalendarComponent;
import pages.component.CheckResult;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            genterWrapper = $("#genterWrapper"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput =  $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            picture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateWrapper = $("#react-select-3-input"),
            cityWrapper =  $("#react-select-4-input"),
            submitButton= $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }
    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setUserEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }
    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);

        return this;
    }
    public RegistrationPage setGender(String value){
        genterWrapper.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String mounth, String year){
        calendarInput.click();
        calendarComponent.setDate(day, mounth, year);

        return this;
    }
    public RegistrationPage setSubjects(String value){
        subjectsInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage setHobbies(String value){
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }
    public RegistrationPage uploadPicture(String value){
        picture.uploadFromClasspath(value);

        return this;
    }
    public RegistrationPage setCurrentAddress(String value){
        currentAddress.setValue(value);

        return this;
    }
    public RegistrationPage setState(String value){
        stateWrapper.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage setCity(String value){
        cityWrapper.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage submitForm(){
        submitButton.click();

        return this;
    }

    public RegistrationPage checkResult(String key, String value){
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));

        return this;
    }
}
