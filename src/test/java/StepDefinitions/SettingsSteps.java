package StepDefinitions;

import Pages.HomePage;
import Pages.ThemeChangePage;
import Util.BaseTests;
import io.cucumber.java.en.Then;

public class SettingsSteps extends BaseTests {

    protected HomePage homePage;
    protected ThemeChangePage themePage;

    @Then("go to menu bar and click on setting")
    public void openSettingsPage(){
        try{
            homePage = new HomePage();
            themePage = new ThemeChangePage();
            homePage.clickOnMenuButton();
            homePage.clickOnSettingsButton();
            homePage.clickOnAccountSettingsButton();
            themePage.changeTheme();
        }
        catch (Exception exp) {
            System.out.println(exp);
        }
    }

}