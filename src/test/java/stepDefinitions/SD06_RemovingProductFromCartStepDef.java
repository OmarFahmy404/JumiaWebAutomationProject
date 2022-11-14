package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.HomePage;
import pages.registrationPages.EmailPage;
import pages.registrationPages.PasswordPage;

import java.time.Duration;

public class SD06_RemovingProductFromCartStepDef {
    HomePage homePage;
    EmailPage emailPage;
    PasswordPage passwordPage;
    CartPage cartPage;
    @Given("the logged user have already added a product to his shopping cart")
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
        homePage.clickingOnCartBtn();

    }

    @When("the user remove the product which he added")
    public void removingProduct(){
        cartPage=new CartPage(Hooks.driver);
        cartPage.removeProcess();
     Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    @Then("the shopping cart should be empty")
    public void checkingRemoval(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(cartPage.getNotificationMess(),"Product was removed from cart");
        softAssert.assertEquals(cartPage.getEmptyMessage(),"Your cart is empty!");
        softAssert.assertAll();
    }
}
