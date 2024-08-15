package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

@Tag("development")
public class RegistrationPageTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillAllFieldsTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("German")
                .setLastName("Chernov")
                .setEmail("Germannn@mail.ru")
                .setGender("Male")
                .setUserNumber("9776932525")
                .setDateOfBirth("11", "March", "1985")
                .setSubject("Comp")
                .setHobbies("Reading")
                .uploadPicture("416280252.jpg")
                .setUserAddress("Somewhere")
                .setState("NCR")
                .setCity("Noida")
                .submit()
                .checkResult("Student Name", "German")
                .checkResult("Student Email", "Germannn@mail.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9776932525")
                .checkResult("Date of Birth", "11 March,1985")
                .checkResult("Subjects", "Comp")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "416280252.jpg")
                .checkResult("Address", "Somewhere")
                .checkResult("State and City", "NCR Noida");
    }

    @Test
    void fillRequiredFildsTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Student")
                .setLastName("Studentov")
                .setEmail("Student@mail.com")
                .setGender("Male")
                .setUserNumber("8252652266")
                .setDateOfBirth("15", "May", "1986")
                .submit()
                .checkResult("Student Name", "Student Studentov")
                .checkResult("Student Email", "Student@mail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8252652266")
                .checkResult("Date of Birth", "15 May,1986")
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