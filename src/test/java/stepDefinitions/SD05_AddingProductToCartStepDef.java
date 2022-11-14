package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.registrationPages.EmailPage;
import pages.registrationPages.PasswordPage;

import java.time.Duration;

public class SD05_AddingProductToCartStepDef {
    HomePage homePage;
    EmailPage emailPage;
    PasswordPage passwordPage;
    ProductPage productPage;
    CartPage cartPage;
    JavascriptExecutor jse;
    @Given("the user logged in successfully")
    public void loggingIn(){
        homePage=new HomePage(Hooks.driver);
        emailPage=new EmailPage(Hooks.driver);
        passwordPage=new PasswordPage(Hooks.driver);
        homePage.closeWelcomingFrame();
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(5)).until(ExpectedConditions.
                urlContains("jumia.com.eg"));
        homePage.openRegisterPage();
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(5)).until(ExpectedConditions.
                urlContains("sign-in/email"));
        emailPage.enteringEmailAndContinue();
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(5)).until(ExpectedConditions.
                urlContains("en-eg/sign-in"));
        passwordPage.enteringPassword();
    }

    @When("the user select an item")
    public void selectingItem() {
        jse= (JavascriptExecutor) Hooks.driver;
        jse.executeScript("window.scrollBy(0,5110)");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickingOnHoodedPic();
    }

    @And("add it to his shopping cart")
    public void addingToCart(){
        productPage=new ProductPage(Hooks.driver);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jse= (JavascriptExecutor) Hooks.driver;
        jse.executeScript("window.scrollBy(0,310)");
        productPage.clickingOnAddBtn();
    }

    @And("select the more details about the item")
    public void addingMoreDetails(){
        productPage.clickingOnLargePlusBtn();
    }

    @Then("the success notification message should be appear")
    public void checkingNotif(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(productPage.getNotificationMess(),"Product added successfully",
                "notification message");
        softAssert.assertAll();
    }

    @And("the product should be appear in shopping cart")
    public void checkingProduct(){
        productPage=new ProductPage(Hooks.driver);
        productPage.clickingOnViewCartBtn();
        cartPage=new CartPage(Hooks.driver);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(cartPage.getProductName(),"AKAI Zipper Cotton Hooded Sweatshirt First Rate " +
                "- Yellow Mustard","product name");
        softAssert.assertEquals(cartPage.getProductSize(),"Size:\n" +"3XL");
        softAssert.assertAll();

    }
}
