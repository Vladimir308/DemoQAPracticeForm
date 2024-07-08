import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void SuccessfulRegistrationTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("German");
        $("#lastName").setValue("Chernov");
        $("#userEmail").setValue("Germannn@mail.ru");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("9776932525");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("3");
        $(".react-datepicker__year-select").selectOptionByValue("1985");
        $(".react-datepicker__day--009").click();
        $("#subjectsInput").setValue("comp").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("416280252.jpg");
        $("#currentAddress").setValue("Somewhere");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-2").click();
        $("#submit").click();

        $(".table").shouldHave(text("Student Name German Chernov"));
        $(".table").shouldHave(text("Student Email Germannn@mail.ru"));
        $(".table").shouldHave(text("Gender Male"));
        $(".table").shouldHave(text("Mobile 9776932525"));
        $(".table").shouldHave(text("Date of Birth 09 April,1985"));
        $(".table").shouldHave(text("Subjects Computer Science"));
        $(".table").shouldHave(text("Hobbies Reading, Music"));
        $(".table").shouldHave(text("416280252.jpg"));
        $(".table").shouldHave(text("Address Somewhere"));
        $(".table").shouldHave(text("State and City NCR Noida"));
    }
}