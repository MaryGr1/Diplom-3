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

    private By saucesSection = By.xpath("//span[text()='Соусы']");

    // раздел Начинки заголовок

    private By fillingSection = By.xpath("//span[text()='Начинки']");

    // раздел Булки заголовок

    private By bunsSection = By.xpath("//span[text()='Булки']");


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


    @Step("Получение class когда выбран раздел Булки")
    public String getClassBunsSection() {
        return driver.findElement(bunsPointer).getAttribute("class");
    }

    @Step("Получение class когда выбран раздел Соусы")
    public String getClassSaucesSection() {
        return driver.findElement(saucePointer).getAttribute("class");
    }

    @Step("Получение class когда выбран раздел Начинки")
    public String getClassFillingsSection() {
        return driver.findElement(fillingPointer).getAttribute("class");
    }

}
