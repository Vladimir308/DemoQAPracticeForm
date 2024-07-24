package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("char");
        $("#userEmail").setValue("char@man.com");
        $("#currentAddress").setValue("Somewhere");
        $("#permanentAddress").setValue("Some other address");
        $("#submit").click();

        $("#name").shouldHave(text("char"));
        $("#email").shouldHave(text("char@man.com"));
        $("p[id='currentAddress']").shouldHave(text("Somewhere"));
        $("#output #currentAddress").shouldHave(text("Somewhere"));
        $("p[id='permanentAddress']").shouldHave(text("Some other address"));
        $("#output #permanentAddress").shouldHave(text("Some other address"));
    }
}