package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.Users;

@Tag("regression")
public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    Users user = new Users();

    @Test
    void fillAllFieldsTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(user.firstName)
                .setLastName(user.lastName)
                .setEmail(user.email)
                .setGender(user.gender)
                .setUserNumber(user.phoneNumber)
                .setDateOfBirth(user.dayOfBDay, user.monthOfBDay, user.yearOfBDay)
                .setSubject(user.subject)
                .setHobbies(user.hobby)
                .uploadPicture(user.picturePath)
                .setUserAddress(user.address)
                .setState(user.state)
                .setCity(user.city)
                .submit()
                .checkResult("Student Name", (user.firstName + " " + user.lastName))
                .checkResult("Student Email", user.email)
                .checkResult("Gender", user.gender)
                .checkResult("Mobile", user.phoneNumber)
                .checkResult("Date of Birth", user.dayOfBDay + " " + user.monthOfBDay + "," + user.yearOfBDay)
                .checkResult("Subjects", user.subject)
                .checkResult("Hobbies", user.hobby)
                .checkResult("Picture", user.picturePath)
                .checkResult("Address", user.address)
                .checkResult("State and City", user.state + " " + user.city);
    }

    @Test
    void fillRequiredFildsTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(user.firstName)
                .setLastName(user.lastName)
                .setEmail(user.email)
                .setGender(user.gender)
                .setUserNumber(user.phoneNumber)
                .setDateOfBirth(user.dayOfBDay, user.monthOfBDay, user.yearOfBDay)
                .submit()
                .checkResult("Student Name", user.firstName + " " + user.lastName)
                .checkResult("Student Email", user.email)
                .checkResult("Gender", user.gender)
                .checkResult("Mobile", user.phoneNumber)
                .checkResult("Date of Birth", user.dayOfBDay + " " + user.monthOfBDay + "," + user.yearOfBDay)
                .checkResult("Subjects", " ")
                .checkResult("Hobbies", " ")
                .checkResult("Picture", " ")
                .checkResult("Address", " ")
                .checkResult("State and City", " ");
    }

    @Test
    void clickSubmitWithEmptyFields() {
        registrationPage.openPage()
                .removeBanner()
                .submit()
                .checkRedFirstName()
                .checkRedLastName()
                .checkRedMobile();
    }

}