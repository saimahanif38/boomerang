package Pages;

import Util.BaseTests;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BrowserOutlookPage extends BaseTests {
    private final By outlookNextButton = By.id("idSIButton9");
    private final By outlookEmailInputField =By.id("i0116");
    private final By outlookPasswordInputField = By.id("i0118");
    private final By topMail = By.xpath("(//*[@class=\"S2NDX\"])[1]");
    private final By threeDots = By.xpath("//*[@id=\"read_ellipses_menu\"]");
    private final By boomerangButton = By.xpath("(//*[@name=\"Boomerang\"])[2]");
    private final By inboxPausedButton = By.id("inboxpause");
    private final By outlookLoginButton = By.xpath("//*[contains(text(),\"Sign in with your Outlook account\")]"); //"//*[@class=\"preAuthContent\"]/div[3]/button");
    private final By textForInboxPaused = By.xpath("//*[@class=\"pause-status\"]/p[1]");
    private final By inboxPausedMailText = By.xpath("//*[@aria-label=\"Message body\"]/div/div/div/p[1]");
    private final By newMailButton = By.xpath("//*[@data-icon-name=\"MailRegular\"]");
    private final By to = By.xpath("//*[@aria-label=\"To\"]");
    private final By subject = By.xpath("//*[@aria-label=\"Add a subject\"]");
    private final By messageBody = By.xpath("//*[@aria-label=\"Message body, press Alt+F10 to exit\"]");
    private final By sendButton = By.xpath("(//*[@aria-label=\"Send\"])[2]");
    private final By closeButton = By.xpath("//*[@aria-label=\"Close Boomerang dialogue\"]");
    private final By inboxFolderButton = By.xpath("//*[contains(text(),\"Inbox-Paused-2023-\")]");
    String unpausedExpectedText = "Your Inbox is currently paused.";
    public BrowserOutlookPage(){
        PageFactory.initElements(BaseTests.webDriver, this);
    }
    public void loginOnOutlookWeb(String email, String password) throws InterruptedException {
        Thread.sleep(4000);
        waitForElementPresentWeb(outlookEmailInputField);
        webDriver.findElement(outlookEmailInputField).sendKeys(email);
        Thread.sleep(2000);
        waitForElementPresentWeb(outlookNextButton);
        webDriver.findElement(outlookNextButton).click();
        Thread.sleep(5000);
        waitForElementPresentWeb(outlookPasswordInputField);
        webDriver.findElement(outlookPasswordInputField).sendKeys(password);
        Thread.sleep(3000);
        waitForElementPresentWeb(outlookNextButton);
        webDriver.findElement(outlookNextButton).click();
        Thread.sleep(3000);
        waitForElementPresentWeb(outlookNextButton);
        webDriver.findElement(outlookNextButton).click();
    }
    public void clickOnTopMail() throws InterruptedException {
        waitForElementPresentWeb(topMail);
        webDriver.findElement(topMail).click();
        Thread.sleep(7000);
    }
    public void validateTopMailText(String expectedString) throws InterruptedException {
        Thread.sleep(3000);
        waitForElementPresentWeb(inboxPausedMailText);
        String text  = webDriver.findElement(inboxPausedMailText).getText();
        assertTrue(text.contains(expectedString));
    }
    public void clickOnThreeDots(){
        waitForElementPresentWeb(threeDots);
        webDriver.findElement(threeDots).click();
    }

    public void clickOnBoomerang(){
        waitForElementPresentWeb(boomerangButton);
        webDriver.findElement(boomerangButton).click();
    }

    public void clickOnInboxPausedOption() throws InterruptedException {
        waitForElementPresentWeb(inboxPausedButton);
        webDriver.findElement(inboxPausedButton).click();
        Thread.sleep(12000);
    }
    public void loginWithOutlookAndVerifyInboxPause() throws InterruptedException {
        //Switch to iframe
        webDriver.switchTo().frame(2);
        waitForElementPresentWeb(outlookLoginButton);
        webDriver.findElement(outlookLoginButton).click();
        Thread.sleep(2000);
        waitForElementPresentWeb(textForInboxPaused);
        String unpauseText = webDriver.findElement(textForInboxPaused).getText();
        assertEquals(unpauseText, unpausedExpectedText, "Assertion Failed on validating inbox paused");
        webDriver.switchTo().defaultContent();
    }

    public void composeEmail(String toMail, String subjectText, String messageBodyText) throws InterruptedException {
        Thread.sleep(4000);

        // Click on new mail button
        waitForElementPresentWeb(newMailButton);
        webDriver.findElement(newMailButton).click();
        Thread.sleep(2000);

        // Add Participants
        waitForElementPresentWeb(to);
        webDriver.findElement(to).click();
        webDriver.findElement(to).sendKeys("boomerangqa@outlook.com");
        Thread.sleep(2000);

        // Add title
        waitForElementPresentWeb(subject);
        webDriver.findElement(subject).sendKeys(subjectText);
        Thread.sleep(2000);
        // Add body
        waitForElementPresentWeb(messageBody);
        webDriver.findElement(messageBody).sendKeys(messageBodyText);
        Thread.sleep(2000);
        // Click on Send button
        waitForElementPresentWeb(sendButton);
        webDriver.findElement(sendButton).click();

        Thread.sleep(10000);
    }

    public void validateEmailreceivedInInboxPausedFolder() throws InterruptedException {
        Thread.sleep(2000);
        WebElement scroll = webDriver.findElement(inboxFolderButton);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", scroll);
        Thread.sleep(2000);
        scroll.click();
    }

    public void clickOnCloseButton() throws InterruptedException {
        Thread.sleep(4000);

        // Click on new mail button
        waitForElementPresentWeb(closeButton);
        webDriver.findElement(closeButton).click();
        Thread.sleep(2000);
    }
}
