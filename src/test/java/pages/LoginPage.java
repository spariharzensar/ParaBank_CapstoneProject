package pages;

import base.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
   //Locators
    @FindBy(name = "username")
    WebElement inputUsername;

    @FindBy(name = "password")
    WebElement inputPassword;

    @FindBy(xpath = "//a[text()='Register']")
    WebElement linkRegister;

    @FindBy(xpath = "//input[contains(@id,'firstName')]")
    WebElement inputFirstName;

    @FindBy(xpath = "//input[contains(@id,'lastName')]")
    WebElement inputLastName;

    @FindBy(xpath = "//input[contains(@id,'street')]")
    WebElement inputAddress;

    @FindBy(xpath = "//input[contains(@id,'city')]")
    WebElement inputCity;

    @FindBy(xpath = "//input[contains(@id,'state')]")
    WebElement inputState;

    @FindBy(xpath = "//input[contains(@id,'zipCode')]")
    WebElement inputZipCode;

    @FindBy(xpath = "//input[contains(@id,'phoneNumber')]")
    WebElement inputPhoneNumber;

    WebDriver driver;

    public LoginPage(){
        this.driver = DriverSetup.getDriver();
    }


}
