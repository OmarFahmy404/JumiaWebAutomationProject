package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_scouse.An;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.WishListPage;

import java.time.Duration;

public class SD07_SavingProductInWishListStepDef {

    ProductPage productPage;
    WishListPage wishListPage;
    HomePage homePage;

    @And("add it to his wishlist")
    public void addToWishlist(){
        productPage=new ProductPage(Hooks.driver);
       Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        productPage.addingToWishlistProcess();

    }

    @Then("the success wishlist notification message should be appear")
    public void checkingWishlistNotif(){
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertEquals(productPage.getWishlistNotif(),"Product successfully added to your wishlist");
        softAssert.assertAll();
    }

    @And("the product should be appear in his wishlist")
    public void checkingProductInWishlist(){
        wishListPage=new WishListPage(Hooks.driver);
        homePage=new HomePage(Hooks.driver);
        homePage.openingWishlist();
        SoftAssert  softAssert=new SoftAssert();
        softAssert.assertEquals(wishListPage.getProductName(),"Zipper Cotton Hooded Sweatshirt First Rate - Yellow Mustard");
        softAssert.assertEquals(wishListPage.getProductSize(),"Size: XL");
        softAssert.assertAll();

    }
}
