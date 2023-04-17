package Util;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTests {

    public static AppiumDriver driver;
    WebDriverWait wait;

    public static void setup() throws MalformedURLException {
        clearBrowser();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "android");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformVersion", "9");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("appPackage","com.baydin.boomerang");
        cap.setCapability("app","C:/Users/saimahanif/Downloads/boomerangandroid-prod-release.apk");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(url, cap);
    }

    public void waitForElementPresent(By locator) {
        try {
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Wait for an element" + locator.toString());
            e.printStackTrace();

        }
    }

    public static void clearBrowser() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        cap.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, "true");
        cap.setCapability("fullReset", "true");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
    }
    public static void tearDown() {
        driver.quit();
    }
}