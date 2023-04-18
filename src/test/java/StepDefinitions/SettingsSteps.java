package StepDefinitions;

import Pages.HomePage;
import Util.BaseTests;
import io.cucumber.java.en.Then;

public class SettingsSteps extends BaseTests {

    protected HomePage homePage;

    @Then("go to menu bar and click on setting")
    public void openSettingsPage(){
        try{
            Thread.sleep(500000);
            homePage = new HomePage();
            homePage.clickOnMenuButton();
            Thread.sleep(500000);
        }
        catch (Exception exp) {
            System.out.println(exp);
        }
    }

}