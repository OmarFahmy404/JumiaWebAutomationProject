package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.Hooks;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    public ProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath= "//*[@id=\"add-to-cart\"]/button")
    WebElement addToCartBtn;
    @FindBy(xpath = "//*[@id=\"pop\"]/div/section/div/div[2]/form/button[2]")
    WebElement large3XPlusBtn;
    @FindBy(xpath = "//*[@id=\"jm\"]/aside")
    WebElement successfulNotification;
    @FindBy(xpath = "//*[@id=\"pop\"]/div/section/div/footer/a")
    WebElement viewCartBtn;
    @FindBy(xpath = "/html/body/div[1]/main/div[1]/section/div/div[2]/div[1]/form/button")
    WebElement wishListBtn;
    @FindBy(xpath = "//*[@id=\"wishlist-popup-form\"]/div[1]/label[3]")
    WebElement xlSelection;
    @FindBy(xpath = "//*[@id=\"wishlist-popup-form\"]/div[3]/button")
    WebElement addToWishlistBtn;
    @FindBy(xpath = "//*[@id=\"jm\"]/aside/div/div")
    WebElement wishlistNotif;

    public void clickingOnAddBtn(){
        new WebDriverWait(Hooks.driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();

    }
    public void clickingOnLargePlusBtn(){
        large3XPlusBtn.click();
    }
    public void clickingOnViewCartBtn(){
        viewCartBtn.click();
    }
    public String getNotificationMess(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return successfulNotification.getText();

    }

    public void addingToWishlistProcess(){
        wishListBtn.click();
        xlSelection.click();
        addToWishlistBtn.click();
    }

    public String getWishlistNotif(){
        return wishlistNotif.getText();
    }

}
