package StepDefinitions;

import Pages.HomePage;
import Pages.Settings.AccountSettings.ThemeChangePage;
import Util.BaseTests;
import io.cucumber.java.en.Then;

public class ThemeChangingSteps extends BaseTests {

    protected HomePage homePage;
    protected ThemeChangePage themePage;

    @Then("go to menu bar and click on Settings and click on Account Settings")
    public void navigateFromSettingsToAccountSettings(){
        try{
            homePage = new HomePage();
            homePage.clickOnMenuButton();
            homePage.clickOnSettingsButton();
            homePage.clickOnAccountSettingsButton();

        }
        catch (Exception exp) {
            System.out.println(exp);
        }
    }

    @Then("click on the Theme button to select the Theme and save it, after selection")
    public void themeChanging(){
        try{
            themePage = new ThemeChangePage();
            themePage.changeTheme();
        }
        catch (Exception exp) {
            System.out.println(exp);
        }
    }
}