package com.company.tests;

import com.company.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaucedemoTest {
    private WebDriver driver;

    @BeforeAll
    public static void setupDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

    @Test
    void loginIncorrectPasswordAndUsername() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToPage();
        mainPage.login("incorrect_user","incorrect_pass");
        assertTrue(mainPage.getErrorText().contains("Username and password do not match any user in this service"));
    }
}
