package stepDefinitions;

import configReader.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.RegisterPage;

import java.util.Map;

public class RegisterSteps {

    RegisterPage registerPage = new RegisterPage();
    SoftAssert softAssert = new SoftAssert();
    String userPassword = ConfigReader.getProperty("userPassword");

    //TC 01: Verify that user is able to register successfully
    @Given("user is on the registration page")
    public void userIsOnRegistrationPage() {
        registerPage.navigateToRegisterPage();
        boolean isOnPage = registerPage.validateUserOnRegisterPage();
        softAssert.assertTrue(isOnPage, "User is NOT on registration page");
        softAssert.assertAll();
    }

    @When("user enters registration details")
    public void userEntersRegistrationDetails(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        registerPage.fillUserRegistrationDetails(
                data.get("firstName"),
                data.get("lastName"),
                data.get("address"),
                data.get("city"),
                data.get("state"),
                data.get("zipCode"),
                data.get("phone"),
                data.get("ssn"),
                RegisterPage.uniqueUserName,
                userPassword
        );
        System.out.println("Scenario 1:" + RegisterPage.uniqueUserName);
    }

    @And("clicks on register button")
    public void clicksOnRegisterButton() {
        registerPage.clickOnRegisterButton();
    }

    @Then("user should be registered successfully")
    public void userShouldBeRegisteredSuccessfully(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        String actualWelcomeMessage = registerPage.getUserNameWelcomeMessage();
        String actualWelcomeText = registerPage.getWelcomeText();
        softAssert.assertTrue(
                actualWelcomeMessage.contains(RegisterPage.uniqueUserName), "Username not found in welcome message"
        );

        softAssert.assertEquals(
                actualWelcomeText.trim(),
                data.get("expectedWelcomeText").trim(), "Welcome text mismatch"
        );

        softAssert.assertAll();
    }

    //TC 02: Verify that user is able to log in successfully
    @Given("user is on the login page")
    public void userIsOnLoginPage() {
        boolean isOnLoginPage = registerPage.verifyUserIsOnLoginPage();
        softAssert.assertTrue(isOnLoginPage, "User is NOT on login page");
        softAssert.assertAll();
    }

    @When("user enters login details")
    public void userEntersLoginDetails() {
        System.out.println("Scenario 2:" + RegisterPage.uniqueUserName);
        registerPage.enterLoginCredentials(RegisterPage.uniqueUserName, userPassword);
    }

    @And("clicks on login button")
    public void clicksOnLoginButton() {
        registerPage.clickOnLoginButton();
    }

    @Then("user should be login successfully")
    public void userShouldBeLoginSuccess() {
        String actualWelcomeText = registerPage.verifyUserLoggedInSuccessfully();
        softAssert.assertEquals(
                actualWelcomeText.trim(),
                RegisterPage.uniqueUserName, "Logged-in username mismatch"
        );

        softAssert.assertAll();
    }
}
