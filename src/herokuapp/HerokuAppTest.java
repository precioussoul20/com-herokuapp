package herokuapp;
/*Project-3 - ProjectName : com-herokuapp
BaseUrl = http://the-internet.herokuapp.com/login
1. Setup chrome browser.
2. Open URL.
3. Print the title of the page.
4. Print the current url.
5. Print the page source.
6. Enter the email to email field.
7. Enter the password to password field.
8. Click on Login Button.
9. Print the current url.
10. Refresh the page.
11. Close the browser.
* */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class HerokuAppTest {
    static WebDriver driver;
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static String browser = "Chrome";

    public static void main(String[] args) throws InterruptedException {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        //Open the url into the Browser
        driver.get(baseUrl);
        Thread.sleep(5000);

        // Maximise the browser
        driver.manage().window().maximize();

        // We give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Get the title of the page
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(5000);

        //Get current Url
        System.out.println("The current Url " + driver.getCurrentUrl());

        //print page source
        System.out.println(driver.getPageSource());

        //Enter the Email to email field
        WebElement emailField = driver.findElement(By.id("username"));
        emailField.sendKeys("tomsmith");
        Thread.sleep(5000);

        //Enter the Password to password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");
        Thread.sleep(5000);

        //Click on Login button
        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();
        Thread.sleep(5000);

        //Print current Url
        String currentUrl = "https://the-internet.herokuapp.com/secure";
        System.out.println(driver.getCurrentUrl());

        //Refresh the page
        driver.navigate().refresh();
        Thread.sleep(5000);

        // Close the Browser
        driver.quit();


    }
}
