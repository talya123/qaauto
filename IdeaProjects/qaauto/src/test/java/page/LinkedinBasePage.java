package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GMailService;

/**
 * Base Page Object class
 */
public abstract class LinkedinBasePage {
    protected WebDriver webDriver;
    protected  static GMailService gMailService = new GMailService();

    /**
     * Constructor of BasePage
     * @param webDriver - webDriver instance
     */
    public LinkedinBasePage (WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * @return The current URL of the page
     */
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();

    }

    /**
     * @return The current Title of the page
     */
    public String getCurrentTitle() {
        return webDriver.getTitle();
    }

    /**
     * @return
     */
    public abstract boolean  isPageLoaded();

    public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    public WebElement waitUntilElementIsVisible (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }



    //public boolean isPageLoaded() {
        //return false;
    //}
}
