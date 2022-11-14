package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

public class SD03_SwitchingLanguagesStepDef {

    HomePage homePage;

    @When("the user click on Arabic to change the language")
    @Given("the user already selected an Arabic")
        public void changingEngLanguage(){
        homePage=new HomePage(Hooks.driver);
        homePage.closeWelcomingFrame();
        homePage.changeLanguageFromEngToAr();
    }
    @Then("the website turn into Arabic")
        public void languageChecking(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.jumia.com.eg/ar/","URL Checking");
        softAssert.assertEquals(homePage.getJumiaName(),"بيع علي جوميا","Sell on Jumia Checking");
        softAssert.assertAll();
    }
    @When("the user click on English to change the language")
        public void  changingArLanguage(){
        homePage=new HomePage(Hooks.driver);
        homePage.changeLanguageFromArToEng();
    }
    @Then("the website turn into English")
         public void englishChecking(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.jumia.com.eg/","URL Checking");
        softAssert.assertEquals(homePage.getJumiaName(),"Sell on Jumia","Sell on Jumia Checking");
        softAssert.assertAll();
    }
}
