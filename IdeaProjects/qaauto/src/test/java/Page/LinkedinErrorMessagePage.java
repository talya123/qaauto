package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LinkedinErrorMessagePage extends LinkedinBasePage {
    @FindBy (id = "session_key-login")
    private WebElement emailField;

    @FindBy (id = "//div[@role='alert']")
    private WebElement errorMessage;



    public LinkedinErrorMessagePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);

    }

    public LinkedinErrorMessagePage login(String email, String password) {
         return PageFactory.initElements(webDriver, LinkedinErrorMessagePage.class);

    }



        public String getErrorMessageText() {
        return errorMessage.getText();

    }

          public boolean isPageLoaded() {
        return emailField.isDisplayed();

          }

}



