package Pages;

import Util.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InboxPaused extends BaseTests {

    WebDriverWait wait;
    private final By pausedNow = By.id("com.baydin.boomerang:id/layoutPauseNow");
    private final By verificationText = By.xpath("(//*[class=\"android.widget.TextView\"])[1]");
    private final By okayGotItButton = By.id("com.baydin.boomerang:id/tvOkayGotIt");
    private final By unpauseButton = By.id("com.baydin.boomerang:id/layoutUnpause");
    public InboxPaused(){
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickOnInboxPausedButton(){
        waitForElementPresent(pausedNow);
        driver.findElement(pausedNow).click();
    }
    public void clickOnGotItButton(){
        waitForElementPresent(okayGotItButton);
        driver.findElement(okayGotItButton).click();
    }

    public String getVerificationText(){
        waitForElementPresent(verificationText);
        return driver.findElement(verificationText).getText();
    }

    public void clickOnUnpauseButton(){
        waitForElementPresent(unpauseButton);
        driver.findElement(unpauseButton).click();
    }

    public void validatePauseButtonIsVisible(){
        waitForElementPresent(pausedNow);
        driver.findElement(pausedNow).isEnabled();
    }
}
