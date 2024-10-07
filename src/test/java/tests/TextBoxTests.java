package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("production")
public class TextBoxTests extends TestBase {

    @Test
    void fillFormTest() {

        textBoxPage.openPage()
                .setUserName("char")
                .setUserEmail("char@man.com")
                .setCurrentAddress("Somewhere")
                .setPermanentAddress("Some other address")
                .submit()
                .checkResult("name", "char")
                .checkResult("email", "char@man.com")
                .checkResult("currentAddress", "Somewhere")
                .checkResult("permanentAddress", "Some other address");
    }
}
