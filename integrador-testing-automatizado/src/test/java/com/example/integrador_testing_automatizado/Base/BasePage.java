package com.example.integrador_testing_automatizado.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
    }

    public WebElement findElement(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }


    public void sendText(String input, By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(input);
    }

    public void sendKey(CharSequence input, By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        driver.findElement(locator).sendKeys(input);
    }

    public void clickear(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    public String getText(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    public void close() {
        driver.quit();
    }


}
