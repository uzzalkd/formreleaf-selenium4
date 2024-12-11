package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    private static WebElement element = null;

    public static WebElement LoginMenu(WebDriver driver){
        element = driver.findElement(By.linkText("LOG IN"));
        return element;
    }
}
