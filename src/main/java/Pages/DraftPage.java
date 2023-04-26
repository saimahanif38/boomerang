package Pages;

import Util.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DraftPage extends BaseTests {
    private final By titleOfPage = By.xpath("(//*[@class=\"android.widget.TextView\"])[1]");

    WebDriverWait wait;

    public DraftPage() {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public String getTitleOfPage() {
        waitForElementPresent(titleOfPage);
        return driver.findElement(titleOfPage).getText();
    }
}
