package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
    WebDriver driver;
    public WishListPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"jm\"]/main/div/section/div/div/div[1]/article/div[1]/a")
    WebElement productName;
    @FindBy(xpath = "//*[@id=\"jm\"]/main/div/section/div/div/div[1]/article/div[1]/div/p[1]")
    WebElement productSize;

    public String getProductName(){
        return productName.getText();
    }
    public String getProductSize(){
        return productSize.getText();
    }
}
