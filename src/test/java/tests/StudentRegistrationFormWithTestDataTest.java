package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class StudentRegistrationFormWithTestDataTest {
//    static String firstName,
//            lastName,
//            userEmail;


    @BeforeAll
    static void setUpConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
       // Configuration.holdBrowserOpen = true;
    }

//    @BeforeEach                      ВАРИАНТ НЕ ИДЕАЛЬНЫЙ, НО ИМЕЕТ МЕСТО БЫТЬ
//    void preparedTestData(){
//        firstName = "Alex";
//        lastName = "Saegn";
//        userEmail = "alex@gmail.com";
//    }

    @Test
    void successfulFilFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        $("#firstName").setValue(firstName);
        $("#userEmail").setValue(userEmail);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("7846586867");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July"); //best
            //$(".react-datepicker__month-select").selectOptionByValue("6");
            //$(".react-datepicker__month-select").$(byText("July")).click();
        $(".react-datepicker__year-select").selectOption("1988"); //best
            //$(".react-datepicker__year-select").$(byText("1980")).click();
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
            //$(".react-datepicker__day--026").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("example.jpeg"); //отработает только если type = file
        $("#currentAddress").setValue("11250 E STATE ROUTE 69 DEWEY AZ 86327-4422 USA");
        $("#react-select-3-input").setValue("NCR").pressEnter();
//        // $("#city").click();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
//        $("#submit").click();

        //Проверка результата заполнения формы

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table").shouldHave(text(firstName));
        $(".table").shouldHave(text(userEmail));
        $(".table").shouldHave(text(lastName));
        $(".table").shouldHave(text("Female"));
        $(".table").shouldHave(text("7846586867"));
        $(".table").shouldHave(text("26 July,1980"));
        $(".table").shouldHave(text("English"));
        $(".table").shouldHave(text("Sports"));
        $(".table").shouldHave(text("example.jpeg"));
        $(".table").shouldHave(text("11250 E STATE ROUTE 69 DEWEY AZ 86327-4422 USA"));
        $(".table").shouldHave(text("NCR Delhi"));
    }

    @AfterEach
    void terminateProcess() {
        closeWindow();
    }
}
