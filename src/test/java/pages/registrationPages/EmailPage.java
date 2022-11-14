package pages.registrationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage {
    public WebDriver driver;

    public EmailPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/html/body/div/div[4]/form/div[2]/div[2]/label")
    WebElement emailfield;
    @FindBy(xpath = "/html/body/div/div[4]/form/div[2]/div[3]/div/button")
    WebElement continueBtn;
    @FindBy(xpath = "/html/body/div/div[4]/form/div[2]/div[2]/label/span/span[2]")
    WebElement emailBorder;

    public void enteringEmailAndContinue(){
       emailfield.sendKeys("omarElnegary@gmail.com");
        continueBtn.click();
    }
    public void enteringInvalidEmailToLog(){
        emailfield.sendKeys("testrkfdefawedt1@gmail.com");
        continueBtn.click();
    }

    public String getEmailBorderColor(){
        return emailBorder.getCssValue("border-color");
    }

    public void enteringInvalidEmailToReg(){
        emailfield.sendKeys("testrkfdefawedt1gmail.com");
        continueBtn.click();
    }

}
