package drivers;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilityManager {

    public static ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("acceptInsecureCerts", true);
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("network.proxy.type", 0);
        firefoxOptions.setProfile(profile);
        firefoxOptions.setCapability("acceptInsecureCerts", true);
        return firefoxOptions;
    }

    public static EdgeOptions getEdgeOptions(){

        EdgeOptions options = new EdgeOptions();
        options.setCapability("window-size","1920*900");
        options.setCapability("ignore-certificate-errors" , true);
        options.setCapability("acceptInsecureCerts", true);
        DesiredCapabilities capabilities = DesiredCapabilities.edge();
        options.merge(capabilities);


       // EdgeOptions edgeOptions = new EdgeOptions();
       // edgeOptions.setCapability("acceptInsecureCerts", true);
       // edgeOptions.addArguments("start-maximized");

        return options;
    }

}
