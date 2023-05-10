package Pages;

import Util.BaseTests;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InboxPaused extends BaseTests {

    private final By pausedNow = By.id("com.baydin.boomerang:id/layoutPauseNow");
    private final By verificationText = By.xpath("(//*[class=\"android.widget.TextView\"])[1]");
    private final By okayGotItButton = By.id("com.baydin.boomerang:id/tvOkayGotIt");
    private final By unpauseButton = By.id("com.baydin.boomerang:id/layoutUnpause");
    private final By autoResponderText = By.id("com.baydin.boomerang:id/etBody");
    private final By unpauseAutomaticallyToggle = By.id("com.baydin.boomerang:id/switchCompatUnPause");
    private final By unpauseAutomaticallyText = By.id("com.baydin.boomerang:id/tvUnpauseText");
    private final By clock = By.id("com.baydin.boomerang:id/boomerang_specific_time");
    private final By okButton = By.id("android:id/button1");
    private final By saveButton = By.id("com.baydin.boomerang:id/boomerang_confirm");
    private final By date = By.id("com.baydin.boomerang:id/boomerang_specific_date");
    WebDriverWait wait;

    public InboxPaused() {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickOnInboxPausedButton() {
        waitForElementPresent(pausedNow);
        driver.findElement(pausedNow).click();
    }

    public void clickOnGotItButton() {
        waitForElementPresent(okayGotItButton);
        driver.findElement(okayGotItButton).click();
    }

    public String getVerificationText() {
        waitForElementPresent(verificationText);
        return driver.findElement(verificationText).getText();
    }

    public void clickOnUnpauseButton() {
        waitForElementPresent(unpauseButton);
        driver.findElement(unpauseButton).click();
    }

    public void validatePauseButtonIsVisible() {
        waitForElementPresent(pausedNow);
        driver.findElement(pausedNow).isEnabled();
    }

    public void setAutoResponderText(String text){
        waitForElementPresent(autoResponderText);
        driver.findElement(autoResponderText).clear();
        driver.findElement(autoResponderText).sendKeys(text);
    }

    public void clickOnUnpauseAutomaticallyToggle(){
        driver.findElement(unpauseAutomaticallyToggle).click();
    }

    public void clickOnAfter2Hour(){
        driver.findElement(unpauseAutomaticallyText).click();
    }

    public void clickOnClock(){
        waitForElementPresent(clock);
        driver.findElement(clock).click();
    }

    public void setTime(){
        String uiAutomatorTextForMinutes = "new UiScrollable(new UiSelector().scrollable(true).index(2)).scrollIntoView(new UiSelector().textMatches(\"20\"))";
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(uiAutomatorTextForMinutes)).click();
    }

    public void setDate(){
        waitForElementPresent(date);
        driver.findElement(date).click();
    }

    public void setDay(){
        String uiAutomatorTextForDay = "new UiScrollable(new UiSelector().scrollable(true).index(1)).scrollIntoView(new UiSelector().textMatches(\"12\"))";
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(uiAutomatorTextForDay)).click();
    }

    public void clickOkButton(){
        waitForElementPresent(okButton);
        driver.findElement(okButton).click();
    }

    public void clickOnSaveButton(){
        waitForElementPresent(saveButton);
        driver.findElement(saveButton).click();
    }
}
