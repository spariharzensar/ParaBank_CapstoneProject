package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
   //Locators
    @FindBy(xpath = "//a[text()='Register']")
    WebElement linkRegister;

    @FindBy(id = "customer.firstName")
    WebElement inputFirstName;

    @FindBy(id = "customer.lastName")
    WebElement inputLastName;

    @FindBy(id = "customer.address.street")
    WebElement inputAddress;

    @FindBy(id = "customer.address.city")
    WebElement inputCity;

    @FindBy(id = "customer.address.state")
    WebElement inputState;

    @FindBy(id = "customer.address.zipCode")
    WebElement inputZipCode;

    @FindBy(id = "customer.phoneNumber")
    WebElement inputPhoneNumber;

    @FindBy(id = "customer.ssn")
    WebElement inputSSN;

    @FindBy(id = "customer.username")
    WebElement inputSignInUserName;

    @FindBy(id = "customer.password")
    WebElement inputSignInPassword;

    @FindBy(id = "repeatedPassword")
    WebElement inputConfirmPassword;

    @FindBy(xpath = "//input[@value='Register']")
    WebElement buttonRegister;

    @FindBy(name = "username")
    WebElement inputLoginUsername;

    @FindBy(name = "password")
    WebElement inputLoginPassword;

    @FindBy(xpath = "//h1[@class='title']")
    WebElement textWelcomeUser;

    @FindBy(xpath = "//div[@id='rightPanel']//p")
    WebElement textWelcomeMessage;

    @FindBy(xpath = "//input[@value='Log In']")
    WebElement buttonLogin;

    @FindBy(className = "smalltext")
    WebElement textLoginWelcome;

    //_____________________________________________________________________________________________________

    public static String uniqueUserName = "user_"+ System.currentTimeMillis();

    public void navigateToRegisterPage(){
        click(linkRegister);
    }

    public boolean validateUserOnRegisterPage(){
       return isElementDisplayed(inputFirstName);
    }

    public void fillUserRegistrationDetails(String fn, String ln, String addr, String cityVal,
                                            String stateVal, String zip, String ph, String ssnVal,
                                            String user, String pass) {

        enterText(inputFirstName,fn);
        enterText(inputLastName,ln);
        enterText(inputAddress,addr);
        enterText(inputCity, cityVal);
        enterText(inputState,stateVal);
        enterText(inputZipCode, zip);
        enterText(inputPhoneNumber,ph);
        enterText(inputSSN,ssnVal);
        enterText(inputSignInUserName,user);
        enterText(inputSignInPassword,pass);
        enterText(inputConfirmPassword,pass);
    }

    public void clickOnRegisterButton(){
        click(buttonRegister);
    }

    public String getUserNameWelcomeMessage(){
        return getText(textWelcomeUser);

    }

    public String getWelcomeText(){
        return getText(textWelcomeMessage);
    }

    public boolean verifyUserIsOnLoginPage(){
        return isElementDisplayed(inputLoginUsername);
    }

    public void enterLoginCredentials(String Uname, String UPassword){
        enterText(inputLoginUsername, Uname);
        enterText(inputLoginPassword, UPassword);
    }

    public void clickOnLoginButton(){
        click(buttonLogin);
    }

    public String verifyUserLoggedInSuccessfully(){
        return getText(textLoginWelcome);
    }


}
