import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");
    }

   @Test
    public void successfulLoginTest() {
       LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

       Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
       "LinkedIn: Войти или зарегистрироваться",
                       "Login page Title is wrong");

       Assert.assertTrue(linkedinLoginPage.isLoginButtonDisplayed(),
               "Login button is not displayed");


       linkedinLoginPage.login("natdi2728@gmail.com", "nata0987");

       LinkedinHomePage linkedinHomePage = new LinkedinHomePage (webDriver);

       Assert.assertEquals(linkedinHomePage.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
               "Home page URL is wrong");

       Assert.assertTrue(linkedinHomePage.getCurrentTitle().contains("LinkedIn"),
                "Home page url is wrong.");



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
           // }


     //}
}

     @Test
    public void negativeLoginTest() throws InterruptedException {
         String actualLoginPageTitle = webDriver.getTitle();

         // Assert.assertEquals("a", "b",
         //"Probably 'a' is not equal to 'b'");
         Assert.assertEquals(actualLoginPageTitle,
                 "LinkedIn: Войти или зарегистрироваться",
                 "Login page Title is wrong");

         LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
         Assert.assertTrue(linkedinLoginPage.isLoginButtonDisplayed(),
                 "Login button is not displayed");
         linkedinLoginPage.login("natdi2728@gmail.com", "1");


                sleep(2000);

        String currentPageUrl = webDriver.getCurrentUrl();
        String currentPageTitle = webDriver.getTitle();

        Assert.assertEquals(currentPageUrl,
                "https://www.linkedin.com/uas/login-submit",
                "Login-Submit page URL is wrong");
        Assert.assertEquals(currentPageTitle,
                "Войти в LinkedIn",
                "Login-Submit page Title is wrong");
        WebElement errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(errorMessage.getText(),
        "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
        "Wrong error message test is displayed");

    }
    @AfterMethod
    public void after() {
        webDriver.close();

    }

}



