package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinCheckpointResetPasswordPage extends LinkedinBasePage

{

    @FindBy(className = "different__email")
    private WebElement differentEmailfield;

    public LinkedinCheckpointResetPasswordPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);

    }

    public boolean isPageLoaded() {
        return differentEmailfield.isDisplayed();
    }
}


