package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.WelcomePage;
import Util.BaseTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;

public class LoginSteps extends BaseTests {

    public String userEmail = null;
    protected LoginPage loginPage;
    protected WelcomePage welcomePage;
    protected HomePage homePage;

    @Given("Getting started with mobile app")
    public void setUp() {
        try {
            BaseTests.setup();
            Thread.sleep(3000);
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    @When("Login with valid credentials {string} and {string} using outlook")
    public void loginWithValidCredentials(String username, String password) {
        try {
            loginPage = new LoginPage();
            loginPage.loginUsingOutlook(username, password);
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    @And("Complete Welcome Screen steps")
    public void movingFromWelcomeScreen() {
        try {
            welcomePage = new WelcomePage();
            welcomePage.clickNextButton();
            welcomePage.clickFinishButton();
            welcomePage.clickSaveThemeButton();
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    @Then("Validate user {string} is logged in boomerang")
    public void validateUser(String userEmailExpected) {
        try {
            homePage = new HomePage();
            userEmail = homePage.getUserEmail();
            assertEquals(userEmail, userEmailExpected, "Correct User is not logged in!");
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

}