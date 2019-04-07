package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.SearchPage;

public class e2eTest extends BaseTest {


    @Test
    public void e2e() throws InterruptedException {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);
        SearchPage searchPage = new SearchPage(driver,wait);
        ProfilePage profilePage = new ProfilePage(driver,wait);

        //*************PAGE Methods********************
        //Open N11 HomePage
        homePage.goToN11();

        //Go to LoginPage
        homePage.goToLoginPage();

        //Login to N11
        loginPage.loginToN11("seleniumDemo1111@gmail.com", "denemeGg123");

        //*************ASSERTIONS***********************
        Thread.sleep(500);

        //Verify Login
        loginPage.verifyLogin(("Selen Yum"));


        //Search
        searchPage.search("Samsung");

        //Verify Search
        searchPage.verifySearch("Samsung");

        //Check Result Count
        searchPage.getResultCount();

        //Verify URL
        searchPage.checkURL("https://www.n11.com/arama?q=Samsung");

        //Click Pagination Second Buttom
        searchPage.clickSecondPage();

        //click Third Product Add to Favourite List
        searchPage.clickAndAddToFavorites();

        //get ProductId
        String productId = profilePage.getProductId("((//*[@id=\"view\"])/ul/li)[3]//div[contains(@class,'columnContent')]");


        //click Profile Favourite
        profilePage.clickProfilFavorite();
        profilePage.checkFavouriteProduct(productId);
        profilePage.deleteFavouriteProduct(productId);
        profilePage.checkDeleteFavouriteProduct(productId);




    }
}