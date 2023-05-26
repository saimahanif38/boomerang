package Pages;

import Util.BaseTests;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuBar extends BaseTests {
    private final By inboxPausedButton = By.xpath("(//android.widget.ImageView[@content-desc=\"pause now\"])[1]");
    private final By inboxButton = By.xpath("//android.widget.TextView[@text='Inbox']");//("(//*[@class=\"android.widget.TextView\"])[4]");

    private final By sentButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[4]/android.widget.TextView");
    private final By draftButton = By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[5]/android.widget.TextView");
    private final By spamButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[6]/android.widget.TextView");
    private final By trashButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[7]/android.widget.TextView");
    private final By inboxPausedFolder = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[6]/android.widget.TextView");
            //By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.TextView");
            //
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

    public void clickInboxPauseButton() throws InterruptedException {
        Thread.sleep(2000);

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

    public String inboxPausedFolderText(){
        waitForElementPresent(inboxPausedFolder);
        return driver.findElement(inboxPausedFolder).getText();
    }

    public void clickOnInboxPausedFolderNewlyCreated(){
        waitForElementPresent(inboxPausedFolder);
        driver.findElement(inboxPausedFolder).click();
    }
}
