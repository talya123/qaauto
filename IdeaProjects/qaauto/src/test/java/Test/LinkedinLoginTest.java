package Test;

import Page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LinkedinLoginTest extends LinkedinBaseTest   {


    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "nkondratiuk6@gmail.com", "0987qwert" },
               // { "NKONDRATIUK6@GMAIL.COM", "0987qwert" },

        };
    }

    @DataProvider
    public Object[][] forgotPasswordDataProvider() {
        return new Object[][]{
                { "nkondratiuk6@gmail.com" },


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

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Войти или зарегистрироваться",
                "Login page Title is wrong");

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");


        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(email, password);
       // Page.LinkedinHomePage linkedinHomePage = new Page.LinkedinHomePage(webDriver);

        Assert.assertEquals(linkedinHomePage.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "Home page URL is wrong");

        Assert.assertTrue(linkedinHomePage.getCurrentTitle().contains("LinkedIn"),
                "Home page url is wrong.");
    }



    @Test (dataProvider ="invalidDataProvider")
    public void negativeLoginTest(String email, String password) {

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Войти или зарегистрироваться",
                "Login page Title is wrong");

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");


        linkedinLoginPage.login(email, password);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Войти или зарегистрироваться",
                "Login page Title is wrong");

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");
    }

         @Test (dataProvider = "invalidDataProviderLoginSubmitPage")
    public void negativeReturnedToLoginTest(String email, String password)  {

         Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                 "LinkedIn: Войти или зарегистрироваться",
                 "Login page Title is wrong");

         Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                 "Login page is not loaded");


         linkedinLoginPage.login(email, password);


             LinkedinErrorMessagePage linkedinErrorMessagePage = linkedinLoginPage.login(email, password);
       //Page.LinkedinErrorMessagePage linkedinErrorMessagePage = new Page.LinkedinErrorMessagePage (webDriver);

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
        @Test(dataProvider = "forgotPasswordDataProvider")
        public void successfulResetPasswordTest(String email) {

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Войти или зарегистрироваться",
                "Login page Title is wrong");

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page is not loaded");


       LinkedinResetPassword linkedinResetPassword = new LinkedinResetPassword(webDriver);

        linkedinLoginPage.getForgotPasswordLink();

        Assert.assertEquals(linkedinResetPassword.getCurrentUrl(),
                "https://www.linkedin.com/uas/request-password-reset?trk=uno-reg-guest-home-forgot-password",
                "Reset password page URL is wrong");

        Assert.assertTrue(linkedinResetPassword.getCurrentTitle().contains("LinkedIn"),
                "Reset password page url is wrong.");

        linkedinResetPassword.reset(email);


        LinkedinCheckpointResetPasswordPage linkedinCheckpointResetPasswordPage = new LinkedinCheckpointResetPasswordPage(webDriver);

        Assert.assertEquals(linkedinCheckpointResetPasswordPage.getCurrentUrl(),
                "https://www.linkedin.com/checkpoint/rp/request-password-reset-submit",
                "Page URL is wrong");

        Assert.assertTrue(linkedinCheckpointResetPasswordPage.isPageLoaded(),
                "Page is not loaded.");




    }
    @AfterMethod
    public void after() {
        webDriver.close();

    }

}



//testng dataprovider example

