package Pages;

import Util.BaseTests;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class MenuBar extends BaseTests {
    public void scrollDownToSendFeedback() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
        Thread.sleep(2000);
        //For scroll down
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).index(0)).scrollIntoView(new UiSelector().resourceId(\"com.baydin.boomerang:id/drawer_feedback\"))")).click(); //scroll down to the element and click
    }
}
