package Pages;

import Util.BaseTests;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuBar extends BaseTests {
    private final By inboxPausedButton = By.xpath("(//android.widget.ImageView[@content-desc=\"pause now\"])[1]");
    private final By inboxButton = By.xpath("(//*[@class=\"android.widget.TextView\"])[4]");
    private final By sentButton = By.xpath("//android.widget.TextView[@bounds='[0,1096][1050,1239]']");
    private final By draftButton = By.xpath("//android.widget.TextView[@bounds='[0,1239][1050,1382]']");
    private final By spamButton = By.xpath("//android.widget.TextView[@bounds='[0,1382][1050,1525]']");
    private final By trashButton = By.xpath("//android.widget.TextView[@bounds='[0,1525][1050,1668]']");


    WebDriverWait wait;

    public MenuBar() {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void scrollDownToSendFeedback() throws InterruptedException {
        // For scroll down till the Send feedback element is found
        String uiAutomatorTextForSendFeedback = "new UiScrollable(new UiSelector().scrollable(true).index(0)).scrollIntoView(new UiSelector().resourceId(\"com.baydin.boomerang:id/drawer_feedback\"))";
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(uiAutomatorTextForSendFeedback)).click();
    }

    public void clickInboxPauseButton() {
        waitForElementPresent(inboxPausedButton);
        driver.findElement(inboxPausedButton).click();
    }

    public void clickOnInboxButton() {
        waitForElementPresent(inboxButton);
        driver.findElement(inboxButton).click();
    }

    public void clickOnSentButton() {
        waitForElementPresent(sentButton);
        driver.findElement(sentButton).click();
    }

    public void clickOnDraftButton() {
        waitForElementPresent(draftButton);
        driver.findElement(draftButton).click();
    }

    public void clickOnSpamButton() {
        waitForElementPresent(spamButton);
        driver.findElement(spamButton).click();
    }

    public void clickOnTrashButton() {
        waitForElementPresent(trashButton);
        driver.findElement(trashButton).click();
    }
}
