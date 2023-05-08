package StepDefinitions;

import Pages.ComposeMailPage;
import Pages.HomePage;
import Util.BaseTests;
import io.cucumber.java.en.*;

import static org.testng.Assert.assertEquals;

public class ComposeMailSteps extends BaseTests {
    String email = null, subject = null, emailBodyText = null, getSuccessMessage = null, expectedSuccessMessage="Message sent.";
    protected HomePage homePage = new HomePage();
    protected ComposeMailPage composeMailPage = new ComposeMailPage();
    @And("Click on compose email button and compose email screen is appeared")
    public void clickOnComposeEmail() {
        try{
            homePage.clickOnComposeEmailButton();
            homePage.clickOnAllowContactsButton();
            composeMailPage.sendLaterButtonExists();
        }
        catch (Exception exp){
            exp.printStackTrace();
        }
    }

    @And("Add text for email and add participants and validate success message")
    public void addTextForEmail() {
        try {
            email = BaseTests.setReceiverEmail();
            subject = BaseTests.setSubjectOfEmail();
            emailBodyText = BaseTests.setBodyOfMail();
            composeMailPage.sendLaterButtonExists();
            composeMailPage.typeReceiverEmail(email);
            composeMailPage.typeSubjectOfEmail(subject);
            composeMailPage.typeEmailBody(emailBodyText);
            composeMailPage.clickOnSendEmail();
            getSuccessMessage = composeMailPage.validateSucessMessage();
            assertEquals(getSuccessMessage, expectedSuccessMessage, "Success Message Validation failed!");
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

}
