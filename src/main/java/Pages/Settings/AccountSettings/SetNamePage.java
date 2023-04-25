package Pages.Settings.AccountSettings;

import Util.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SetNamePage extends BaseTests {
    private final By nameButton = (By.id("com.baydin.boomerang:id/settings_account_name"));

    private final By nameField = (By.id("com.baydin.boomerang:id/settings_name_text"));

    private final By save_button = (By.id("android:id/button1"));

    private final By name_text = (By.id("com.baydin.boomerang:id/current_name"));




    WebDriverWait wait;

    public SetNamePage() {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void setName(){
        waitForElementPresent(nameButton);
        driver.findElement(nameButton).click();

        waitForElementPresent(nameField);
        driver.findElement(nameField).sendKeys("Folio3Tester");

        waitForElementPresent(save_button);
        driver.findElement(save_button).click();

        waitForElementPresent(name_text);
        Assert.assertEquals("Folio3Tester", driver.findElement(name_text).getText());

    }

}
