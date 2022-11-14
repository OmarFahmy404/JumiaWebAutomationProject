package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.SearchingPage;
import pages.HomePage;

public class SD04_SearchingStepDef {
    HomePage homePage;
    SearchingPage computingSearchingPage;

    @When("^the user searching for a product \"(.*)\"$")
    public void searching(String ss){
        homePage=new HomePage(Hooks.driver);
        homePage.closeWelcomingFrame();
        homePage.searching(ss);
    }
    @And("make a filtration to select an Apple watch with 10230 EGP")
    public void filtering(){
        computingSearchingPage=new SearchingPage(Hooks.driver);
        computingSearchingPage.makingFiltration();
    }

    @Then("the product that will appear should be an apple watch")
    public void checking1(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals( computingSearchingPage.getWatchPrice(),"EGP 10,230.00");
        softAssert.assertAll();
    }

    @Then("the product that will appear should be an apple mac pro 13")
    public void checking2(){
        computingSearchingPage=new SearchingPage(Hooks.driver);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(computingSearchingPage.getName(),"Apple MacBook Pro 13\" - Core I7");
        softAssert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.jumia.com.eg/catalog/?q=ap848cl1n7so4nafamz");
        softAssert.assertAll();
    }

}
