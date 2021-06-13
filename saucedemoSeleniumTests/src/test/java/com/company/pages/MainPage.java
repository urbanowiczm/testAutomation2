package com.company.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//https://github.com/laszlosimity/Java-TestNG-SauceDemo-Selenium/blob/master/src/test/java/com/yourcompany/Pages/SauceDemoHomePage.java
public class MainPage {
    public static String mainPageUrl = "https://www.saucedemo.com/";

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(className = "submit-button")
    private WebElement submitButton;

    @FindBy(css = ".error-message-container [data-test='error']")
    private WebElement errorText;

    public WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage goToPage() {
        driver.get(mainPageUrl);
        return this;
    }

    public String getUserName() {
        String theField = usernameField.getText();
        return theField;
    }

    public void setUsername(String theUsername) {
        usernameField.clear();
        usernameField.sendKeys(theUsername);
    }

    public void setPassword(String thePassword) {
        passwordField.clear();
        passwordField.sendKeys(thePassword);
    }

    public void login(String theUsername, String thePassword) {
        setUsername(theUsername);
        setPassword(thePassword);
        submitButton.click();
    }

    public String getErrorText() {
        return errorText.getText();
    }
}
