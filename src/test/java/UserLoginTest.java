import com.github.javafaker.Faker;
import org.example.pages.MainPage;
import org.example.pages.RegistrationPage;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import steps.FormSteps;

public class UserLoginTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();


// логин по войти на главной

    @Test

    public void loginButtoninMainPageTest() throws InterruptedException {
        WebDriver driver = driverFactory.getDriver();
        Faker faker= new Faker();
        FormSteps steps = new FormSteps(driver);
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.enterButtonclick();
        steps.login(faker.internet().emailAddress(),faker.internet().password());

    }

    // логин через личный кабинет

    @Test

    public void loginPersonalAccountButtonTest() {
        WebDriver driver = driverFactory.getDriver();
        Faker faker= new Faker();
        FormSteps steps = new FormSteps(driver);
        MainPage mainPage = new MainPage(driver);

        mainPage.openPage();
        mainPage.personalAccountButtonclick();
        steps.login(faker.internet().emailAddress(),faker.internet().password());
    }

// вход через кнопку регистрации

    @Test

    public void loginInRegistrationFormTest() {
        WebDriver driver = driverFactory.getDriver();
        Faker faker= new Faker();
        FormSteps steps = new FormSteps(driver);

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.openPageRegistration();
        registrationPage.enterButtonClick();
        steps.login(faker.internet().emailAddress(),faker.internet().password());
    }

    // вход через восстановление пароля

    @Test

    public void loginInRecoveryFormTest() {
        WebDriver driver = driverFactory.getDriver();
        Faker faker= new Faker();
        FormSteps steps = new FormSteps(driver);

        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage.openPage();
        mainPage.personalAccountButtonclick();
        mainPage.recoveryButtonClick();
        registrationPage.enterButtonClick();
        steps.login(faker.internet().emailAddress(),faker.internet().password());
    }

}
