package com.company.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Google1Test {
    @Test
    @DisplayName("Google selenium, then go to selenium page and verify if donate button is enabled.")
    void searchForTextInGoogle() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("L2AGLb")));

        //accept terms
        WebElement acceptTermsButton = driver.findElement(By.id("L2AGLb"));
        acceptTermsButton.click();

        //type selenium in search input adn submit
        WebElement searchInput = driver.findElement(By.cssSelector("input[name='q']"));
        searchInput.sendKeys("selenium");
        searchInput.sendKeys(Keys.ENTER);

        //find link https://www.selenium.dev/ and go to selenium page
        WebElement linkToSeleniumPage = driver.findElement(By.cssSelector("a[href='https://www.selenium.dev/']"));
        linkToSeleniumPage.click();

        WebElement donateButton = driver.findElement(By.xpath("div[class='donate-selenium']"));
        assertTrue(donateButton.isDisplayed());

        driver.quit();
    }
}
