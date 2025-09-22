import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.component.CheckResult;
import tests.TestBase;
import tests.TestData;

import static java.lang.String.format;

public class StudentRegistrationFormWithPageObjectsTests1 extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CheckResult modalWindow = new CheckResult();
    TestData testData = new TestData();

    @Test
    void successfulFilFormTest() {
        registrationPage.openPage();
        registrationPage.deleteAds();

        registrationPage.setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.email)
                .setUserNumber(testData.userNumber)
                .setGender(testData.gender)
                .setDateOfBirth(testData.day,testData.month, testData.year)
                .setSubjects(testData.subject)
                .setHobbies(testData.hobbies)
                .uploadPicture(testData.picture)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .submitForm();

        modalWindow.checkFormAppears()
                    .checkResult("Student Name",testData.firstName + ' '+ testData.lastName)
                    .checkResult("Student Email",testData.email)
                    .checkResult("Gender",testData.gender)
                    .checkResult("Mobile",testData.userNumber)
                    .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                    .checkResult("Subjects",testData.subject)
                    .checkResult("Hobbies",testData.hobbies)
                    .checkResult("Picture",testData.picture)
                    .checkResult("Address",testData.currentAddress)
                    .checkResult("State and City",testData.state + " " + testData.city);
    }
    @Test
    void successfulFillFormOnlyRequiredFieldsTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserNumber(testData.userNumber)
                .setGender(testData.gender)
                .submitForm();

        modalWindow.checkFormAppears()
                .checkResult("Student Name",testData.firstName + ' '+ testData.lastName)
                .checkResult("Gender",testData.gender)
                .checkResult("Mobile",testData.userNumber);
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
                .setUserNumber(testData.userNumber)
                .setGender(testData.gender)
                .submitForm();

        modalWindow.checkFormNotAppears();
    }
    @Test
    void negativeFillFormUserNumberFieldTest() {
        registrationPage.openPage()
                .deleteAds()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserNumber(" ")
                .setGender(testData.gender)
                .submitForm();

        modalWindow.checkFormNotAppears();
    }
}

