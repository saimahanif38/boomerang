package Pages;

import Util.BaseTests;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BaseTests {
    WebDriverWait wait;

    private final By userEmail = By.className("android.widget.TextView");

    public HomePage() {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void getUserEmail(){
        waitForElementPresent(userEmail);
        List<WebElement> t = driver.findElements(userEmail);
        System.out.println("print");
    }


}
