package StepDefinitions;

import Pages.DraftPage;
import Pages.HomePage;
import Pages.MenuBar;
import Pages.SentPage;
import Util.BaseTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.testng.Assert.assertEquals;

public class DraftSteps extends BaseTests {
    protected MenuBar menuBar;
    protected HomePage homePage;
    protected DraftPage draftPage;
    protected String pageTitle = null;
    protected String expectedTitle = "Drafts";

    @And("Open draft box")
    public void openInbox() {
        homePage = new HomePage();
        homePage.openMenuBar();
        menuBar = new MenuBar();
        menuBar.clickOnDraftButton();
    }

    @Then("Validate draft box page is open")
    public void validateInbox() {
        try {
            draftPage = new DraftPage();
            pageTitle = draftPage.getTitleOfPage();
            assertEquals(pageTitle, expectedTitle, "Draft Mail Page is not opened");
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
}
