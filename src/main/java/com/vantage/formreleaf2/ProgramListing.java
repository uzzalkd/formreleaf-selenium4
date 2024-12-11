package com.vantage.formreleaf2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProgramListing extends Base{

    public ProgramListing(WebDriver driver) {
        super(driver);
    }

    //object repository for program listing page
    private final By userSettings = By.className("glyphicon");
    private final By logOut =  By.linkText("Log Out");

    //actions methods performed in the program listing page
    public void clickOnLogOutButton() {
        doClick(userSettings);
        doClick(logOut);
    }
}
