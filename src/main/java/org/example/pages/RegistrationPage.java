package org.example.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private final WebDriver driver;
    Faker faker = new Faker();

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

    private By errorText = By.cssSelector(".input__error .text_type_main-default");


    // открытие браузера на странице регистрации

    public void openPageRegistration() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    // ввод имени

    public void fieldName(){
        driver.findElement(nameField).sendKeys(faker.name().fullName());
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

    public void enterButtonClick(){
        driver.findElement(enterButton).click();
    }

    // клик по кнопке

    public void buttonClick(){
        driver.findElement(button).click();
    }



}
