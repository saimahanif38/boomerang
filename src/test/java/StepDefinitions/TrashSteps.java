package StepDefinitions;

import Pages.HomePage;
import Pages.MenuBar;
import Pages.SpamPage;
import Pages.TrashPage;
import Util.BaseTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.testng.Assert.assertEquals;

public class TrashSteps extends BaseTests {
    protected MenuBar menuBar;
    protected HomePage homePage;
    protected TrashPage trashPage;
    protected String pageTitle = null;
    protected String expectedTitle = "Trash";

    @And("Open Trash box")
    public void openInbox() {
        homePage = new HomePage();
        homePage.openMenuBar();
        menuBar = new MenuBar();
        menuBar.clickOnTrashButton();
    }

    @Then("Validate Trash box page is open")
    public void validateInbox() {
        try {
            trashPage = new TrashPage();
            pageTitle = trashPage.getTitleOfPage();
            assertEquals(pageTitle, expectedTitle, "Spam Mail Page is not opened");
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
}
