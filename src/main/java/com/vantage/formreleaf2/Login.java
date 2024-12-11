package com.vantage.formreleaf2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Base{


    public Login(WebDriver driver) {
        super(driver);
    }
    //object repository for login page
    private final By alertMessage = By.cssSelector("p.alert-danger");
    private final By loginButton =  By.cssSelector("button[type='submit']");
    private final By username = By.cssSelector("input#username");
    private final By password = By.cssSelector("input#password");

    //actions methods performed in the login page
    public void clickOnLoginButton() {
        doClick(loginButton);
    }
    public String getErrorMessage() {
        return doGetText(alertMessage);
    }
    public void enterValidCredentials(String user, String pass) {
        doSendKeys(username,user);
        doSendKeys(password, pass);
    }
}
