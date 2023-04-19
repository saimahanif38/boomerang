package StepDefinitions;

import Pages.HomePage;
import Pages.MenuBar;
import Pages.SentPage;
import Util.BaseTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.testng.Assert.assertEquals;

public class SentSteps extends BaseTests {
    protected MenuBar menuBar;
    protected HomePage homePage;
    protected SentPage sentPage;
    protected String pageTitle = null;
    protected String expectedTitle = "Sent";

    @And("Open sent box")
    public void openInbox() {
        homePage = new HomePage();
        homePage.openMenuBar();
        menuBar = new MenuBar();
        menuBar.clickOnSentButton();
    }

    @Then("Validate sent box page is open")
    public void validateInbox() {
        try {
            sentPage = new SentPage();
            pageTitle = sentPage.getTitleOfPage();
            assertEquals(pageTitle, expectedTitle, "Send Mail Page is not opened");
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
}
