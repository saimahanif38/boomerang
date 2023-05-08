package Pages;

import Util.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ComposeMailPage extends BaseTests {
    WebDriverWait wait;
    private final By emailtoTextField = By.id("com.baydin.boomerang:id/compose_to");
    private final By sendLaterButton = By.id("com.baydin.boomerang:id/compose_sendlater");
    private final By subjectTextField = By.id("com.baydin.boomerang:id/compose_subject");

    public ComposeMailPage() {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void sendLaterButtonExists(){
        waitForElementPresent(sendLaterButton);
        driver.findElement(sendLaterButton).isDisplayed();
    }

    public void typeReceiverEmail(String email){
        waitForElementPresent(emailtoTextField);
        driver.findElement(emailtoTextField).sendKeys(email);
    }

    public void typeSubjectOfEmail(String subject){
        waitForElementPresent(subjectTextField);
        driver.findElement(subjectTextField).sendKeys(subject);
    }

    public void typeEmail(String subject){
        waitForElementPresent(subjectTextField);
        driver.findElement(subjectTextField).sendKeys(subject);
    }
}
