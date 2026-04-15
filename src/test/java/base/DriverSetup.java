package base;

import configReader.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    static String expectedBrowser = ConfigReader.getProperty("browser");

    public static WebDriver getDriver() {
        WebDriver wbDriver;
        switch (expectedBrowser.toLowerCase()) {

            case "chrome":
                io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
                wbDriver = new ChromeDriver();
                break;

            case "edge":
                io.github.bonigarcia.wdm.WebDriverManager.edgedriver().setup();
                wbDriver = new EdgeDriver();
                break;

            case "firefox":
                io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
                wbDriver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Browser not supported:"+ expectedBrowser);
        }
        wbDriver.manage().window().maximize();
        wbDriver.manage().deleteAllCookies();

        driver.set(wbDriver);

        return driver.get();
    }
}
