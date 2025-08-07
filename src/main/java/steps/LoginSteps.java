package steps;

import io.qameta.allure.Step;
import org.example.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private final WebDriver driver;
    private final RegistrationPage registrationPage;

    public LoginSteps(WebDriver driver) {
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
