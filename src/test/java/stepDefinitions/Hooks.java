package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class Hooks {
    public static WebDriver driver;
    @Before
    public void openBrowser(){
        String path= System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.jumia.com.eg/");
    }

   @After
    public void closeBrowser(){ driver.close();}
}
