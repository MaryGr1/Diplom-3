import com.github.javafaker.Faker;
import org.example.pages.RegistrationPage;
import org.example.pages.User;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import steps.RegistrationSteps;
import steps.UserSteps;

import static org.junit.Assert.assertEquals;

public class UserRegisterTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    // успешная регистрация

    @Test

    public void registerUserTest() throws InterruptedException {
        WebDriver driver = driverFactory.getDriver();
        Faker faker= new Faker();
        RegistrationSteps step = new RegistrationSteps(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openPageRegistration();
        step.registration(faker.name().fullName(), faker.internet().emailAddress(),faker.internet().password());
        registrationPage.loadingEntryForm();
        assertEquals(driver.getCurrentUrl(), "https://stellarburgers.nomoreparties.site/login");
    }

    // проверка ошибки
    @Test

    public void errorPasswordTest() throws InterruptedException {
        WebDriver driver = driverFactory.getDriver();
        Faker faker= new Faker();
        RegistrationSteps step = new RegistrationSteps(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openPageRegistration();
        step.registration(faker.internet().emailAddress(),faker.internet().password(), "12345");
       registrationPage.actualErrorText();


    }

    @After
    public void deleteUser() {
        UserSteps userSteps = new UserSteps();
        User user = new User();
        try {
            userSteps.userDeleteAfterLogin(user);
        } catch (Exception e) {
            System.err.println("Ошибка при удалении пользователя: " + e.getMessage());
        }
    }


}
