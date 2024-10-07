package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Tag("smoke")
public class RegistrationTests extends BaseTest {

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").scrollTo().setValue("German");
        $("#lastName").scrollTo().setValue("Chernov");
        $("#userEmail").scrollTo().setValue("Germannn@mail.ru");
        $("#userNumber").scrollTo().setValue("9776932525");
        $("label[for='gender-radio-1']").scrollTo().click();
        $("#dateOfBirthInput").scrollTo().click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1985");
        $(".react-datepicker__day--011").scrollTo().click();
        $("label[for='hobbies-checkbox-1']").scrollTo().click();
        $("#uploadPicture").uploadFromClasspath("416280252.jpg");
        $("#currentAddress").scrollTo().setValue("Somewhere");
        $("#subjectsInput").scrollTo().click();
        $("#subjectsInput").scrollTo().setValue("Comp").pressEnter();
        $("#state").scrollTo().click();
        $("#react-select-3-option-3").scrollTo().click();
        $("#city").scrollTo().click();
        $("#react-select-4-option-0").scrollTo().click();
        $("#submit").scrollTo().click();
        $(".table").shouldHave(text("Student Name German Chernov"));
        $(".table").shouldHave(text("Student Email Germannn@mail.ru"));
        $(".table").shouldHave(text("Gender Male"));
        $(".table").shouldHave(text("Mobile 9776932525"));
        $(".table").shouldHave(text("Date of Birth 11 March,1985"));
        $(".table").shouldHave(text("Subjects Comp"));
        $(".table").shouldHave(text("Hobbies Sports"));
        $(".table").shouldHave(text("Picture 416280252.jpg"));
        $(".table").shouldHave(text("Address Somewhere"));
        $(".table").shouldHave(text("State and City Rajasthan Jaipur"));
    }
}