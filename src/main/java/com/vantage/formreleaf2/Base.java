package com.vantage.formreleaf2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Base {

    WebDriver driver = null;

    public Base(WebDriver driver){
        this.driver = driver;
    }

    public void doClick(By locator){
        driver.findElement(locator).click();
    }

    public void doSendKeys(By locator, String txt){
        WebElement el = driver.findElement(locator);
        el.clear();
        el.sendKeys(txt);
    }


    public String  doGetText(By locator){
               return driver.findElement(locator).getText();
    }





}
