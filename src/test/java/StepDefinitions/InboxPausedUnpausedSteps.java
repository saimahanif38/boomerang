package StepDefinitions;

import Pages.*;
import Util.BaseTests;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static Util.BaseTests.webDriver;
import static org.testng.Assert.*;

public class InboxPausedUnpausedSteps {
    protected MenuBar menuBar = new MenuBar();
    protected InboxPaused inboxPaused = new InboxPaused();
    protected HomePage homePage = new HomePage();
    String inboxFolderTextExpected = "Inbox-Paused-2023-", inboxFolderText = null;
    protected BrowserOutlookPage browserOutlookPage = new BrowserOutlookPage();
    String expectedString = "Your Inbox is paused";

    @And("Go to the menu bar and inbox pause")
    public void goToMenuBar() {
        try {

            homePage.clickOnMenuButton();
            Thread.sleep(5000);
            homePage.clickOnMenuButton();
            Thread.sleep(2000);
            menuBar.clickInboxPauseButton();
            Thread.sleep(2000);
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    @And("Go to the menu bar and inbox pause button")
    public void goToMenubar() {
        try {
            homePage.clickOnMenuButton();
            Thread.sleep(2000);
            menuBar.clickInboxPauseButton();
            Thread.sleep(2000);
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }


    @And("Go to the menu bar open new folder and check the email received in it")
    public void checknewMail() {
        try {
            homePage.clickOnMenuButton();
            Thread.sleep(2000);
            menuBar.clickOnInboxPausedFolderNewlyCreated();
            Thread.sleep(2000);
            inboxPaused.openTopMail();
            Thread.sleep(8000);

        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    @And("Change the auto-responder text")
    public void changeTheAutoResponderText() throws IOException {
        String text = BaseTests.setAutoResponderText();
        inboxPaused.setAutoResponderText(text);
    }

    @And("Set the unpause automatically and day")
    public void setTheUnpauseAutomatically() throws InterruptedException {
//        inboxPaused.clickOnUnpauseAutomaticallyToggle();
        inboxPaused.clickOnAfter2Hour();
        inboxPaused.setDate();
        inboxPaused.setDay();
        inboxPaused.clickOkButton();
//        inboxPaused.clickOnClock();
//        inboxPaused.setTime();
//        inboxPaused.clickOkButton();
        inboxPaused.clickOnSaveButton();
    }

    @And("Pause the inbox")
    public void inboxPaused() {
        try {
            inboxPaused.clickOnInboxPausedButton();
            inboxPaused.clickOnGotItButton();
            Thread.sleep(5000);
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    @Then("Validate inbox is paused now")
    public void validationPausedInbox() {
        try {
            homePage.clickOnMenuButton();
            menuBar.clickInboxPauseButton();
            String verificationText = inboxPaused.getVerificationText();
            assertEquals(verificationText, "Your Inbox is currently paused.", "Correct User is not logged in!");
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    @And("Unpause the inbox")
    public void unpauseTheInbox() {
        try {
            inboxPaused.clickOnUnpauseButton();
            Thread.sleep(6000);
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    @And("Validate inbox is unpause now")
    public void validateInboxIsUnpauseNow() {
        try {
            homePage.clickOnMenuButton();
            menuBar.clickInboxPauseButton();
            inboxPaused.validatePauseButtonIsVisible();
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    @And("Validate that inbox is paused on the browser too and email received in the inbox Paused folder")
    public void visitBrowser() throws InterruptedException, IOException {
        sentmail();
        BaseTests.setEmailAndPassword();
        BaseTests.setUpWebDriver();
        Thread.sleep(4000);
        browserOutlookPage.loginOnOutlookWeb(BaseTests.email, BaseTests.password);
        Thread.sleep(5000);
        browserOutlookPage.clickOnTopMail();
        Thread.sleep(3000);
        browserOutlookPage.validateTopMailText(expectedString);
        Thread.sleep(1000);
        browserOutlookPage.clickOnThreeDots();
        Thread.sleep(1000);
        browserOutlookPage.clickOnBoomerang();
        Thread.sleep(1000);
        browserOutlookPage.clickOnInboxPausedOption();
        Thread.sleep(1000);
        browserOutlookPage.loginWithOutlookAndVerifyInboxPause();
        Thread.sleep(1000);
        browserOutlookPage.clickOnCloseButton();
        Thread.sleep(1000);
        browserOutlookPage.validateEmailreceivedInInboxPausedFolder();
        Thread.sleep(1000);
        browserOutlookPage.clickOnTopMail();
        Thread.sleep(2000);
//        browserOutlookPage.validateTopMailText(BaseTests.getMessageBodyTextTestMail());
        BaseTests.tearDownWebApp();
    }

    @And("Validate that new folder is created for paused mails")
    public void validateThatNewFolderIsCreatedForPausedMails() throws InterruptedException {
        homePage.clickOnMenuButton();
        Thread.sleep(2000);
        inboxFolderText = menuBar.inboxPausedFolderText();
        assertTrue(inboxFolderText.contains(inboxFolderTextExpected));
        Thread.sleep(2000);
        BaseTests.tearDown();
    }

    public void sentmail() throws InterruptedException, IOException {
        BaseTests.setUpWebDriver();
        Thread.sleep(2000);
        String testMail = BaseTests.getText("testMail");
        String testPassword = BaseTests.getText("testPassword");
        browserOutlookPage.loginOnOutlookWeb(testMail, testPassword);
        Thread.sleep(30000);
        // compose email and send
        String subject = BaseTests.getSubjectTextTestMail();
        String messageBody = BaseTests.getMessageBodyTextTestMail();
        browserOutlookPage.composeEmail(BaseTests.email, subject, messageBody);
        // close browser
        BaseTests.closeCurrentWebApp();
    }

    @And("Check inbox paused email from inbox")
    public void checkEmailReceivedInInboxForInboxPaused() throws InterruptedException {
//        inboxPaused.openTopMail();
        Thread.sleep(3000);
//        inboxPaused.clickOnBackButton();
//        Thread.sleep(1000);
    }

    @Then("Validate the inbox-paused folder is removed, inbox pause mail is removed and new email moved in the inbox")
    public void validateTheInboxFolderIsRemoved() throws InterruptedException {
        Thread.sleep(2000);
        homePage.clickOnMenuButton();
        Thread.sleep(2000);
        inboxFolderText = menuBar.inboxPausedFolderText();
        assertFalse(inboxFolderText.contains(inboxFolderTextExpected));
        Thread.sleep(2000);
        menuBar.clickOnInboxButton();
        Thread.sleep(2000);
        BaseTests.pullDownToRefresh();
        Thread.sleep(10000);
        BaseTests.tearDown();
    }

    @And("Validate mail paused email is removed now")
    public void emailRemoved() throws InterruptedException {
        Thread.sleep(6000);
    }
}
