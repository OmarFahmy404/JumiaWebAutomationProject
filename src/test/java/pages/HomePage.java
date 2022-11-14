package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.Hooks;

public class HomePage {
    public WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")
    WebElement accountDropList;
    @FindBy(xpath = "//*[@id=\"dpdw-login-box\"]/div/div/a")
    WebElement signInBtn;
    @FindBy(xpath = "//*[@id=\"pop\"]/div/section/button")
    WebElement closeBtn;
    @FindBy(xpath = "//*[@id=\"jm\"]/div[2]/div[3]/a[2]")
    WebElement arLanguage;
    @FindBy(xpath = "//*[@id=\"jm\"]/div[2]/div[3]/a[1]")
    WebElement engLanguage;
    @FindBy(xpath = "//*[@id=\"jm\"]/div[2]/div[1]/a")
    WebElement sellOnJumiaAr;
    @FindBy(id = "fi-q")
    WebElement searchField;
    @FindBy(xpath = "//*[@id=\"jm\"]/main/div[1]/div[16]/section/div/div/div[5]/article/a/img")
    WebElement hoodedSweatShirt;
    @FindBy(xpath = "//*[@id=\"jm\"]/header/section/div[2]/a")
    WebElement cartBtn;
    @FindBy(xpath = "//*[@id=\"dpdw-login-box\"]/div/a[4]")
    WebElement savedItem;

    public WebElement slider(String sliderNum){
       return Hooks.driver.findElement(By.xpath( "//*[@id=\"sl-topblock\"]/a["+sliderNum+"]/img"));
    }

    public void  closeWelcomingFrame(){closeBtn.click();}
    public void openRegisterPage(){
        accountDropList.click();
        signInBtn.click();
    }
    public String getAccName(){
        return accountDropList.getText();
    }
    public String getJumiaName(){return sellOnJumiaAr.getText();}
    public void changeLanguageFromEngToAr(){
        arLanguage.click();
    }
    public void changeLanguageFromArToEng(){
        engLanguage.click();
    }
    public void searching(String s){
        searchField.sendKeys(s);
        searchField.submit();
    }
    public void clickingOnHoodedPic(){
        hoodedSweatShirt.click();
    }
    public void clickingOnCartBtn(){
        cartBtn.click();
    }
    public void openingWishlist(){
        accountDropList.click();
        savedItem.click();
    }
    public void clickingOnSlider(String sliderNum){
        slider(sliderNum).click();
    }

}
