package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

public static WebDriver createNewDriver(String browserType) {
    WebDriver driver;
    if (browserType.toUpperCase().equals(DriverType.CHROME.name())) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    } else if (browserType.toUpperCase().equals(DriverType.FIREFOX.name())) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
    else if (browserType.toUpperCase().equals(DriverType.HEADLESS.name())) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }
    else {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("======UNKNOWN driver \"" + browserType + "\"  is not supported. CHROME driver is created instead======");
    }
    return driver;
}

    public static WebDriver createNewDriver(String browserType, MutableCapabilities wdOptions) {
        WebDriver driver;
        if (browserType.toUpperCase().equals(DriverType.CHROME.name())) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver((ChromeOptions) wdOptions);
        } else if (browserType.toUpperCase().equals(DriverType.FIREFOX.name())) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver((FirefoxOptions) wdOptions);
        }
        else if (browserType.toUpperCase().equals(DriverType.HEADLESS.name())) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
        }
        else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("======UNKNOWN driver " + browserType + "  is not supported. CHROME driver is created instead======");
        }
        return driver;
    }


}

