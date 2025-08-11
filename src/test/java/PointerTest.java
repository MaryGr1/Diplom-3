import org.example.pages.ConstructorPage;
import org.example.pages.MainPage;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;


public class PointerTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();


    // переход к соусам

    @Test
    public void sauseTabIsActiveTest(){
        WebDriver driver = driverFactory.getDriver();
        ConstructorPage constructorPage = new ConstructorPage(driver);

        MainPage mainPage = new MainPage(driver);

        mainPage.openPage();
        constructorPage.sausePointerCkick();
        assertTrue("Секция 'Соусы' не отображается", constructorPage.sauseSectionIsDisplayed());
    }

    // переход к начинкам
    @Test
    public void fillingTabIsActiveTest(){
        WebDriver driver = driverFactory.getDriver();
        ConstructorPage constructorPage = new ConstructorPage(driver);

        MainPage mainPage = new MainPage(driver);

        mainPage.openPage();
        constructorPage.fillingPointerCkick();
        assertTrue("Секция 'Начинки' не отображается",constructorPage.fillingSectionIsDisplayed());
    }

    // переход к булкам
    @Test
    public void bunsTabIsActiveTest(){
        WebDriver driver = driverFactory.getDriver();
        ConstructorPage constructorPage = new ConstructorPage(driver);

        MainPage mainPage = new MainPage(driver);

        mainPage.openPage();
        constructorPage.sausePointerCkick();
        constructorPage.bunsPointerCkick();
        assertTrue("Секция 'Булки' не отображается", constructorPage.bunsSectionIsDisplayed());
    }



}
