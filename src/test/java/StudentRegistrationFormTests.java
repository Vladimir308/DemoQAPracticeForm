import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTests {
    @BeforeAll
    static void beforeAll(){
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
        $("#genterWrapper").$(byText("Male")).click();
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
        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Student Name German Chernov"));
        $(".table-responsive").shouldHave(text("Student Email Germannn@mail.ru"));
        $(".table-responsive").shouldHave(text("Gender Male"));
        $(".table-responsive").shouldHave(text("Mobile 9776932525"));
        $(".table-responsive").shouldHave(text("Date of Birth 09 April,1985"));
        $(".table-responsive").shouldHave(text("Subjects Computer Science"));
        $(".table-responsive").shouldHave(text("Hobbies Reading, Music"));
        $(".table-responsive").shouldHave(text("416280252.jpg"));
        $(".table-responsive").shouldHave(text("Address Somewhere"));
        $(".table-responsive").shouldHave(text("State and City NCR Noida"));
    }
}