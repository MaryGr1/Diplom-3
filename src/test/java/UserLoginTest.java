import com.github.javafaker.Faker;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.pages.MainPage;
import org.example.pages.RegistrationPage;
import org.example.pages.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import steps.LoginSteps;
import steps.UserSteps;

public class UserLoginTest extends BaseTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();
    private User user;
    UserSteps userSteps;
    String accessToken;


    @Before

    public void setUp(){
        super.setUp();
        Faker faker = new Faker();
        user = new User();
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(RandomStringUtils.randomAlphabetic(12));
        user.setName(RandomStringUtils.randomAlphabetic(12));
        userSteps = new UserSteps(reqSpec);
        ValidatableResponse response = userSteps
                .createUser(user);
        accessToken = response.extract().path("accessToken");
    }


// логин по войти на главной

    @Test

    public void loginButtoninMainPageTest() throws InterruptedException {
        WebDriver driver = driverFactory.getDriver();
        LoginSteps steps = new LoginSteps(driver);
        MainPage mainPage = new MainPage(driver);

        mainPage.openPage();
        mainPage.enterButtonclick();

        steps.login(user.getEmail(),user.getPassword());
        mainPage.clickableButton();

    }

    // логин через личный кабинет

    @Test

    public void loginPersonalAccountButtonTest() {
        WebDriver driver = driverFactory.getDriver();
        LoginSteps steps = new LoginSteps(driver);
        MainPage mainPage = new MainPage(driver);

        mainPage.openPage();
        mainPage.personalAccountButtonclick();
        steps.login(user.getEmail(),user.getPassword());
        mainPage.clickableButton();
    }

// вход через кнопку регистрации

    @Test

    public void loginInRegistrationFormTest() {
        WebDriver driver = driverFactory.getDriver();
        LoginSteps steps = new LoginSteps(driver);
        MainPage mainPage = new MainPage(driver);

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openPageRegistration();
        registrationPage.enterButtonClick();
        steps.login(user.getEmail(),user.getPassword());
        mainPage.clickableButton();
    }

    // вход через восстановление пароля

    @Test

    public void loginInRecoveryFormTest() {
        WebDriver driver = driverFactory.getDriver();
        LoginSteps steps = new LoginSteps(driver);
        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.openPage();
        mainPage.personalAccountButtonclick();
        mainPage.recoveryButtonClick();
        registrationPage.enterButtonClick();
        steps.login(user.getEmail(),user.getPassword());
        mainPage.clickableButton();
    }


    @After
    public void deleteUser() {
        if(accessToken != null) {
            userSteps.deleteUser(accessToken);
        }
    }

}
