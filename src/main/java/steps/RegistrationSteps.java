package steps;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.example.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;


public class RegistrationSteps {
    private final WebDriver driver;
    private final RegistrationPage registrationPage;

    public RegistrationSteps(WebDriver driver) {
        this.driver = driver;
        this.registrationPage = new RegistrationPage(driver);
    }

        @Step("Регистрация в ЛК")

                public void registration(String name, String email, String password){
            registrationPage.fieldName(name);
            registrationPage.fieldEmail(email);
            registrationPage.fieldPassword(password);
            registrationPage.buttonClick();
        }
}
