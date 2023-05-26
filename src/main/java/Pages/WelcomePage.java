package Pages;

import Util.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WelcomePage extends BaseTests {
    private final By nextButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView[2]");
    private final By finishButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView[2]");
    private final By saveThemeButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button[2]");
    WebDriverWait wait;

    public WelcomePage() {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickNextButton() throws InterruptedException {
        Thread.sleep(1000);
        waitForElementPresent(nextButton);
        driver.findElement(nextButton).click();
        Thread.sleep(1000);
        waitForElementPresent(nextButton);
        driver.findElement(nextButton).click();
        Thread.sleep(1000);
        waitForElementPresent(nextButton);
        driver.findElement(nextButton).click();
        Thread.sleep(2000);
        waitForElementPresent(nextButton);
        driver.findElement(nextButton).click();
        Thread.sleep(1000);
        waitForElementPresent(nextButton);
        driver.findElement(nextButton).click();
        Thread.sleep(1000);
        waitForElementPresent(nextButton);
        driver.findElement(nextButton).click();
        Thread.sleep(1000);
        waitForElementPresent(nextButton);
        driver.findElement(nextButton).click();
        Thread.sleep(2000);
        waitForElementPresent(nextButton);
        driver.findElement(nextButton).click();
        Thread.sleep(1000);
    }

    public void clickFinishButton() throws InterruptedException {
        Thread.sleep(2000);
        waitForElementPresent(finishButton);
        driver.findElement(finishButton).click();
    }

    public void clickSaveThemeButton() throws InterruptedException {
        Thread.sleep(2000);
        waitForElementPresent(saveThemeButton);
        driver.findElement(saveThemeButton).click();
    }
}
