package StepDefinitions;

import Pages.ComposeMailPage;
import Pages.HomePage;
import Util.BaseTests;
import io.cucumber.java.en.*;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class ComposeMailSteps extends BaseTests {
    String email = null, subject = null, emailBodyText = null, getSuccessMessage = null, expectedSuccessMessage="Message sent.";
    protected HomePage homePage = new HomePage();
    protected ComposeMailPage composeMailPage = new ComposeMailPage();
    @And("Click on compose email button and compose email screen is appeared")
    public void clickOnComposeEmail() {
        try{

            Thread.sleep(2000);
            homePage.clickOnComposeEmailButton();

            Thread.sleep(1000);
//            composeMailPage.sendLaterButtonExists();
        }
        catch (Exception exp){
            exp.printStackTrace();
        }
    }

    @And("Add meeting schedule, title, guests, description, and title")
    public void addMeetingSchedule() throws IOException, InterruptedException {
        Thread.sleep(2000);
        composeMailPage.clickOnCalendar();
        Thread.sleep(2000);
        composeMailPage.clickSuggestButton();
        composeMailPage.setTitle(BaseTests.setTitleOfMeeting());
        composeMailPage.addGuests(BaseTests.setGuests());
        composeMailPage.clickOnDoneButton();
        composeMailPage.suggestedTimesButton();
        composeMailPage.clickOnDurationButton();
        composeMailPage.clickOn25Minute();
        composeMailPage.clickTime();
        Thread.sleep(4000);
        composeMailPage.clickOnDoneButton();
        composeMailPage.setDescripton();
        composeMailPage.clickCloseButton();
    }

    @And("Add text for email and add participants")
    public void sendMail(){
        try{
            Thread.sleep(2000);
            email = BaseTests.setReceiverEmail();
            subject = BaseTests.setSubjectOfEmail();
            emailBodyText = BaseTests.setBodyOfMail();
            composeMailPage.typeReceiverEmail(email);
            composeMailPage.typeSubjectOfEmail(subject);
        }
        catch (Exception exp){
            exp.printStackTrace();
        }
    }

    @And("Validate success message")
    public void addTextForEmail() throws IOException {
        try{
            Thread.sleep(4000);
            composeMailPage.clickOnSendEmail();
            getSuccessMessage = composeMailPage.validateSucessMessage();
            assertEquals(getSuccessMessage, expectedSuccessMessage, "Success Message Validation failed!");
            BaseTests.tearDown();
        }
        catch (Exception exp){
            exp.printStackTrace();
        }
    }

}
