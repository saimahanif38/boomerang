package StepDefinitions;

import Pages.LoginPage;
import Util.BaseTests;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class LoginSteps extends BaseTests {

    protected LoginPage loginPage;

    protected String projectpath = System.getProperty("user.dir");

    protected String hostName = "", username ="", password="";

    protected String path = projectpath + "/resources/";


    @Given("user is on the mobile login page")
    public void atHomePage()
    {
        try{
            BaseTests.setup();
            Thread.sleep(3000);
        }
        catch (Exception exp){
            System.out.println(exp);
        }
    }
    @When("Login with valid credentials")
    public void login_with_valid_credentials() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        loginPage = new LoginPage();
        loginPage.setUsernameAndPassword(username, password);
    }
    @Then("Validate user is logged in")
    public void validate_user_is_logged_in() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        click_next();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
        Thread.sleep(2000);
        //For scroll down
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).index(0)).scrollIntoView(new UiSelector().resourceId(\"com.baydin.boomerang:id/drawer_feedback\"))")).click(); //scroll down to the element and click
    }


    public static void click_next() throws InterruptedException {
        //click on next eight times then click on Finish
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView[2]")).click();

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView[2]")).click();

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView[2]")).click();

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView[2]")).click();

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView[2]")).click();

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView[2]")).click();

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView[2]")).click();

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView[2]")).click();

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView[2]")).click();

        Thread.sleep(2000);
        //Save the theme
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button[2]")).click();
        Thread.sleep(2000);
    }

}