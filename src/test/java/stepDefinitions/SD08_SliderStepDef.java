package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;

import java.time.Duration;

public class SD08_SliderStepDef {
    HomePage homePage;
    @When("the user click on the first slider")
    public void clickingOnFirstSlider(){
        homePage=new HomePage(Hooks.driver);
        homePage.closeWelcomingFrame();
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(16)).
                until(ExpectedConditions.elementToBeClickable(homePage.slider("1")));
        homePage.clickingOnSlider("1");
    }
    @Then("he would be directed to Sensodyne store page")
    public void checkingAEStorePage(){
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.jumia.com.eg/mlp-gsk-store/");
    }

    @When("the user click on the second slider")
    public void clickingOnSecondSlider(){
        homePage=new HomePage(Hooks.driver);
        homePage.closeWelcomingFrame();
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(16)).
                until(ExpectedConditions.elementToBeClickable(homePage.slider("2")));
        homePage.clickingOnSlider("2");

    }
    @Then("he would be directed to Aquafresh store page")
    public void checkingOilPage(){
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.jumia.com.eg/aquafresh/");
    }

    @When("the user click on the third slider")
    public void clickingOnThirdSlider(){
        homePage=new HomePage(Hooks.driver);
        homePage.closeWelcomingFrame();
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(16)).
                until(ExpectedConditions.elementToBeClickable(homePage.slider("3")));
        homePage.clickingOnSlider("3");
    }
    @Then("he would be directed to Adidas store page")
    public void checkingAndoreStorePage(){
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(5)).
                until(ExpectedConditions.urlContains("adidas-official-store"));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.jumia.com.eg/mlp-adidas-official-store/");
    }

    @When("the user click on the fourth slider")
    public void clickingOnFourthSlider(){
        homePage=new HomePage(Hooks.driver);
        homePage.closeWelcomingFrame();
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(30)).
                until(ExpectedConditions.elementToBeClickable(homePage.slider("4")));
        homePage.clickingOnSlider("4");
    }
    @Then("he would be directed to Bazicz store page")
    public void checkingRehanaStorePage(){
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(5)).until(ExpectedConditions.urlContains("bazicz"));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.jumia.com.eg/bazicz/");
    }

    @When("the user click on the fifth slider")
    public void clickingOnFifthSlider(){
        homePage=new HomePage(Hooks.driver);
        homePage.closeWelcomingFrame();
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(40)).
                until(ExpectedConditions.elementToBeClickable(homePage.slider("5")));
        homePage.clickingOnSlider("5");
    }
    @Then("he would be directed to Play&Win page")
    public void checkingPlayWinPage(){
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(5)).
                until(ExpectedConditions.urlContains("mlp-jumia-games"));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.jumia.com.eg/mlp-jumia-games/");
    }

    @When("the user click on the sixth slider")
    public void clickingOnSixthSlider(){
        homePage=new HomePage(Hooks.driver);
        homePage.closeWelcomingFrame();
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(53)).
                until(ExpectedConditions.elementToBeClickable(homePage.slider("6")));
        homePage.clickingOnSlider("6");
    }
    @Then("he would be directed to Free Shipping page")
    public void checkingFreeShippingPage(){
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(5)).
                until(ExpectedConditions.urlContains("mlp-free-shipping"));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.jumia.com.eg/mlp-free-shipping/");
    }

    @When("the user click on the seventh slider")
    public void clickingOnSeventhSlider(){
        homePage=new HomePage(Hooks.driver);
        homePage.closeWelcomingFrame();
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(60)).
                until(ExpectedConditions.elementToBeClickable(homePage.slider("7")));
        homePage.clickingOnSlider("7");
    }
    @Then("he would be directed to Banque Misr Installment page")
    public void checkingBMiserPage(){
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(5)).
                until(ExpectedConditions.urlContains("sp-valu-installments"));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),
                "https://www.jumia.com.eg/sp-banque-misr-installment/");
    }

    @When("the user click on the eighth slider")
    public void clickingOnEighthSlider(){
        homePage=new HomePage(Hooks.driver);
        homePage.closeWelcomingFrame();
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(60)).
                until(ExpectedConditions.elementToBeClickable(homePage.slider("8")));
        homePage.clickingOnSlider("8");
    }
    @Then("he would be directed to Discount page")
    public void checkingDiscountPage(){
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(5)).
                until(ExpectedConditions.urlContains("payment-discounts"));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.jumia.com.eg/mlp-payment-discounts/");
    }
}
