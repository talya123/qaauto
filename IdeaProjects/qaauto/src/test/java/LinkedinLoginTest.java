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
       webDriver.get("https://www.Linkedin.com/");

       String actualLoginPageTitle = webDriver.getTitle();

               Assert.assertEquals("a", "b",
                   "Probably 'a' is not equal to 'b'");
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

        //public class LinkedinLoginTest {

            /*@Test
            public void unsuccessfulLoginTest() {
                WebDriver webDriver = new FirefoxDriver();
                webDriver.get("https://www.Linkedin.com/");

                String actualLoginPageTitle = webDriver.getTitle();
                WebElement loginField = webDriver.findElement(By.id("login-email"));
                loginField.sendKeys("nkondratiuk6@gmail.com");

                                WebElement loginButton =
                        webDriver.findElement(By.xpath("//input[@type='submit' and contains(@value, 'Войти')]"));

                loginButton.click();

                Assert.assertTrue(loginButton.isDisplayed(),
                        "Login button is not displayed");

                loginField.clear();

                WebElement passwordField = webDriver.findElement(By.id("login-password"));
                passwordField.sendKeys("0987qwert");
                loginButton.click();

                Assert.assertTrue(loginButton.isDisplayed(),
                        "Login button is not displayed");

                passwordField.clear();

                loginField.sendKeys("nkondratiuk6");
                loginButton.click();

                Assert.assertTrue(loginButton.isDisplayed(),
                        "Login button is not displayed");
                loginField.clear();

                loginField.sendKeys("nkondratiuk6@gmail.com");
                passwordField.sendKeys("    ");
                loginButton.click();
                Assert.assertTrue(loginButton.isDisplayed(),
                        "Login button is not displayed");
                loginField.clear();
                passwordField.clear();

                loginButton.click();
                Assert.assertTrue(loginButton.isDisplayed(),
                        "Login button is not displayed");


                loginField.sendKeys("nkondratiuk6@gmail.com");
                passwordField.sendKeys("a");
                loginButton.click();

                        WebElement errorMessage =
                        webDriver.findElement (By.cssSelector(".error"));
                                Assert.assertTrue(errorMessage.isDisplayed(),
                        "Error message is not displayed");








*/
            }
        }



