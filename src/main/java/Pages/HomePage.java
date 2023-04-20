package Pages;

import Util.BaseTests;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BaseTests {
    private final By userEmail = By.xpath("(//*[@class=\"android.widget.TextView\"])[1]");
    private final By menuButton = (By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));

    private final By accountSettingsButton = (By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.Button[2]"));

    public String userEmailString = null;
    WebDriverWait wait;

    public HomePage() {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public String getUserEmail() {
        waitForElementPresent(userEmail);
        userEmailString = driver.findElement(userEmail).getText();
        return userEmailString;
    }

    public void clickOnMenuButton(){
        waitForElementPresent(menuButton);
        driver.findElement(menuButton).click();
    }

    public void clickOnSettingsButton(){
        String uiAutomatorTextForSendFeedback = "new UiScrollable(new UiSelector().scrollable(true).index(0)).scrollIntoView(new UiSelector().resourceId(\"com.baydin.boomerang:id/drawer_settings\"))";
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(uiAutomatorTextForSendFeedback)).click();
    }

    public void clickOnAccountSettingsButton(){
        waitForElementPresent(accountSettingsButton);
        driver.findElement(accountSettingsButton).click();
    }

}
