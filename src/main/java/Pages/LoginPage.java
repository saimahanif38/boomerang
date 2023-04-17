package Pages;

import Util.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BaseTests {

    private final By outlookLoginButton = By.id("com.baydin.boomerang:id/account_selector_outlook");
    private final By outlookSigninbutton = By.xpath("(//*[@class=\"android.widget.Button\"])[1]");
    private final By outlookNextButton = By.xpath("(//*[@class=\"android.widget.Button\"])[2]");
    private final By outlookEmailInputField = By.className("android.widget.EditText");
    private final By outlookPasswordInputField = By.className("android.widget.EditText");

    private final By staySignedinYesbutton = By.xpath("(//*[@class=\"android.widget.Button\"])[2]");

    WebDriverWait wait;

    public LoginPage() {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    public void loginUsingOutlook(String username, String password) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(outlookLoginButton)).click();
        waitForElementPresent(outlookEmailInputField);
        driver.findElement(outlookEmailInputField).sendKeys(username);
        waitForElementPresent(outlookNextButton);
        driver.findElement(outlookNextButton).click();
        Thread.sleep(1000);
        waitForElementPresent(outlookPasswordInputField);
        driver.findElement(outlookPasswordInputField).sendKeys(password);
        waitForElementPresent(outlookSigninbutton);
        driver.findElement(outlookSigninbutton).click();
        Thread.sleep(1000);
        waitForElementPresent(staySignedinYesbutton);
        driver.findElement(staySignedinYesbutton).click();
        Thread.sleep(6000);
    }

//    public void setUsernameAndPassword(String username, String password) throws InterruptedException {
    //        WebElement gmail = driver.findElement(By.id("com.baydin.boomerang:id/account_selector_gmail"));
//        gmail.click();
//        Thread.sleep(6000);
//        driver.findElement(By.className("android.widget.EditText")).sendKeys("bmrngemail@gmail.com");
//        WebElement continue_button = driver.findElement(By.id("com.baydin.boomerang:id/accountEmailAddressSubmit"));
//        continue_button.click();
//        Thread.sleep(9000);
//
//
//        //enter Password
//        driver.findElement(By.xpath("(//*[@class=\"android.widget.Button\"])[2]")).click();
//        Thread.sleep(6000);
////        driver.findElement(By.className("android.widget.EditText")).sendKeys("losshello2@gmail.com");
////        driver.findElement(By.xpath("(//*[@class=\"android.widget.Button\"])[1]")).click();
////        Thread.sleep(9000);
//        driver.findElement(By.className("android.widget.EditText")).sendKeys("bmrngemail@gmail.com");
////        driver.findElement(By.className("android.widget.CheckBox")).click();
////        Thread.sleep(3000);
//        driver.findElement(By.xpath("(//*[@class=\"android.widget.Button\"])[1]")).click();
//      Thread.sleep(6000);
//      driver.findElement(By.xpath("(//*[@class=\"android.widget.EditText\"])[1]")).sendKeys("boomerang");
//        driver.findElement(By.xpath("(//*[@class=\"android.widget.EditText\"])[2]")).sendKeys("email");
//        driver.findElement(By.xpath("(//*[@class=\"android.widget.Button\"])[1]")).click();
//
//        Thread.sleep(6000);
//
////        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View[2]/android.view.View[5]/android.view.View")).click();
//      Thread.sleep(10000);
//    }
}
