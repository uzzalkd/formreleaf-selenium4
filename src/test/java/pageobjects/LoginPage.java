package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private static WebElement element = null;

    public static WebElement LoginMenu(WebDriver driver){
        element = driver.findElement(By.linkText("LOG IN"));
        return element;
    }

    public static WebElement UserName(WebDriver driver){
        element = driver.findElement(By.name("username"));
        return element;
    }

    public static WebElement Password(WebDriver driver){
        element = driver.findElement(By.name("password"));
        return element;
    }

    public static WebElement LoginBtn(WebDriver driver){
        element = driver.findElement(By.cssSelector("button[type='submit']"));
        return element;
    }
}
