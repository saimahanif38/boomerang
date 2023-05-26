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
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    @When("Login with valid credentials using outlook")
    public void loginWithValidCredentials() {
        try {
            BaseTests.setEmailAndPassword();
            loginPage = new LoginPage();
            loginPage.loginUsingOutlook(BaseTests.email, BaseTests.password);
            welcomePage = new WelcomePage();
            welcomePage.clickNextButton();
            Thread.sleep(1000);
            welcomePage.clickFinishButton();
            Thread.sleep(1000);
            welcomePage.clickSaveThemeButton();
            Thread.sleep(1000);
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    @Then("Validate user Email is logged in boomerang")
    public void validateUser() {
        try {
            homePage = new HomePage();
            userEmail = homePage.getUserEmail();
            assertEquals(userEmail, BaseTests.email, "Correct User is not logged in!");
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

}