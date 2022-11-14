package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.registrationPages.EmailPage;
import pages.registrationPages.PasswordPage;

public class SD02_LoginPageStepDef {
    HomePage homePage;
    EmailPage emailPage;
    PasswordPage passwordPage;

    @Given("the user click on Account to login")
    public void clickingOnAcc(){
        homePage=new HomePage(Hooks.driver);
        homePage.closeWelcomingFrame();
        homePage.openRegisterPage();
    }
    @When("the user enter his email")
    public void enteringEmail(){
        emailPage=new EmailPage(Hooks.driver);
        emailPage.enteringEmailAndContinue();
    }
    @And("enter his valid password")
    public void enteringPassword(){
        passwordPage=new PasswordPage(Hooks.driver);
        passwordPage.enteringPassword();
    }
    @Then("the user should be directed to the home page")
    public void assertion(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(homePage.getAccName(),"Hi, Omar");
        softAssert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.jumia.com.eg/");
        softAssert.assertAll();
    }
    @And("enter invalid password")
    public void enteringInvalidPass(){
        passwordPage=new PasswordPage(Hooks.driver);
        passwordPage.enteringInvalidPassToLogin();
    }
    @Then("an error message should be appear and can not be directed to home page")
    public void checkingErrorMess(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(passwordPage.getMessage(),"Wrong password. Try again or click 'Forgot Password?' to reset it.");
        softAssert.assertTrue(Hooks.driver.getCurrentUrl().contains("sign-in"));
        softAssert.assertAll();
    }
    @When("the user enter his invalid email")
    public void enteringInvalidEmail(){
        emailPage=new EmailPage(Hooks.driver);
        emailPage.enteringInvalidEmailToLog();
    }
    @Then("he will be directed to password page of registration")
    public void checkingDirectedPage(){
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("sign-up/create-account#password"));
    }

}
