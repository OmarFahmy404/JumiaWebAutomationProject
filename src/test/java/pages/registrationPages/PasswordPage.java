package pages.registrationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.Hooks;

import java.time.Duration;

public class PasswordPage {
    WebDriver driver;

    public PasswordPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"card_password\"]/div[4]/label/input")
    WebElement confirmationPass;
    @FindBy(xpath = "//*[@id=\"card_password\"]/div[5]/div/button")
    WebElement continueBtn;
    @FindBy(id = "loginButton")
    WebElement loginBtn;
    @FindBy(xpath = "//*[@id=\"passwordForm\"]/div[2]/div[3]/div/div")
    WebElement wrongMess;
    @FindBy(id = "password")
    WebElement passwordWord;
    @FindBy(id = "password-strength-text")
    WebElement passStrength;
    @FindBy(id = "confirm-password-label")
    WebElement confirmPassMess;

    public void enteringFirstPass()  {
        password.sendKeys("1475963om&");

    }

    public void enteringSecondPassAndContinue(){
        confirmationPass.sendKeys("1475963om&");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        continueBtn.click();
    }
    public void enteringPassword(){
        password.sendKeys("1475963om&");
        loginBtn.click();
    }
    public void enteringInvalidPassToLogin(){
        password.sendKeys("000000");
        loginBtn.click();
    }
    public String getMessage(){
        return wrongMess.getText();
    }

    public String getPassColor(){
        return Color.fromString(passwordWord.getCssValue("color")).asHex();
    }

    public void enteringInvalidPassToReg(){
        password.sendKeys("1234");
        confirmationPass.sendKeys("1234");
        continueBtn.click();
    }

    public String getPassStrength(){
        return passStrength.getText();
    }
    public String getConfirmMess(){return confirmPassMess.getText();}
    public void enteringDiffPass(){
        confirmationPass.sendKeys("wdfce7");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        continueBtn.click();

    }
}
