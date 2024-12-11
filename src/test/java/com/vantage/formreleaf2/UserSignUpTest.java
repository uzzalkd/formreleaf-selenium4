package com.vantage.formreleaf2;

import Utility.Constant;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserSignUpTest extends BaseTest {
    public String expected = null;
    public String actual = null;

    @Test(priority = 1, description = "Check user registration process with valid credentials")
    public void checkUserSignUp() {
        UserSignUp signup = new UserSignUp(driver);
        signup.clickOnSignUpLink();
        signup.enterValidCredentials(Constant.email, Constant.firstName, Constant.lastName,
                Constant.signupPassword, Constant.signupPasswordConfirmed);
        signup.clickOnVantageTermsCheckBox();
        //signup.driver.findElement(By.id("recaptcha-anchor")).click();
        signup.clickOnSignUpButton();
        expected = "One more step. A verification link has been sent to your email account.";
        actual = signup.getErrorMessage();
        Assert.assertEquals(actual, expected);
    }
}
