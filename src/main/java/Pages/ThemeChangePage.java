package Pages;

import Util.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ThemeChangePage extends BaseTests {
    private final By themeButton = (By.id("com.baydin.boomerang:id/settings_account_theme"));

    private final By themeOptionButton = (By.xpath("(//android.widget.ImageView[@content-desc='Theme Thumbnail'])[2]"));

    private final By themeSaveButton = (By.id("com.baydin.boomerang:id/settings_account_theme_confirm"));

    WebDriverWait wait;

    public ThemeChangePage() {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    public void changeTheme(){
        waitForElementPresent(themeButton);
        driver.findElement(themeButton).click();

        waitForElementPresent(themeOptionButton);
        driver.findElement(themeOptionButton).click();

        waitForElementPresent(themeSaveButton);
        driver.findElement(themeSaveButton).click();
    }

}
