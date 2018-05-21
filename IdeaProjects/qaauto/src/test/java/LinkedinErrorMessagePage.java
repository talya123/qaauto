import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinErrorMessagePage extends LinkedinBasePage {
    WebElement errorMessage;
    private  WebElement  emailField;

    public LinkedinErrorMessagePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        errorElement();
    }


    public void errorElement() {
        emailField = webDriver.findElement(By.id("session_key-login"));
        errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));

          }

          public boolean isPageLoaded() {
        return emailField.isDisplayed();

          }

}
//или
//public class LinkedinErrorMessagePage {

//private WebElement errorMessage;


//public String getErrorMessageText() {
//return errorMessage.getText();
//}

