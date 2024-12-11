package com.vantage.formreleaf2;

import Utility.Constant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public WebDriver driver = null;

    @BeforeTest
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.get(Constant.baseUrl);

    }
    @AfterTest
    public void terminateBrowser() {
        //driver.close();
    }


}
