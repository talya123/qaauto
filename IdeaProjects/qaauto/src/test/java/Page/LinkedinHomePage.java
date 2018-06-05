package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinHomePage extends LinkedinBasePage {

    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavItem;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchField;



    public LinkedinHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    boolean isPageLoaded() {
        return profileNavItem.isDisplayed();
    }




    public LinkedinSearchResults search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.submit();
        return new LinkedinSearchResults(webDriver);
    }
}

