package Pages;

import Util.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BaseTests {
    WebDriverWait wait;

    private final By userEmail = By.xpath("(//*[@class=\"android.widget.TextView\"])[1]");

    public String userEmailString = null;

    public HomePage() {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public String getUserEmail(){
        waitForElementPresent(userEmail);
        userEmailString = driver.findElement(userEmail).getText();
        return userEmailString;
    }


}
