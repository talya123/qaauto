import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {

    @Test
    public void successfulLoginTest() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.us.Linkedin.com/");

        String actualLoginPageTitle = webDriver.getTitle();

        //       Assert.assertEquals("a", "b",
        //           "Probably 'a' is not equal to 'b'");
        Assert.assertEquals(webDriver.getTitle(),
        "LinkedIn: Войти или зарегистрироваться",
        "Login page Title is wrong");
        //}
        WebElement loginField = webDriver.findElement(By.id("login-email"));
        loginField.sendKeys("natdi2728@gmail.com");

        WebElement passwordField = webDriver.findElement(By.id("login-password"));
        passwordField.sendKeys("nata0987");

        //sleep(1000);
        WebElement loginButton =
                webDriver.findElement(By.xpath("//input[@type='submit' and contains(@value, 'Войти')]"));

        Assert.assertTrue(loginButton.isDisplayed(),
                "Login button is not displayed");

        loginButton.click();
        Assert.assertTrue(webDriver.getTitle().contains("LinkedIn"),
                "Home page URL is wrong");

        Assert.assertEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "Home page URL is wrong");

        String actualHomePageTitle = webDriver.getTitle();

        Assert.assertNotEquals(actualLoginPageTitle, actualHomePageTitle,
                "Page title did not change after Sign In");

    }
}
