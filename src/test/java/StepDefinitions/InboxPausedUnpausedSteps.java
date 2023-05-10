package StepDefinitions;

import Pages.*;
import Util.BaseTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class InboxPausedUnpausedSteps {
    protected MenuBar menuBar;
    protected InboxPaused inboxPaused = new InboxPaused();
    protected HomePage homePage;

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

    @And("Change the auto-responder text")
    public void changeTheAutoResponderText() throws IOException {
        String text = BaseTests.setAutoResponderText();
        inboxPaused.setAutoResponderText(text);
    }

    @And("Set the unpause automatically")
    public void setTheUnpauseAutomatically() {
        inboxPaused.clickOnUnpauseAutomaticallyToggle();
        inboxPaused.clickOnAfter2Hour();
        inboxPaused.setDate();
        inboxPaused.setDay();
        inboxPaused.clickOkButton();
//        inboxPaused.clickOnClock();
//        inboxPaused.setTime();
//        inboxPaused.clickOkButton();
        inboxPaused.clickOnSaveButton();
    }

    @Then("Pause the inbox")
    public void inboxPaused() {
        try {
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
