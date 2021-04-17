package asosTest;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

import drivers.DriverManager;
import pageobject.ASOSShoppingWebSite.HomePage;

import pageobject.PropertyManager;


public abstract class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;
    protected PropertyManager propertyManager;
    DriverManager driverManager;


    @Parameters({"browserName","testDataFileName"})
    @BeforeClass
    public void setup(@Optional("Chrome") String browserName
            , @Optional("default.properties") String testDataFileName
            , ITestContext context) throws InterruptedException {
        driverManager = new DriverManager();
        driver = driverManager.getDriver(browserName);
        context.setAttribute("WebDriver", driver);
        driver.manage().window().maximize();

        propertyManager = new PropertyManager(testDataFileName);


           Thread.sleep(3000);
        homePage = new HomePage(driver, propertyManager);

    }

    @AfterMethod
    public void browserReset(){
        driver.manage().deleteAllCookies();

    }

    @AfterClass
    public void cleanUp(){
        driver.quit();
    }
}
