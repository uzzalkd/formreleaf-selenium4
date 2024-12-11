package com.vantage.formreleaf2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserSignUp extends Base {


    public UserSignUp(WebDriver driver) {
        super(driver);
    }
    //test
    //object repository for the user sign up pages
    private final By signUpLink = By.linkText("SIGN UP");
    private final By email = By.id("email");
    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By password = By.id("password");
    private final By passwordConfirmed = By.id("passwordConfirmed");
    private final By signUpButton =  By.cssSelector("button[type='submit']");
    private final By vantageTermsCheckBox = By.id("agreedTerms1");
    private final By alertSuccessMessage = By.cssSelector("div.alert.alert-success");


    //actions methods performed in the user registration page

    public void enterValidCredentials(String email, String firstName, String lastName, String password, String passwordConfirmed) {
        doSendKeys(this.email,email);
        doSendKeys(this.firstName, firstName);
        doSendKeys(this.lastName, lastName);
        doSendKeys(this.password, password);
        doSendKeys(this.passwordConfirmed, passwordConfirmed);
    }


    public void clickOnSignUpButton() {
        doClick(signUpButton);
    }

    public void clickOnSignUpLink() {
        doClick(signUpLink);
    }

    public void clickOnVantageTermsCheckBox() {
        doClick(vantageTermsCheckBox);
    }

    public String getErrorMessage() {
       return doGetText(alertSuccessMessage);
    }
}
