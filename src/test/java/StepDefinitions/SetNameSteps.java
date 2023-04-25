package StepDefinitions;
import Pages.Settings.AccountSettings.SetNamePage;
import Util.BaseTests;
import io.cucumber.java.en.Then;

public class SetNameSteps extends BaseTests {

    protected SetNamePage setName;

    @Then("click on the name field and set the name")
    public void themeChanging(){
        try{
            setName = new SetNamePage();
            setName.setName();
        }
        catch (Exception exp) {
            System.out.println(exp);
        }
    }
}