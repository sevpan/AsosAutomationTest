package pageobject.ASOSShoppingWebSite;


import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageobject.PropertyManager;
import pageobject.BasePage;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage  {
    protected WebDriver driver;
    protected PropertyManager propertyManager;
    private static final Logger logger = LogManager.getLogger(HomePage.class.getSimpleName());
    private final String HOME_PAGE_URL = propertyManager.getProperty("homepage.url");
    public final String PAGE_TITLE = propertyManager.getProperty("homepage.title");

    @FindBy(xpath = "//a[@data-testid='asoslogo']")
    public WebElement asosLogo;

    public HomePage(WebDriver driver, PropertyManager propertyManager){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.propertyManager = propertyManager;
    }


    public HomePage verifyHomePageTitle(){
        logger.info("Trying to open application home page");
        driver.navigate().to(HOME_PAGE_URL);
        Assert.assertEquals(PAGE_TITLE, driver.getTitle());
        return this;
    }


    public boolean displayedHomePageLogo(){
        WebElement getLogo = asosLogo;
        return true;
    }

    public void LOGOPage(){
        boolean logo = displayedHomePageLogo();

        Assert.assertTrue(logo, "logo is not visible");
        System.out.println("Logo is visible");
    }

}