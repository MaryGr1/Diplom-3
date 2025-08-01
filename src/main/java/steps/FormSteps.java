package steps;

import io.qameta.allure.Step;
import org.example.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;

public class FormSteps {
    private final WebDriver driver;
    private final RegistrationPage registrationPage;

    public FormSteps(WebDriver driver) {
        this.driver = driver;
        this.registrationPage = new RegistrationPage(driver);
    }

    @Step("Вход в личный кабинет")

    public void login(String email, String password)
    {
        registrationPage.fieldEmail(email);
        registrationPage.fieldPassword(password);
        registrationPage.buttonClick();
    }
}
