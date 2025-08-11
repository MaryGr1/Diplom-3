package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class ConstructorPage {

    private final WebDriver driver;

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    // Булки кнопка

    private By bunsPointer = By.xpath("//span[text()='Булки']/parent::div");

    // Соусы кнопка

    private By saucePointer = By.xpath("//span[text()='Соусы']/parent::div");

    // Начинки кнопка

    private By fillingPointer = By.xpath("//span[text()='Начинки']/parent::div");

    // раздел Соусы заголовок

    private By saucesSection = By.xpath("//h2[text()='Соусы']");

    // раздел Начинки заголовок

    private By fillingSection = By.xpath("//h2[text()='Начинки']");

    // раздел Булки заголовок

    private By bunsSection = By.xpath("//h2[text()='Булки']");


    // клик по кнопке Булки

    @Step("Клик по кнопке Булки")

    public void bunsPointerCkick() {
        driver.findElement(bunsPointer).click();
    }

    @Step("Клик по кнопке Соусы")

    public void sausePointerCkick() {
        driver.findElement(saucePointer).click();
    }

    @Step("Клик по кнопке Начинки")

    public void fillingPointerCkick() {
        driver.findElement(fillingPointer).click();
    }

    @Step("Видимость раздела Соусы")

    public boolean sauseSectionIsDisplayed(){
       return driver.findElement(saucesSection).isDisplayed();
    }

    @Step("Видимость раздела Начинки")

    public boolean fillingSectionIsDisplayed(){
        return driver.findElement(fillingSection).isDisplayed();
    }

    @Step("Видимость раздела Булки")

    public boolean bunsSectionIsDisplayed(){
        return driver.findElement(bunsSection).isDisplayed();
    }

}
