package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class SearchPage extends BasePage {


    String searchBox = "searchData";

    String searchBtn = "searchBtn";

    //*********Constructor*********
    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Web Elements*********
    String breadCrumb = "breadCrumb";

    //*********Page Methods*********

    public void verifySearch(String expectedKeyword) {

        Assert.assertTrue(readText(By.id(breadCrumb)).contains(expectedKeyword));
    }

    public void getResultCount(){

       WebElement element = driver.findElement(By.xpath("//div[contains(@class,'resultText')]"));
        String resultText = element.getText();
        Assert.assertTrue(resultText.contains("Samsung"));
        String resultCount = element.findElement(By.tagName("strong")).getText();
        Assert.assertTrue(Integer.parseInt(resultCount.replace(".","")) > 0);

    }

    public void checkURL(String url) {

        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contentEquals(url));
    }

    //Search
    public void search(String keyword) {

        writeText(By.id(searchBox), keyword);
        click(By.className(searchBtn));

    }
    public void clickAndAddToFavorites(){

        scrollDown();
        sleep(2000);
        click(By.xpath("((//*[@id=\"view\"])/ul/li)[3]//span[contains(@class,'followBtn')]"));

    }
    public void clickSecondPage(){

        scrollToElement(By.xpath("//div[@class='pagination']"));
        click(By.xpath("(//div[@class='pagination']/a)[2]"));

    }

}