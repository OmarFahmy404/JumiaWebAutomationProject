package pages.registrationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PinPage {
    WebDriver driver;

    public PinPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "skip-pin")
    WebElement skipBtn;

    public void clickOnSkip(){
        skipBtn.click();
    }
}
