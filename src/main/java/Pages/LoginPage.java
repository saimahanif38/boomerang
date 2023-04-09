package Pages;
import Util.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage extends BaseTests {

    WebDriverWait wait;

    @FindBy(id ="email")
    WebElement email;

    @FindBy(id ="password")
    WebElement userpass;

    private final By loginButtonLocator = By.id("btn-login");
    @FindBy(id ="btn-login")
    WebElement loginButton;

    private final By errorMessageLocator = By.id("error-message");
    @FindBy(id = "error-message")
    WebElement errorMsg;

    public LoginPage()
    {
        PageFactory.initElements(driver, this);
//        this.wait = new WebDriverWait(driver, 30);
    }

    public void waitForElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Wait for an element" + locator.toString());
            e.printStackTrace();

        }
    }

    public void setUsernameAndPassword(String username, String password) throws InterruptedException {
//        waitForElementPresent(loginButtonLocator);
//        email.clear();
//        userpass.clear();
//        email.sendKeys(username);
//        userpass.sendKeys(password)//        ;
        WebElement gmail = driver.findElement(By.id("com.baydin.boomerang:id/account_selector_gmail"));
        gmail.click();
        Thread.sleep(6000);
        driver.findElement(By.className("android.widget.EditText")).sendKeys("losshello2@gmail.com");
        WebElement continue_button = driver.findElement(By.id("com.baydin.boomerang:id/accountEmailAddressSubmit"));
        continue_button.click();
        Thread.sleep(8000);
    }
}
