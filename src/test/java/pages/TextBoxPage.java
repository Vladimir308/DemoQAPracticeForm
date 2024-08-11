package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    private final SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputTable = $("#output");


    @Step("Открыть страницу регистрации")
    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }
    @Step("Ввести имя")
    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }
    @Step("Ввести электронную почту")
    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    @Step("Ввести адрес")
    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }
    @Step("Ввести адрес")
    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }
    @Step("Кликнуть отправить")
    public TextBoxPage submit() {
        submitButton.click();

        return this;
    }
    @Step("Проверка результатов")
    public TextBoxPage checkResult(String key, String value) {
        outputTable.$(By.id(key)).shouldHave(text(value));

        return this;
    }


}