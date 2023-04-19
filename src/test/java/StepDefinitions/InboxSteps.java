package StepDefinitions;

import Pages.HomePage;
import Pages.MenuBar;
import Util.BaseTests;
import io.cucumber.java.en.*;

import static org.testng.Assert.assertEquals;

public class InboxSteps extends BaseTests {
    protected MenuBar menuBar;
    protected HomePage homePage;
    protected String userEmail = null;

    @And("Open inbox")
    public void openInbox() {
        homePage = new HomePage();
        homePage.openMenuBar();
        menuBar = new MenuBar();
        menuBar.clickOnInboxButton();
    }

    @Then("Validate inbox mail is open")
    public void validateInbox() {
        try {
            homePage = new HomePage();
            userEmail = homePage.getUserEmail();
            assertEquals(userEmail, BaseTests.email, "Inbox Mail is not opened");
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
}
