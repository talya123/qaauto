package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginPage extends LinkedinBasePage {

    @FindBy(id = "login-email")
    private WebElement loginField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(id = "login-submit")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@class='link-forgot-password']")
    private WebElement forgotPasswordLink;


    public LinkedinLoginPage(WebDriver webDriver) {

        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {

        return loginButton.isDisplayed();
    }

    public void getForgotPasswordLink() {
        forgotPasswordLink.click();
    }


    //public Page.LinkedinHomePage login(String email, String password) {
    // loginField.sendKeys(email);
    //passwordField.sendKeys(password);
    //loginButton.click();
    //return PageFactory.initElements(webDriver, Page.LinkedinHomePage.class);
    // or return new Page.LinkedinHomePage(webDriver);

    //}

    public <T> T login(String email, String password) {
        loginField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
        if (getCurrentUrl().contains("/feed")) {
            return (T) new LinkedinHomePage(webDriver);
        }
        if (getCurrentUrl().contains("/login-submit")) {
            return (T) new LinkedinErrorMessagePage(webDriver);
        } else {
            return (T) this;
        }
    }


    public LinkedinRequestPasswordResetPage clickOnForgotPasswordLink() {
        forgotPasswordLink.click();
        return new LinkedinRequestPasswordResetPage(webDriver);
        }
 }
















