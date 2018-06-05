package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinResetPassword extends LinkedinBasePage

{


    @FindBy(id = "username")
    private WebElement emailPhonefield;

    @FindBy(id = "reset-password-submit-button")
    private WebElement resetPasswordSubmitButton;


    public LinkedinResetPassword(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);

    }



    public boolean isPageLoaded() {
        return emailPhonefield.isDisplayed();

    }




    public LinkedinResetPassword reset(String email) {
        emailPhonefield.sendKeys(email);
        resetPasswordSubmitButton.click();
        return PageFactory.initElements(webDriver, LinkedinResetPassword.class);
    }

}

