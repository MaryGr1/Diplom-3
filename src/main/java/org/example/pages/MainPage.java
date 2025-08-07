package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

   private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // кнопка Войти на главной

    private By enterButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");

    // кнопка Личный кабинет

    private By personalAccountButton = By.cssSelector(".AppHeader_header__link__3D_hX[href='/account']");

    // кнопка Войти на странице восстановления пароля

    private By recoveryButton = By.cssSelector(".Auth_link__1fOlj[href='/forgot-password']");

    // открытие браузера

    @Step("Открытие браузера на главной странице")

    public void openPage() {
        driver.get("https://stellarburgers.nomoreparties.site");
    }

    // клик по Войти на главной

    @Step("Клик по кнопке Войти на главной")

    public void enterButtonclick(){
        driver.findElement(enterButton).click();
    }

    // клик по кнопке Личный кабинет

    @Step("Клик по кнопке Личный кабинет")

    public void personalAccountButtonclick(){
        driver.findElement(personalAccountButton).click();
    }

    // клик по кнопке восстановления

    @Step("Клик по кнопке восстановления пароля")

    public void recoveryButtonClick(){
        driver.findElement(recoveryButton).click();
    }

    // кликабельность кнопки личный кабинет после логина

    @Step("Успешный залогин")

    public void clickableButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(personalAccountButton));
    }
}
