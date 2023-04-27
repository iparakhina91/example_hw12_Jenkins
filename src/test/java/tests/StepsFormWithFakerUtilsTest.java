package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static tests.TestData.*;

public class StepsFormWithFakerUtilsTest extends TestBase {

    @Test
    @Feature("Filling form")
    @Story("Filling form with different types of data")
    @Owner("korovinaiyu")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Filling form with fakers data")
    void fillFormTest() {

        step("Open form ", () -> {
            registrationPage.openPage();

        });
        step("Close banners", () -> {
            registrationPage.removeBanners();
        });
        step("Fill form ", () -> {
            registrationPage.setFirstName(userFirstName)
                    .setLastName(userLastName)
                    .setEmail(userEmail)
                    .setGender(userGender)
                    .setNumber(userMobile)
                    .setBirthDate(dayOfBirthDate, monthOfBirthDate, yearOfBirthDate)
                    .setSubjects(userSubject)
                    .setHobbies(userHobbies)
                    .setPicture(pictureName)
                    .setAddress(userAddress)
                    .setState(userState)
                    .setCity(userCity)
                    .clickSubmit();
        });

        step("Verify results", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResults("Student Name", userFirstName + " " + userLastName)
                    .verifyResults("Student Email", userEmail)
                    .verifyResults("Gender", userGender)
                    .verifyResults("Mobile", userMobile)
                    .verifyResults("Date of Birth", dayOfBirthDate + " " + monthOfBirthDate + "," + yearOfBirthDate)
                    .verifyResults("Subjects", userSubject)
                    .verifyResults("Hobbies", userHobbies)
                    .verifyResults("Picture", pictureName)
                    .verifyResults("Address", userAddress)
                    .verifyResults("State and City", userState + " " + userCity);
        });
    }
}