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
        String className = constructorPage.getClassSaucesSection();
        assertTrue("Раздел 'Соусы' не отображается", className.contains("tab_tab_type_current__2BEPc"));
    }

    // переход к начинкам
    @Test
    public void fillingTabIsActiveTest(){
        WebDriver driver = driverFactory.getDriver();
        ConstructorPage constructorPage = new ConstructorPage(driver);

        MainPage mainPage = new MainPage(driver);

        mainPage.openPage();
        constructorPage.fillingPointerCkick();
        String className = constructorPage.getClassFillingsSection();
        assertTrue("Раздел 'Начинки' не отображается", className.contains("tab_tab_type_current__2BEPc"));
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
        String className = constructorPage.getClassBunsSection();
        assertTrue("Раздел 'Булки' не отображается", className.contains("tab_tab_type_current__2BEPc"));
    }


}
