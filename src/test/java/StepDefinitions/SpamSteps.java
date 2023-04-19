package StepDefinitions;

import Pages.HomePage;
import Pages.MenuBar;
import Pages.SpamPage;
import Util.BaseTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.testng.Assert.assertEquals;

public class SpamSteps extends BaseTests {
    protected MenuBar menuBar;
    protected HomePage homePage;
    protected SpamPage spamPage;
    protected String pageTitle = null;
    protected String expectedTitle = "Spam";

    @And("Open Spam box")
    public void openInbox() {
        homePage = new HomePage();
        homePage.openMenuBar();
        menuBar = new MenuBar();
        menuBar.clickOnSpamButton();
    }

    @Then("Validate Spam box page is open")
    public void validateInbox() {
        try {
            spamPage = new SpamPage();
            pageTitle = spamPage.getTitleOfPage();
            assertEquals(pageTitle, expectedTitle, "Spam Mail Page is not opened");
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
}
