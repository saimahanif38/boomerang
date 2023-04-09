package Util;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTests {

    public static AppiumDriver driver;

    public static void setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "android");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformVersion", "9");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("appPackage","com.baydin.boomerang");
        cap.setCapability("appActivity","com.baydin.boomerang.AccountTypeSelectorActivity");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(url, cap);
    }

//    public static void tearDown() {
//        driver.quit();
//    }
}