import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginPage extends LinkedinBasePage {

    @FindBy (id = "login-email")
    private WebElement loginField;

    @FindBy (id = "login-password")
    private WebElement passwordField;

    @FindBy (id = "login-submit")
    private WebElement loginButton;

    public LinkedinLoginPage(WebDriver webDriver) {

        super(webDriver);
        PageFactory.initElements(webDriver, this);

    }



    public LinkedinHomePage login(String email, String password) {
        loginField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
        return PageFactory.initElements(webDriver, LinkedinHomePage.class);

    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();

    }
}


