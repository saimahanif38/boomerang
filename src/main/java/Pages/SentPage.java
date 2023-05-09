package Pages;

import Util.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SentPage extends BaseTests {
    private final By titleOfPage = By.xpath("(//*[@class=\"android.widget.TextView\"])[1]");
    private final By topEmail = By.xpath("(//android.widget.TextView[@content-desc=\"subject\"])[1]");

    WebDriverWait wait;

    public SentPage() {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public String getTitleOfPage() {
        waitForElementPresent(titleOfPage);
        return driver.findElement(titleOfPage).getText();
    }

    public void clickOnTopEmail(){
        waitForElementPresent(topEmail);
        driver.findElement(topEmail).click();
    }
}
