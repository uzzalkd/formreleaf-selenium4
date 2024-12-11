package com.vantage.formreleaf2;

import Utility.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginTest extends BaseTest {

    public String expected = null;
    public String actual = null;
    public String expectedValidationMsg = null;



    @Test (priority = 1, description = "Check validation message when submitting blank username password")
    public void checkValidationMsgWhenBlankSubmit() {
        expected = "Incorrect username or password.";
        Login login = new Login(driver);
        login.clickOnLoginButton();
        actual = login.getErrorMessage();
        Assert.assertEquals(actual, expected);
    }


    @Test (priority = 2, description = "Check page title after login with valid credentials")
    public void checkValidationWithValidCredentials() {
        Login login = new Login(driver);
        login.enterValidCredentials(Constant.username, Constant.password);
        login.clickOnLoginButton();
        expected = "Programs :: FormREleaf";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected);

    }

    @Test (priority = 3, description = "Check log out functionality for the admin roles")
    public void clickOnLogOutButton () {
//        Login login = new Login(driver);
//        login.enterValidCredentials(Constant.username, Constant.password);
//        login.clickOnLoginButton();
        ProgramListing program = new ProgramListing(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        program.clickOnLogOutButton();

    }




}
