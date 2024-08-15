package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Tag("smoke")
public class RegistrationTests extends TestBase {

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("German");
        $("#lastName").setValue("Chernov");
        $("#userEmail").setValue("Germannn@mail.ru");
        $("#userNumber").setValue("9776932525");
        $("label[for='gender-radio-1']").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1985");
        $(".react-datepicker__day--011").click();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("416280252.jpg");
        $("#currentAddress").setValue("Somewhere");
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Comp").pressEnter();
        $("#state").click();
        $("#react-select-3-option-3").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();
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