import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LinkedinLoginTest   {
    WebDriver webDriver;

    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");
            }

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "nkondratiuk6@gmail.com", "0987qwert" },
               // { "NKONDRATIUK6@GMAIL.COM", "0987qwert" },

        };
    }

    @DataProvider
    public Object[][] invalidDataProvider() {
        return new Object[][]{
                { "nkondratiuk6@gmail.com", "" },
                { "", "0987qwert" },
                { "nkondratiuk6@gmail.com", "    " },
                { "", "" },


        };
    }

    @DataProvider
    public Object[][] invalidDataProviderLoginSubmitPage() {
        return new Object[][]{
                { "nkondratiuk6", "0987qwert" },
                { "nkondratiuk6@gmail.com", "1" },


        };
    }


    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String email, String password) {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Войти или зарегистрироваться",
                "Login page Title is wrong");

        Assert.assertTrue(linkedinLoginPage.isLoginButtonDisplayed(),
                "Login button is not displayed");


        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(email, password);
       // LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);

        Assert.assertEquals(linkedinHomePage.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "Home page URL is wrong");

        Assert.assertTrue(linkedinHomePage.getCurrentTitle().contains("LinkedIn"),
                "Home page url is wrong.");
    }



    @Test (dataProvider ="invalidDataProvider")
    public void negativeLoginTest(String email, String password) {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Войти или зарегистрироваться",
                "Login page Title is wrong");

        Assert.assertTrue(linkedinLoginPage.isLoginButtonDisplayed(),
                "Login button is not displayed");


        linkedinLoginPage.login(email, password);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Войти или зарегистрироваться",
                "Login page Title is wrong");

        Assert.assertTrue(linkedinLoginPage.isLoginButtonDisplayed(),
                "Login button is not displayed");
    }

         @Test (dataProvider = "invalidDataProviderLoginSubmitPage")
    public void negativeReturnedToLoginTest(String email, String password)  {
         LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

         Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                 "LinkedIn: Войти или зарегистрироваться",
                 "Login page Title is wrong");

         Assert.assertTrue(linkedinLoginPage.isLoginButtonDisplayed(),
                 "Login button is not displayed");


         linkedinLoginPage.login(email, password);



       LinkedinErrorMessagePage linkedinErrorMessagePage = new LinkedinErrorMessagePage (webDriver);

        Assert.assertEquals(linkedinErrorMessagePage.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit",
                "Login-Submit page URL is wrong");
        Assert.assertEquals(linkedinErrorMessagePage.getCurrentTitle(),
                "Войти в LinkedIn",
                "Login-Submit page Title is wrong");
                Assert.assertEquals(linkedinErrorMessagePage.getErrorMessageText(),
        "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
        "Wrong error message test is displayed");
                Assert.assertTrue(linkedinErrorMessagePage.isPageLoaded(),
                        "Login-Submit page is not loaded.");



    }
    @AfterMethod
    public void after() {
        webDriver.close();

    }

}



//testng dataprovider example

