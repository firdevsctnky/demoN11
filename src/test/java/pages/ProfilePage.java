package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String productID;

    public String getProductId(String xPathStr){

        WebElement element = driver.findElement(By.xpath(xPathStr));
        productID = element.getAttribute("id");
        System.out.println(productID);
        return productID;

    }
    public void clickProfilFavorite() throws InterruptedException {

        click(By.xpath("//a[@class='menuTitle ']"));
        click(By.xpath("//a[contains(.,'İstek Listelerim')]"));
        click(By.xpath("//h4[contains(.,'Favorilerim')]"));
        sleep();

    }

    public boolean checkFavouriteProduct(String favouriteProductId){

        List<WebElement> element = driver.findElements(By.xpath("//*[@id=\"view\"]/ul/li"));

        for(WebElement ele:element)
        {
            WebElement productDiv = ele.findElement(By.tagName("div"));
            String productDivId = productDiv.getAttribute("id");
            System.out.println(productDivId);
            if (favouriteProductId.equals(productDivId)){
                Assert.assertTrue(favouriteProductId.equals(productDivId),"Ürün favorilere eklenmiştir.");
                return true;
            }
        }
        return  false;

    }

    public void deleteFavouriteProduct(String favouriteProductID){

        click(By.xpath("//*[@id='"+favouriteProductID+"']/div[contains(@class,'wishProBtns')]/span"));
        sleep(1000);
        click(By.xpath("//span[@class='btn btnBlack confirm'][contains(.,'Tamam')]"));
        sleep(1000);
    }

    public boolean checkDeleteFavouriteProduct(String favouriteProductId){

        List<WebElement> element = driver.findElements(By.xpath("//*[@id=\"view\"]/ul/li"));

        for(WebElement ele:element)
        {
            WebElement productDiv = ele.findElement(By.tagName("div"));
            String productDivId = productDiv.getAttribute("id");
            System.out.println(productDivId);
            if (favouriteProductId.equals(productDivId)){
                Assert.assertFalse(favouriteProductId.equals(productDivId),"Ürün favorilerden silinmemiştir.");
                return false;
            }
        }
        return  true;

    }

}
