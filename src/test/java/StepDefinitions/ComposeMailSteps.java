package StepDefinitions;

import Pages.ComposeMailPage;
import Pages.HomePage;
import Util.BaseTests;
import io.cucumber.java.en.*;

public class ComposeMailSteps extends BaseTests {
    String email = null, subject= null;
    protected HomePage homePage;
    protected ComposeMailPage composeMailPage;
    @And("Click on compose email button")
    public void clickOnComposeEmail() {
        try{
            homePage = new HomePage();
            homePage.clickOnComposeEmailButton();
            homePage.clickOnAllowContactsButton();
        }
        catch (Exception exp){
            exp.printStackTrace();
        }
    }

    @Then("Validate compose email screen is appeared")
    public void validateInbox() {
        try {
            composeMailPage = new ComposeMailPage();
            composeMailPage.sendLaterButtonExists();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    @And("Add text for email and add participants")
    public void addTextForEmail() {
        try {
            email = BaseTests.setReceiverEmail();
            subject = BaseTests.setSubjectOfEmail();
            composeMailPage = new ComposeMailPage();
            composeMailPage.sendLaterButtonExists();
            composeMailPage.typeReceiverEmail(email);
            composeMailPage.typeSubjectOfEmail(subject);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    @Then("validate success message of email sent")
    public void validateSuccessMessageOfEmailSent() {
    }
}
