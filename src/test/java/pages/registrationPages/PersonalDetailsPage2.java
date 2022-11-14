package pages.registrationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPage2 {
    WebDriver driver;

    public PersonalDetailsPage2(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="gender")
    WebElement genderTypes;
    @FindBy(xpath = "//*[@id=\"gender\"]/div[2]/ul/li[2]")
    WebElement maletype;
    @FindBy(id = "input_birth_date")
    WebElement dateOfBirth;
    @FindBy(id = "acceptTC")
    WebElement checkBtn;
    @FindBy(id = "confirmBtn")
    WebElement confirmationBtn;


    public void enteringGenderAndBD(){
        genderTypes.click();
        maletype.click();
        dateOfBirth.sendKeys("30-11-1999");
        checkBtn.click();
        confirmationBtn.click();
    }
}
