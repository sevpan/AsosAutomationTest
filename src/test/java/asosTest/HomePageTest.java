package asosTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageobject.PropertyManager;

public class HomePageTest extends BaseTest {



    @Test(priority=0 , enabled= true)
    public void verifyHomePageTitle(){


        homePage.verifyHomePageTitle();
            }


    @Test(priority=1, enabled= true)
    public void logoIsVisible(){
        homePage.displayedHomePageLogo();

        if(homePage.displayedHomePageLogo()){
            System.out.println("Logo is displayed");
        }else{
            System.out.println("Logo is not displayed");
        }
    }
}
