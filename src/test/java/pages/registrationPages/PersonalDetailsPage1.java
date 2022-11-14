package pages.registrationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.Hooks;

import java.time.Duration;

public class PersonalDetailsPage1 {
    WebDriver driver;

    public PersonalDetailsPage1(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "input_first_name")
    WebElement firstNameField;
    @FindBy(id = "input_middle_name")
    WebElement middleNameField;
    @FindBy(id = "input_last_name")
    WebElement lastNameField;
    @FindBy(name = "phone[number]")
    WebElement phoneField;
    @FindBy(xpath = "/html/body/div/div[4]/form/div[1]/div[2]/div[6]/div/button")
    WebElement continueBtn;
    @FindBy(xpath = "/html/body/div/div[4]/form/div[1]/div[2]/div[2]/div/div/span[3]")
    WebElement fNameErrorMess;
    @FindBy(xpath = " /html/body/div/div[4]/form/div[1]/div[2]/div[3]/div/div/span[3]")
    WebElement mNameErrorMess;
    @FindBy(xpath = "/html/body/div/div[4]/form/div[1]/div[2]/div[4]/div/div/span[3]")
    WebElement lNameErrorMess;
    @FindBy(id = "empty-phone-error-message")
    WebElement phoneErrorMess;

    public void enteringNames(){
        firstNameField.sendKeys("Omar");
        middleNameField.sendKeys("Fahmy");
        lastNameField.sendKeys("Ahmed");
    }
    public void enteringPhonesNo(){
        phoneField.sendKeys("1598437091");
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        continueBtn.click();
    }
    public void enteringInvalidDataInNamesAndPhone(){

        firstNameField.sendKeys("214");
        middleNameField.sendKeys("u");
        lastNameField.sendKeys("10");
        phoneField.sendKeys("test");
        continueBtn.click();
    }

    public void enteringLessThan10No(){
        phoneField.sendKeys("258");
        continueBtn.click();
    }

    public String getFNameErrorMess(){
        return  fNameErrorMess.getText();
    }

    public String getMNameErrorMess() {
        return  mNameErrorMess.getText();
    }

    public String getLNameErrorMess() {
        return  lNameErrorMess.getText();
    }

    public String getPhoneErrorMess() {
        return  phoneErrorMess.getText();
    }

}
