package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponents;
import pages.components.ResultTableComponents;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    public final SelenideElement firstNameInput = $("#firstName");
    public final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement numberInput = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement userPicture = $("#uploadPicture");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement stateCityWrapper = $("#stateCity-wrapper");
    private final SelenideElement submitButton = $("#submit");

    CalendarComponents calendarComponents = new CalendarComponents();
    ResultTableComponents resultTableComponents = new ResultTableComponents();

    @Step("Закрытие баннеров")
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Открыть страницу регистрации")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    @Step("Ввести имя")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Ввести фамилию")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Ввести электронную почту")
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Выбрать пол")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Ввести номер телефона")
    public RegistrationPage setUserNumber(String value) {
        numberInput.setValue(value);
        return this;
    }

    @Step("Выбрать дату рождения")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponents.setDate(day, month, year);
        return this;
    }

    @Step("Выбрать предмет")
    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбрать хобби")
    public RegistrationPage setHobbies(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();
        return this;
    }

    @Step("Загрузить фотографию")
    public RegistrationPage uploadPicture(String value) {
        userPicture.uploadFromClasspath(value);
        return this;
    }

    @Step("Ввести адрес")
    public RegistrationPage setUserAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    @Step("Выбрать штат")
    public RegistrationPage setState(String value) {
        stateCityWrapper.$(byText("Select State")).click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Выбрать город")
    public RegistrationPage setCity(String value) {
        stateCityWrapper.$(byText("Select City")).click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Кликнуть отправить")
    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }

    @Step("Проверка результатов")
    public RegistrationPage checkResult(String key, String value) {
        resultTableComponents.checkResultsTableNotVisible(key, value);
        return this;
    }

    @Step("Проверка красного бордера")
    public RegistrationPage checkRedFirstName() {
        firstNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    @Step("Проверка красного бордера")
    public RegistrationPage checkRedLastName() {
        lastNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    @Step("Проверка красного бордера")
    public RegistrationPage checkRedMobile() {
        numberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;

    }
}