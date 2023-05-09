package StepDefinitions;

import Pages.*;
import Util.BaseTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;

public class InboxPausedUnpausedSteps {

    protected LoginPage loginPage;
    protected WelcomePage welcomePage;
    protected MenuBar menuBar;
    protected InboxPaused inboxPaused;
    protected HomePage homePage;

    @When("Login with valid credentials using outlook")
    public void loginWithValidCredentials() {
        try {
            BaseTests.setEmailAndPassword();
            BaseTests.setup();
            loginPage = new LoginPage();
            loginPage.loginUsingOutlook(BaseTests.email, BaseTests.password);
            welcomePage = new WelcomePage();
            welcomePage.clickNextButton();
            welcomePage.clickFinishButton();
            welcomePage.clickSaveThemeButton();
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    @And("Go to the menu bar and inbox pause")
    public void goToMenuBar() {
        try {
            homePage = new HomePage();
            homePage.clickOnMenuButton();
            menuBar = new MenuBar();
            menuBar.clickInboxPauseButton();
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    @Then("Pause the inbox")
    public void inboxPaused() {
        try {
            inboxPaused = new InboxPaused();
            inboxPaused.clickOnInboxPausedButton();
            inboxPaused.clickOnGotItButton();
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    @Then("Validate inbox is paused now")
    public void validationPausedInbox() {
        try {
            homePage = new HomePage();
            homePage.clickOnMenuButton();
            menuBar = new MenuBar();
            menuBar.clickInboxPauseButton();
            inboxPaused = new InboxPaused();
            String verificationText = inboxPaused.getVerificationText();
            assertEquals(verificationText, "Your Inbox is currently paused.", "Correct User is not logged in!");
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    @Then("Unpause the inbox")
    public void unpauseTheInbox() {
        try {
            inboxPaused = new InboxPaused();
            inboxPaused.clickOnUnpauseButton();
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    @Then("Validate inbox is unpause now")
    public void validateInboxIsUnpauseNow() {
        try {
            homePage = new HomePage();
            homePage.clickOnMenuButton();
            menuBar = new MenuBar();
            menuBar.clickInboxPauseButton();
            inboxPaused = new InboxPaused();
            inboxPaused.validatePauseButtonIsVisible();
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
}
