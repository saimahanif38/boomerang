package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.WelcomePage;
import Util.BaseTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseTests {

    protected LoginPage loginPage;
    protected WelcomePage welcomePage;

    protected HomePage homePage;

    @Given("Getting started with mobile app")
    public void setUp()
    {
        try{
            BaseTests.setup();
            Thread.sleep(3000);
        }
        catch (Exception exp){
            System.out.println(exp);
        }
    }
    @When("Login with valid credentials {string} and {string} using outlook")
    public void loginWithValidCredentials(String username, String password){
        try{
            loginPage = new LoginPage();
            loginPage.loginUsingOutlook(username, password);
        }
        catch (Exception exp) {
            System.out.println(exp);
        }
    }
    @And("Complete Welcome Screen steps")
    public void movingFromWelcomeScreen(){
        try{
            welcomePage = new WelcomePage();
            welcomePage.clickNextButton();
            welcomePage.clickFinishButton();
            welcomePage.clickSaveThemeButton();
        }
        catch (Exception exp) {
            System.out.println(exp);
        }
    }

    @Then("Validate user is logged in boomerang")
    public void validateUser(){
        try{
            homePage = new HomePage();
            homePage.getUserEmail();
        }
        catch (Exception exp) {
            System.out.println(exp);
        }
    }

}