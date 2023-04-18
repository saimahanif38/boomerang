package Pages;

import Util.BaseTests;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuBar extends BaseTests {

    private final By hamburgerMenu = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    private final By inboxPausedButton = By.xpath("(//android.widget.ImageView[@content-desc=\"pause now\"])[1]");
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

    public void openMenuBar() {
        waitForElementPresent(hamburgerMenu);
        driver.findElement(hamburgerMenu).click();
    }

    public void clickInboxPauseButton() {
        waitForElementPresent(inboxPausedButton);
        driver.findElement(inboxPausedButton).click();
    }
}
