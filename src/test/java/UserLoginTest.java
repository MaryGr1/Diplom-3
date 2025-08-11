import com.github.javafaker.Faker;
import org.example.pages.MainPage;
import org.example.pages.RegistrationPage;
import org.example.pages.User;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import steps.LoginSteps;
import steps.RegistrationSteps;
import steps.UserSteps;

public class UserLoginTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();


// логин по войти на главной

    @Test

    public void loginButtoninMainPageTest() throws InterruptedException {
        WebDriver driver = driverFactory.getDriver();
        Faker faker= new Faker();
        LoginSteps steps = new LoginSteps(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        RegistrationSteps registr = new RegistrationSteps(driver);
        MainPage mainPage = new MainPage(driver);
        registrationPage.openPageRegistration();
        registr.registration(faker.name().fullName(), faker.internet().emailAddress(),faker.internet().password());
        mainPage.openPage();
        mainPage.enterButtonclick();

        steps.login(faker.internet().emailAddress(),faker.internet().password());
        mainPage.clickableButton();

    }

    // логин через личный кабинет

    @Test

    public void loginPersonalAccountButtonTest() {
        WebDriver driver = driverFactory.getDriver();
        Faker faker= new Faker();
        LoginSteps steps = new LoginSteps(driver);
        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        RegistrationSteps registr = new RegistrationSteps(driver);
        registrationPage.openPageRegistration();
        registr.registration(faker.name().fullName(), faker.internet().emailAddress(),faker.internet().password());
        mainPage.openPage();
        mainPage.personalAccountButtonclick();
        steps.login(faker.internet().emailAddress(),faker.internet().password());
        mainPage.clickableButton();
    }

// вход через кнопку регистрации

    @Test

    public void loginInRegistrationFormTest() {
        WebDriver driver = driverFactory.getDriver();
        Faker faker= new Faker();
        LoginSteps steps = new LoginSteps(driver);
        MainPage mainPage = new MainPage(driver);
        RegistrationSteps registr = new RegistrationSteps(driver);

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openPageRegistration();
        registr.registration(faker.name().fullName(), faker.internet().emailAddress(),faker.internet().password());
        registrationPage.openPageRegistration();
        registrationPage.enterButtonClick();
        steps.login(faker.internet().emailAddress(),faker.internet().password());
        mainPage.clickableButton();
    }

    // вход через восстановление пароля

    @Test

    public void loginInRecoveryFormTest() {
        WebDriver driver = driverFactory.getDriver();
        Faker faker= new Faker();
        LoginSteps steps = new LoginSteps(driver);
        RegistrationSteps registr = new RegistrationSteps(driver);
        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openPageRegistration();
        registr.registration(faker.name().fullName(), faker.internet().emailAddress(),faker.internet().password());
        mainPage.openPage();
        mainPage.personalAccountButtonclick();
        mainPage.recoveryButtonClick();
        registrationPage.enterButtonClick();
        steps.login(faker.internet().emailAddress(),faker.internet().password());
        mainPage.clickableButton();
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
