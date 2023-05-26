package Pages;

import Util.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ComposeMailPage extends BaseTests {
    WebDriverWait wait;
    String successMessage = "";
    private final By emailToTextField = By.id("com.baydin.boomerang:id/compose_to");
    private final By sendLaterButton = By.id("com.baydin.boomerang:id/compose_sendlater");
    private final By subjectTextField = By.id("com.baydin.boomerang:id/compose_subject");
    private final By sentMailButton = By.id("com.baydin.boomerang:id/compose_send");
    private final By successMessageToaster = By.xpath("/hierarchy/android.widget.Toast");//className("android.widget.Toast");
    private final By composeMailField = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View");
    private final By calendarButton = By.id("com.baydin.boomerang:id/imgBtnBoomerang");
    private final By suggestButton = By.id("com.baydin.boomerang:id/compose_to_container");
    private final By title = By.id("com.baydin.boomerang:id/etTitle");
    private final By addGuestButton = By.id("com.baydin.boomerang:id/tvGuest");
    private final By guestEmail = By.id("com.baydin.boomerang:id/compose_to");
    private final By doneButton = By.id("com.baydin.boomerang:id/done");
    private final By suggestTimesButton = By.id("com.baydin.boomerang:id/layoutSuggestTime");
    private final By durationButton = By.id("com.baydin.boomerang:id/duration");
    private final By twentyFiveMin = By.id("com.baydin.boomerang:id/tv25Minutes");
    private final By time = By.xpath("//*[@bounds='[0,562][1080,772]']");///"//*[@bounds='[0,669][1080,909]']");  [0,523][1080,733]  [0,736][1440,799]
    private final By addDescription = By.id("com.baydin.boomerang:id/etAddDescription");
    private final By closeButton = By.id("com.baydin.boomerang:id/insert");

    public ComposeMailPage() {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void sendLaterButtonExists() throws InterruptedException {
        waitForElementPresent(sendLaterButton);
        driver.findElement(sendLaterButton).isDisplayed();
    }

    public void typeReceiverEmail(String email) throws InterruptedException {
        Thread.sleep(4000);
        waitForElementPresent(emailToTextField);
        driver.findElement(emailToTextField).sendKeys(email);
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

    public void clickOnCalendar(){
        waitForElementPresent(calendarButton);
        driver.findElement(calendarButton).click();
    }

    public void clickSuggestButton(){
        waitForElementPresent(suggestButton);
        driver.findElement(suggestButton).click();
    }

    public void setTitle(String text) throws InterruptedException {
        Thread.sleep(4000);
        waitForElementPresent(title);
        driver.findElement(title).clear();
        driver.findElement(title).sendKeys(text);
    }

    public void addGuests(String guestMail){
        waitForElementPresent(addGuestButton);
        driver.findElement(addGuestButton).click();
        waitForElementPresent(guestEmail);
        driver.findElement(guestEmail).sendKeys(guestMail);
    }

    public void clickOnDoneButton() throws InterruptedException {
        Thread.sleep(2000);
        waitForElementPresent(doneButton);
        driver.findElement(doneButton).click();
        Thread.sleep(2000);
    }

    public void suggestedTimesButton(){
        waitForElementPresent(suggestTimesButton);
        driver.findElement(suggestTimesButton).click();
    }

    public void clickOnDurationButton(){
        waitForElementPresent(durationButton);
        driver.findElement(durationButton).click();
    }

    public void clickOn25Minute(){
        waitForElementPresent(twentyFiveMin);
        driver.findElement(twentyFiveMin).click();
    }

    public void clickTime(){
        waitForElementPresent(time);
        driver.findElement(time).click();
    }

    public void setDescripton(){
        waitForElementPresent(addDescription);
        driver.findElement(addDescription).clear();
        driver.findElement(addDescription).sendKeys("Test Meeting Setting for Automation");
    }

    public void clickCloseButton(){
        waitForElementPresent(closeButton);
        driver.findElement(closeButton).click();
    }
}
