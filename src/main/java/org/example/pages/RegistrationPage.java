package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class RegistrationPage {

    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // поле Имя

    private By nameField = By.xpath(".//label[text()='Имя']/following-sibling::input");

    // поле Email

    private By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");

    // поле Пароль

    private By passwordField = By.xpath(".//label[text()='Пароль']/following-sibling::input");

    // кнопка Зарегистрироваться/Войти

    private By button = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    // кнопка Войти на странице регистрации/восстановления

    private By enterButton = By.cssSelector(".Auth_link__1fOlj[href='/login']");


    //текст ошибки

    private By errorText = By.xpath(".//p[@class='input__error text_type_main-default']");

    // текст Вход на странице залогина

    private By entryForm = By.xpath(".//h2[text()='Вход']");


    // открытие браузера на странице регистрации

    @Step("Открытие браузера на странице регистрации")

    public void openPageRegistration() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    // ввод имени

    public void fieldName(String name){
        driver.findElement(nameField).sendKeys(name);
    }

    // ввод email

    public void fieldEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    // ввод пароля

    public void fieldPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    // клик по кнопке Войти на странице регистрации

    @Step("Клик по кнопке Войти на странице регистрации")

    public void enterButtonClick(){
        driver.findElement(enterButton).click();
    }

    // клик по кнопке Зарегистрироваться/Войти


    public void buttonClick(){
        driver.findElement(button).click();
    }

    // Получаем актуальный текст

    public void actualErrorText() {
        String expectedText = "Некорректный пароль";
        String actualText = driver.findElement(errorText).getText();
        assertEquals(expectedText, actualText);
    }

    // Текст вход видим на странице после регистрации

    @Step("Успешная регистрация")

    public void loadingEntryForm(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(entryForm));
    }


}
