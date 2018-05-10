import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;

import static java.lang.Thread.sleep;


public class BedCodeExample {

    public static void main(String args[]) throws InterruptedException {
                System.out.println("Hello world!");
                WebDriver webDriver = new FirefoxDriver();
                webDriver.get ("https://www.google.com/");

        WebElement searchField = webDriver.findElement(By.id("lst-ib"));
        searchField.sendKeys("Selenium");

        sleep (1000);
        WebElement searchButton =
                webDriver.findElement(By.xpath("//input[@type='button' and contains(@value, 'Google')]"));

        searchButton.click();

        searchField.sendKeys(Keys.ENTER);

        sleep (5000);

        /*List<WebElement> searchResults = webDriver.findElements(
                By.xpath("//*div[@class='srg']/div[@class='g']"));

        System.out.println(searchResults.size());

        for (WebElement searchResult : searchResults) {
            String searchResultText = searchResult.getText();
            if (searchResultText.contains("Selenium")) {
                System.out.println("SearchTerm found!");

            }

            System.out.println(searchResult.getText());

        }*/

        for (int i = 1; i<=10; i++){
            WebElement searchResult = webDriver.findElement(
                    By.xpath("//*div[@class='srg']/div["+i+"]"));
            String searchResultText = searchResult.getText();
            if (searchResultText.contains("Selenium")) {
                System.out.println("SearchTerm found!");
            }
            System.out.println(searchResult.getText());
        }


        sleep (5000);

        //webDriver.findElement (By.xpath("//*[contains(@href,'https://www.seleniumhq.org/')]"));
        //webDriver.findElement (By.xpath("//*[contains(@href,'https://ru.wikipedia.org/wiki/Selenium')]"));
        //webDriver.findElement (By.xpath("//*[contains(@href,'https://kreisfahrer.gitbooks.io/selenium-webdriver/content/webdriver_intro/webdriver_obzor_i_printsip_raboti.html')]"));

        //webDriver.findElement (By.xpath("//*[contains(text(),'Selenium - Web Browser Automation']"));





       webDriver.close();
    }
}
