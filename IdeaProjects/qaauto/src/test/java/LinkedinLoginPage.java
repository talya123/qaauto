import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginPage {
    private WebDriver webDriver;

    private  WebElement loginField;
    private WebElement passwordField;
    private WebElement loginButton;

    public LinkedinLoginPage(WebDriver webDriver) {

        this.webDriver = webDriver;
        initElements();
    }

    public void initElements() {
        loginField = webDriver.findElement(By.id("login-email"));
        passwordField = webDriver.findElement(By.id("login-password"));
        loginButton = webDriver.findElement(By.id("login-submit"));

    }

    public void login(String email, String password) {
        loginField.sendKeys("email");
        passwordField.sendKeys("password");
        loginButton.click();

    }

    public boolean isLoginButtonDisplayed () {
        return loginButton.isDisplayed();

    }

    public String getCurrentUrl() {

        return webDriver.getCurrentUrl();
    }

    public String getCurrentTitle() {

        return webDriver.getTitle();

    }
}
