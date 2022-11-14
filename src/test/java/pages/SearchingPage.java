package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.Hooks;

import java.time.Duration;

public class SearchingPage {

    WebDriver driver;
    public SearchingPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"jm\"]/main/div[2]/div[2]/div/section/div[2]/div[1]/input")
    WebElement minField;
    @FindBy(xpath="//*[@id=\"jm\"]/main/div[2]/div[2]/div/section/div[2]/div[2]/input")
    WebElement maxField;
    @FindBy(className = "prc")
    WebElement watchPrice;
    @FindBy(className = "name")
    WebElement name;
    @FindBy(css = "button.btn._def.-fsh0")
    WebElement applyBtn;

    public void makingFiltration(){
        new WebDriverWait(Hooks.driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                elementToBeClickable(minField)).sendKeys(Keys.CONTROL +"a",Keys.DELETE);
        new WebDriverWait(Hooks.driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                elementToBeClickable(minField)).sendKeys("10230");
        new WebDriverWait(Hooks.driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                elementToBeClickable(maxField)).sendKeys(Keys.CONTROL +"a",Keys.DELETE);
        new WebDriverWait(Hooks.driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                elementToBeClickable(maxField)).sendKeys("10230");
        new WebDriverWait(Hooks.driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                elementToBeClickable(applyBtn)).click();
    }

    public String getWatchPrice(){
        return watchPrice.getText();
    }


    public String getName(){
        new WebDriverWait(Hooks.driver, Duration.ofSeconds(15)).
                until(ExpectedConditions.urlContains("ap848cl1n7so4nafamz"));
        return name.getText();
    }

}
