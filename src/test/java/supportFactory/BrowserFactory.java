package supportFactory;

import enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import testRunner.TestRunner;

public class BrowserFactory {

    static Browser browser = Browser.valueOf(TestRunner.config.get("browser"));

    static String desiredBrowserVersion = TestRunner.config.get("browserVersion");

    public static DesiredCapabilities selectBrowser(DesiredCapabilities caps) {

        switch (browser) {
            case Chrome:
                caps.setCapability("browserName", "chrome");
                break;
            case Edge:
                caps.setCapability("browser", "Edge");
                caps.setCapability("browserstack.ie.enablePopups", "true");
                break;
            case Firefox:
                caps.setCapability("browserName", "firefox");
                break;
            case IE:
                caps.setCapability("browserName", "internet explorer");
                caps.setCapability("browserstack.ie.enablePopups", "true");
                break;
            case Opera:
                caps.setCapability("browserName", "opera");
            case Safari:
                caps.setCapability("browserName", "safari");
                break;
            case iPhone7:
                caps.setCapability("device", "iPhone 7");
                caps.setCapability("realMobile", "true");
                caps.setCapability("os_version", "10.0");
                break;
            default:
                throw new WebDriverException("No browser specified");
        }
        caps.setCapability("version", desiredBrowserVersion);
        return caps;
    }

    public static WebDriver selectLocalBrowser() {
        switch (browser) {
            case Chrome:
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
                // MacOS does not allow to maximize window - simple workaround
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--kiosk");
                return new ChromeDriver(options);
            case Firefox:
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
                FirefoxProfile firefoxProfile = new FirefoxProfile();
                firefoxProfile.setAcceptUntrustedCertificates(true);
                firefoxProfile.setAssumeUntrustedCertificateIssuer(true);
                DesiredCapabilities dc = new FirefoxOptions().setProfile(firefoxProfile).addTo(DesiredCapabilities.firefox());
                return new FirefoxDriver(dc);
            case IE:
                return new InternetExplorerDriver();
            case Opera:
                return new OperaDriver();
            case Safari:
                return new SafariDriver();
            default:
                throw new WebDriverException("No browser specified");
        }
    }
}
