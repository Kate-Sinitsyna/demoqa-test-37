import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.component.CheckResult;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CheckResult modalWindow = new CheckResult();

    @Test
    void successfulFilFormTest() {
        registrationPage.openPage();
        registrationPage.deleteAds();

        registrationPage.setFirstName("Alex")
                .setLastName("Saegn")
                .setUserEmail("alex@gmail.com")
                .setUserNumber("7846586867")
                .setGender("Male")
                .setDateOfBirth("01","July", "2009")
                .setSubjects("English")
                .setHobbies("Sports")
                .uploadPicture("example.jpeg")
                .setCurrentAddress("11250 E STATE ROUTE 69 DEWEY AZ 86327-4422 USA")
                .setState("NCR")
                .setCity("Delhi")
                .submitForm();

        modalWindow.checkFormAppears()
                    .checkResult("Student Name","Alex Saegn")
                    .checkResult("Student Email","alex@gmail.com")
                    .checkResult("Gender","Male")
                    .checkResult("Mobile","7846586867")
                    .checkResult("Date of Birth","01 July,2009")
                    .checkResult("Subjects","English")
                    .checkResult("Hobbies","Sports")
                    .checkResult("Picture","example.jpeg")
                    .checkResult("Address","11250 E STATE ROUTE 69 DEWEY AZ 86327-4422 USA")
                    .checkResult("State and City","NCR Delhi");
    }
    @Test
    void successfulFillFormOnlyRequiredFieldsTest() {
        registrationPage.openPage()
                .setFirstName("Kitty")
                .setLastName("Duumol")
                .setUserNumber("0001112222")
                .setGender("Female")
                .submitForm();

        modalWindow.checkFormAppears()
                .checkResult("Student Name","Kitty Duumol")
                .checkResult("Gender","Female")
                .checkResult("Mobile","0001112222");
    }
    @Test
    void negativeEmptyFormTest() {
        registrationPage.openPage()
                .deleteAds()
                .submitForm();

        modalWindow.checkFormNotAppears();
    }
    @Test
    void negativeFillFormNameFieldsTest() {
        registrationPage.openPage()
                .deleteAds()
                .setFirstName(" ")
                .setLastName(" ")
                .setUserNumber("0001112222")
                .setGender("Male")
                .submitForm();

        modalWindow.checkFormNotAppears();
    }
    @Test
    void negativeFillFormUserNumberFieldTest() {
        registrationPage.openPage()
                .deleteAds()
                .setFirstName("Peter")
                .setLastName("Koch")
                .setUserNumber(" ")
                .setGender("Male")
                .submitForm();

        modalWindow.checkFormNotAppears();
    }
}

