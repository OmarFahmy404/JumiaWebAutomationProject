package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"jm\"]/main/div/div[1]/article/article/a/div[2]/h3")
    WebElement productName;
    @FindBy(xpath = "//*[@id=\"jm\"]/main/div/div[1]/article/article/a/div[2]/p[1]")
    WebElement productSize;
    @FindBy(xpath = "//*[@id=\"jm\"]/main/div/div[1]/article/article/footer/button")
    WebElement removeBtn;
    @FindBy(xpath = "//*[@id=\"pop\"]/div/section/div/div/form[2]/button")
    WebElement confirmationRemoveBtn;
    @FindBy(xpath = "//*[@id=\"jm\"]/aside/div/div")
    WebElement notificationMessage;
    @FindBy(xpath = "//*[@id=\"jm\"]/main/div/div[1]/div/h2")
    WebElement message;

    public String getProductName(){
        return productName.getText();
    }
    public String getProductSize(){
        return productSize.getText();
    }
    public void removeProcess(){
        removeBtn.click();
        confirmationRemoveBtn.click();
    }
    public String getNotificationMess(){
        return notificationMessage.getText();
    }
    public String getEmptyMessage(){
        return message.getText();
    }
}
