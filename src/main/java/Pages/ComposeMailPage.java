package Pages;

import Util.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ComposeMailPage extends BaseTests {
    WebDriverWait wait;
    String successMessage = "";
    private final By emailtoTextField = By.id("com.baydin.boomerang:id/compose_to");
    private final By sendLaterButton = By.id("com.baydin.boomerang:id/compose_sendlater");
    private final By subjectTextField = By.id("com.baydin.boomerang:id/compose_subject");
    private final By sentMailButton = By.id("com.baydin.boomerang:id/compose_send");
    private final By successMessageToaster = By.xpath("/hierarchy/android.widget.Toast");//className("android.widget.Toast");
    private final By composeMailField = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View");

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

    public void typeEmailBody(String emailText){
        waitForElementPresent(composeMailField);
        driver.findElement(composeMailField).clear();
        driver.findElement(composeMailField).sendKeys(emailText);
    }

    public void clickOnSendEmail(){
        driver.findElement(sentMailButton).click();
    }

    public String validateSucessMessage(){
        waitForElementPresent(successMessageToaster);
        successMessage = driver.findElement(successMessageToaster).getText();
        return successMessage;
    }
}
