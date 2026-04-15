package base;

import configReader.ConfigReader;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    WebDriver driver;
    String expectedUrl = ConfigReader.getProperty("url");

    public void setUp(){
       driver = DriverSetup.getDriver();
       driver.get(expectedUrl);
    }

    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
