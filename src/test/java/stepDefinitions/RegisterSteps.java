package stepDefinitions;

import base.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.RegisterPage;

import java.util.Map;

public class RegisterSteps {

    RegisterPage registerPage;
    String uniqueUserName = "user_"+ System.currentTimeMillis();
    SoftAssert softAssert = new SoftAssert();

    @Given("user is on the registration page")
    public void userIsOnRegistrationPage() {
        registerPage = new RegisterPage();
        registerPage.navigateToRegisterPage();
        Assert.assertTrue(registerPage.validateUserOnRegisterPage());
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
                uniqueUserName,
                data.get("password")
        );
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
        softAssert.assertTrue(actualWelcomeMessage.contains(uniqueUserName));
        softAssert.assertEquals(actualWelcomeText, data.get("expectedWelcomeText"));
        softAssert.assertAll();
    }

}
