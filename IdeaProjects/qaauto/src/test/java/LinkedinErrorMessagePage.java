import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinErrorMessagePage {
    WebDriver webDriver;
    WebElement errorMessage;

    public LinkedinErrorMessagePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        errorElement();
    }
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();

    }

    public String getCurrentTitle() {
        return webDriver.getTitle();
    }


    public void errorElement() {
        errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));

          }

}



