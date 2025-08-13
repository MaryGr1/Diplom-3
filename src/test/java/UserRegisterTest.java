import com.github.javafaker.Faker;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.pages.RegistrationPage;
import org.example.pages.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import steps.RegistrationSteps;
import steps.UserSteps;

import static org.junit.Assert.assertEquals;

public class UserRegisterTest extends BaseTest{

    @Rule
    public DriverFactory driverFactory = new DriverFactory();
    UserSteps userSteps;
    String accessToken;
    private User user;

    @Before

    public void setUp(){
        super.setUp();
        Faker faker = new Faker();
        user = new User();
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(RandomStringUtils.randomAlphabetic(12));
        user.setName(RandomStringUtils.randomAlphabetic(12));
        userSteps = new UserSteps(reqSpec);
    }

    // успешная регистрация

    @Test

    public void registerUserTest() throws InterruptedException {
        WebDriver driver = driverFactory.getDriver();
        RegistrationSteps step = new RegistrationSteps(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openPageRegistration();
        step.registration(user.getName(), user.getEmail(), user.getPassword());
        registrationPage.loadingEntryForm();
        ValidatableResponse response = userSteps.createUser(user);
        accessToken = response.extract().path("accessToken");
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

        if(accessToken != null) {
            userSteps.deleteUser(accessToken);
        }
    }


}
