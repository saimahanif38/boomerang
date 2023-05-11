package Util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseTests {

    public static AppiumDriver driver;
    public static String email = "", password = "", receiverEmail = "", subject = "", emailBodyText="", autoResponderText="", title="";
    protected static String projectPath = System.getProperty("user.dir");
    public static String path = projectPath + "/resources/";
    public static String filePath = path + "email.properties";
    WebDriverWait wait;

    public static void setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "android");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformVersion", "9");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("appPackage", "com.baydin.boomerang");
        cap.setCapability("app", "C:/Users/saimahanif/Downloads/boomerangandroid-prod-release.apk");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(url, cap);
    }

    public static void setEmailAndPassword() throws IOException {
        FileReader reader = new FileReader(filePath);
        Properties prop = new Properties();
        prop.load(reader);
        email = prop.getProperty("email");
        password = prop.getProperty("password");
        BaseTests.checkIfEmailAndPasswordIsEmpty(email, password);
    }

    public static String setReceiverEmail() throws IOException {
        FileReader reader = new FileReader(filePath);
        Properties prop = new Properties();
        prop.load(reader);
        receiverEmail = prop.getProperty("receiverEmail");
        return receiverEmail;
    }

    public static String setSubjectOfEmail() throws IOException {
        FileReader reader = new FileReader(filePath);
        Properties prop = new Properties();
        prop.load(reader);
        subject = prop.getProperty("subjectOfEmail");
        return subject;
    }

    public static String setBodyOfMail() throws IOException {
        FileReader reader = new FileReader(filePath);
        Properties prop = new Properties();
        prop.load(reader);
        emailBodyText = prop.getProperty("emailBodyText");
        return emailBodyText;
    }

    public static String setTitleOfMeeting() throws IOException {
        FileReader reader = new FileReader(filePath);
        Properties prop = new Properties();
        prop.load(reader);
        title = prop.getProperty("title");
        return title;
    }

    public static String setGuests() throws IOException {
        FileReader reader = new FileReader(filePath);
        Properties prop = new Properties();
        prop.load(reader);
        return prop.getProperty("guests");
    }

    public static void tearDown() {
        driver.quit();
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

    public static String setAutoResponderText() throws IOException {
        FileReader reader = new FileReader(filePath);
        Properties prop = new Properties();
        prop.load(reader);
        autoResponderText = prop.getProperty("autoResponderMailText");
        return autoResponderText;
    }

    public static void checkIfEmailAndPasswordIsEmpty(String email, String password){
        if ((email == null) || (password == null)){
            throw new IllegalArgumentException("Email or Password can not be null. Please enter email or password in resources/email.properties file");
        }
    }
}