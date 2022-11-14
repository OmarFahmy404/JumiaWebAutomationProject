package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.registrationPages.*;
import pages.HomePage;

import java.time.Duration;

public class SD01_RegisterPageStepDef {
    HomePage homePage;
    EmailPage emailPage;
    PasswordPage passwordPage;
    PersonalDetailsPage1 personalDetailsPage1;
    PersonalDetailsPage2 personalDetailsPage2;
    PinPage pinPage;

    @Given("the user click on Account to register")
    public void clickingOnAcc(){
        homePage=new HomePage(Hooks.driver);
        homePage.closeWelcomingFrame();
        homePage.openRegisterPage();
    }
    @When("the user enter his valid email")
    public void enteringEmail(){

        emailPage=new EmailPage(Hooks.driver);
        emailPage.enteringEmailAndContinue();
    }
    @And("enter his first valid password")
    public void enteringFirstPass() {
        passwordPage=new PasswordPage(Hooks.driver);
        passwordPage.enteringFirstPass();
    }
    @And("enter his second valid password")
    public void enteringSecPass() {
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(20)).until(ExpectedConditions.urlContains("sign-up/create-account#password"));
        passwordPage=new PasswordPage(Hooks.driver);
        passwordPage.enteringSecondPassAndContinue();
    }
    @And("enter his first,middle,last name")
    public void enteringNamesAndPhone(){
        personalDetailsPage1 =new PersonalDetailsPage1(Hooks.driver);
        personalDetailsPage1.enteringNames();
    }
    @And("enter his phone number")
    public void enteringPhoneNo(){
        personalDetailsPage1=new PersonalDetailsPage1(Hooks.driver);
        personalDetailsPage1.enteringPhonesNo();
    }
    @And("enter his gender and his birthdate")
    public void enteringGenderAndBD(){
        personalDetailsPage2=new PersonalDetailsPage2(Hooks.driver);
        personalDetailsPage2.enteringGenderAndBD();
    }
    @Then("after escaping the pin page the user should be directed to the home page")
    public void SkippingAndAssert() {
        pinPage=new PinPage(Hooks.driver);
        pinPage.clickOnSkip();
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(20)).until(ExpectedConditions.urlContains("https://www.jumia.com.eg/"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(homePage.getAccName(),"Hi, Omar");
        softAssert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.jumia.com.eg/");
        softAssert.assertAll();
    }
    @When("the user enter invalid email")
    public void enteringInvalidEmail(){
        emailPage=new EmailPage(Hooks.driver);
        new WebDriverWait(Hooks.driver, Duration.ofSeconds(15)).
                until(ExpectedConditions.urlContains("sign-in/email"));
        emailPage.enteringInvalidEmailToReg();
    }
    @Then("the email border should turn into red")
    public void checkingEmailColor(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(emailPage.getEmailBorderColor(),"rgb(176, 0, 32)");
        softAssert.assertAll();
    }

    @When("enter only numbers as a password")
    public void enteringInvalidPassword(){
        passwordPage=new PasswordPage(Hooks.driver);
        passwordPage.enteringInvalidPassToReg();
    }

    @Then("the password word should turn into red")
    public void checkingPassWord(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(passwordPage.getPassColor(),"#b00020");
        softAssert.assertEquals(passwordPage.getPassStrength(),"Weak");
        softAssert.assertAll();
    }
    @And("enter a different password in second field")
    public void enteringDiffPass(){
        passwordPage=new PasswordPage(Hooks.driver);
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(20)).
                until(ExpectedConditions.urlContains("sign-up/create-account#password"));
        passwordPage.enteringDiffPass();
    }
    @Then("an error message should be appear")
    public void checkingConfirmMess(){
        Assert.assertEquals(passwordPage.getConfirmMess(),"Both passwords must match");
    }
    @And("enter numbers in first ,middle and last name and characters in phone no")
    public void enteringInvalidDataInNamesAndPhone(){
        new WebDriverWait(Hooks.driver,Duration.ofSeconds(20)).
                until(ExpectedConditions.urlContains("sign-up/create-account#profile-details"));
        personalDetailsPage1=new PersonalDetailsPage1(Hooks.driver);
        personalDetailsPage1.enteringInvalidDataInNamesAndPhone();
    }
    @Then("error messages should be appear under each field")
    public void checkingErrorMessages(){

        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(personalDetailsPage1.getFNameErrorMess(),"Name must have a minimum of 2" +
                " characters and maximum of 60.","first name error message");
        softAssert.assertEquals(personalDetailsPage1.getMNameErrorMess(),"Name must have a minimum of 2" +
                " characters and maximum of 60.","middle name error message");
        softAssert.assertEquals(personalDetailsPage1.getLNameErrorMess(),"Name must have a minimum of 2" +
                " characters and maximum of 60.","last name error message");
        softAssert.assertEquals(personalDetailsPage1.getPhoneErrorMess(),"Type a valid Phone number to" +
                " continue","phone error message");
        softAssert.assertAll();
    }
    @And("enter less than 10 numbers in phone field")
    public void enteringLessThan10NO(){
        personalDetailsPage1=new PersonalDetailsPage1(Hooks.driver);
        personalDetailsPage1.enteringLessThan10No();
    }
    @Then("an error message should be appear To inform the user")
    public void checkingNumbers(){
        Assert.assertEquals(personalDetailsPage1.getPhoneErrorMess(),"Type a valid Phone number to continue");
    }

}
