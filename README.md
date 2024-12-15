
# Converting a Selenium 2 Project to Selenium 4

I originally developed a set of regression tests using Selenium 2.53.0 and TestNG 6.9.9 about 4–5 years ago. Recently, I needed to reuse these scripts but encountered issues when attempting to run the project. After investigating, I discovered that the project was not working due to outdated Selenium dependencies and API changes. Based on suggestions and research, I decided to migrate the project to Selenium 4 to ensure compatibility and take advantage of its new features and enhancements. Below is a detailed explanation of the process I followed.

---

### Steps for Conversion

#### **1. Update Selenium Dependency in `pom.xml`**
The first step was to replace the outdated Selenium 2 dependency with the latest Selenium 4 version in the Maven `pom.xml` file. I updated it as follows:

```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.21.0</version>
</dependency>

<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.10.2</version>
    <scope>test</scope>
</dependency>
```

- **Why TestNG?**  
  Since my original project was built with TestNG for test management, I also updated the TestNG dependency to the latest version (`7.10.2`).

After updating the `pom.xml` file, I ran the following Maven command to ensure all dependencies were downloaded and updated:

```bash
mvn clean install
```

This step ensured that my project had the latest Selenium and TestNG libraries required for Selenium 4 compatibility.

---

#### **2. Refactor the Code to Align with Selenium 4 Changes**

Selenium 4 introduced several changes and improvements over Selenium 2. As part of the migration process, I reviewed and refactored the code to address these updates. Below are the key changes:

##### **a. WebDriver Initialization**

In Selenium 4, initializing WebDriver no longer requires manually setting the system property for the driver path. The updated approach simplifies this process, allowing you to directly instantiate the WebDriver.

- **Before (Selenium 2):**
  ```java
  WebDriver driver = new ChromeDriver();
  System.setProperty("webdriver.chrome.driver", "//path//of//the//driver");
  driver.get(baseUrl);
  ```
- **After (Selenium 4):**
  ```java
  WebDriver driver = new ChromeDriver();
  driver.get(baseUrl);
  ```

##### **b. Modernizing WebDriver Initialization**

In Selenium 2, WebDriver initialization was simpler but less flexible. Selenium 4 introduced a more robust and modular way to configure WebDriver instances using `Service` and `Options`.

- **Before (Selenium 2):**
  ```java
  WebDriver driver = new ChromeDriver();
  ```

- **After (Selenium 4):**
  ```java
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.chrome.ChromeOptions;
  import org.openqa.selenium.chrome.ChromeDriverService;

  ChromeDriverService service = new ChromeDriverService.Builder()
      .usingDriverExecutable(new File("path/to/chromedriver"))
      .build();

  ChromeOptions options = new ChromeOptions();
  options.addArguments("--start-maximized");

  WebDriver driver = new ChromeDriver(service, options);
  ```

This approach is not only compliant with Selenium 4 but also enables more granular control over browser configurations.


##### **c. Updating Deprecated Methods**

In Selenium 2, methods like `findElementByClassName` and `findElementByCssSelector` were commonly used but are now deprecated in Selenium 4. I replaced these methods with the updated `By` locators.  

- **Before (Selenium 2):**
  ```java
  WebElement element = driver.findElementByClassName("example-class");
  ```
- **After (Selenium 4):**
  ```java
  WebElement element = driver.findElement(By.className("example-class"));
  ```

Similarly, other deprecated methods like `findElementById`, `findElementByXPath`, etc., were replaced using the `By` class:
  ```java
  WebElement element = driver.findElement(By.id("example-id"));
  WebElement element = driver.findElement(By.xpath("//div[@id='example']"));
  ```

##### **d. Actions and Interactions**
Selenium 4 enhanced the Actions API, making it more reliable for complex interactions. I refactored existing code using the updated Actions API:

- **Before (Selenium 2):**
  ```java
  Actions actions = new Actions(driver);
  actions.moveToElement(element).perform();
  ```

- **After (Selenium 4):**
  ```java
  Actions actions = new Actions(driver);
  actions.moveToElement(element).clickAndHold().build().perform();
  ```



##### **e. Implicit and Explicit Waits**
The WebDriverWait API was also improved in Selenium 4. I explored some of the new features.

- **Before (Selenium 2):**
  ```java
  WebDriverWait wait = new WebDriverWait(driver, 10);
  WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("example-id")));
  ```

- **After (Selenium 4):**
  ```java
  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("example-id")));
  ```

---

#### **3. Implementing Additional Selenium 4 Features**
After refactoring for compatibility, I explored some of the new features introduced in Selenium 4, such as:

- **Relative Locators:**  
  Selenium 4 introduced relative locators, which simplify finding elements relative to other elements:
  ```java
  WebElement element = driver.findElement(RelativeLocator.with(By.tagName("input")).above(anotherElement));
  ```

- **DevTools Protocol (CDP):**  
  Selenium 4 allows direct interaction with Chrome DevTools Protocol for advanced debugging and network control:
  ```java
  driver.executeCdpCommand("Network.enable", new HashMap<>());
  ```

---

#### **4. Testing and Debugging**
After making all the changes, I thoroughly tested the scripts to ensure they ran as expected. During this process, I:

- Fixed minor syntax errors caused by deprecated methods.
- Addressed any performance issues by adding efficient waits and optimizing browser configurations.
- Verified that all regression tests passed successfully in Selenium 4.

---

### Final Outcome
By following the above steps, I successfully converted my Selenium 2 project to Selenium 4. The migration not only resolved the issues with running the scripts but also allowed me to leverage Selenium 4's new features for better stability, performance, and maintainability.

