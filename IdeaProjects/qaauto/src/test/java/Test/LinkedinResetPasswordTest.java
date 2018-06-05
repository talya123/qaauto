package Test;

import Page.LinkedinRequestPasswordResetPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedinResetPasswordTest extends LinkedinBaseTest {

    @Test
    public void successfulPasswordResetTest() {
        String userEmail = "natdi2728@gmail.com";
        String newUserPassword = "1234qwer2728";
        LinkedinRequestPasswordResetPage linkedinRequestPasswordResetPage = linkedinLoginPage.clickOnForgotPasswordLink();


        Assert.assertTrue(linkedinRequestPasswordResetPage.isPageLoaded(),
                "Request Password Reset page is not loaded");


        LinkedinRequestPasswordSubmitPage linkedinRequestPasswordSubmitPage = linkedinRequestPasswordResetPage.submitUserEmail(userEmail);

        Assert.assertTrue(linkedinRequestPasswordResetSubmitPage.isPageLoaded(),
                "RequestPasswordResetSubmit page url is not loaded.");

        LinkedinSetNewPasswordPage linkedinSetNewPasswordPage = linkedinRequestPasswordResetSubmitPage.navigateToLinkFromEmail();

        Assert.assertTrue(linkedinSetNewPasswordPage.isPageLoaded(),
                "SetNewPassword page is not loaded.");

        linkedinSuccessfulPasswordPage.submitNewPassword(newUserPassword);
        Assert.assertTrue(linkedinSuccessfulPasswordPage.isPageLoaded(),
                "SuccessfulPassword page is not loaded.");

        LinkedinHomePage linkedinHomePage =
                linkedinSuccessfulPasswordResetPage.clickOnGoToHomeButton();
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "HomePage is not loaded.");





    }
}