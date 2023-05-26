package Util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class BaseTests {

    public static AppiumDriver driver;
    public static String email = "", password = "", receiverEmail = "", subject = "", emailBodyText="", autoResponderText="", title="";
    protected static String projectPath = System.getProperty("user.dir");
    public static String path = projectPath + "/resources/";
    public static String filePath = path + "email.properties";
    public static String url = "https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&ct=1684325890&rver=7.0.6737.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26RpsCsrfState%3d9ecc5b5b-cf83-6f87-609a-da9860b03d9a&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=90015";
    WebDriverWait wait;

    public static WebDriver webDriver;
    public static void setUpWebDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--remote-allow-origins=*");
//        chromeOptions.addArguments("--user-data-dir=C:\\Users\\saimahanif\\AppData\\Local\\Google\\Chrome\\User Data\\");
//        chromeOptions.addArguments("--profile-directory=Profile 9");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.get(url);
        webDriver.manage().window().maximize();
    }

    public static void setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "android"); //R5CN30QSLXX
        cap.setCapability("udid", "R5CN30QSLXX"); //84b579bc //emulator-5554
        cap.setCapability("platformVersion", "9");
        cap.setCapability("deviceName", "R5CN30QSLXX");
        cap.setCapability("autoGrantPermissions", true);
        cap.setCapability("appPackage", "com.baydin.boomerang");
        cap.setCapability("appActivity","com.baydin.boomerang.AccountTypeSelectorActivity");
        cap.setCapability("app","C:\\Users\\saimahanif\\Downloads\\boomerangandroid-prod-release.apk");
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
        return prop.getProperty("subjectOfEmail");
    }

    public static String getSubjectTextTestMail() throws IOException {
        FileReader reader = new FileReader(filePath);
        Properties prop = new Properties();
        prop.load(reader);
        return prop.getProperty("subjectTestMail");
    }

    public static String getMessageBodyTextTestMail() throws IOException {
        FileReader reader = new FileReader(filePath);
        Properties prop = new Properties();
        prop.load(reader);
        return prop.getProperty("messageMailBodyTestMail");
    }

    public static String setBodyOfMail() throws IOException {
        FileReader reader = new FileReader(filePath);
        Properties prop = new Properties();
        prop.load(reader);
        return prop.getProperty("emailBodyText");
    }

    public static String setTitleOfMeeting() throws IOException {
        FileReader reader = new FileReader(filePath);
        Properties prop = new Properties();
        prop.load(reader);
        return prop.getProperty("title");
    }

    public static String setGuests() throws IOException {
        FileReader reader = new FileReader(filePath);
        Properties prop = new Properties();
        prop.load(reader);
        return prop.getProperty("guests");
    }

    public static String getText(String text) throws IOException {
        FileReader reader = new FileReader(filePath);
        Properties prop = new Properties();
        prop.load(reader);
        return prop.getProperty(text);
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

    public void waitForElementPresentWeb(By locator) {
        try {
            this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
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

    public static void tearDownWebApp(){
        webDriver.quit();;
    }

    public static void closeCurrentWebApp(){
        webDriver.close();;
    }

    public static void pullDownToRefresh(){
        //Scrollable Element
        WebElement ele01 = driver.findElement(By.id("com.baydin.boomerang:id/email_list"));

        int centerX = ele01.getRect().x + (ele01.getSize().width/2);

        double endY= ele01.getRect().y + (ele01.getSize().height * 0.9);

        double startY = ele01.getRect().y + (ele01.getSize().height * 0.1);
        //Type of Pointer Input
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        //Creating Sequence object to add actions
        Sequence swipe = new Sequence(finger,1);
        //Move finger into starting position
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(),centerX,(int)startY));
        //Finger comes down into contact with screen
        swipe.addAction(finger.createPointerDown(0));
        //Finger moves to end position
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(),centerX, (int)endY));
        //Get up Finger from Srceen
        swipe.addAction(finger.createPointerUp(0));
        //Perform the actions
        driver.perform(Arrays.asList(swipe));
    }

}