package StepDefinitions;
import Pages.HomePage;
import Util.BaseTests;
import io.cucumber.java.en.Then;

public class SearchSteps extends BaseTests {

    protected HomePage homePage;

    @Then("click on the search bar and send the email")
    public void search_verification(){
        try{
            homePage = new HomePage();
            homePage.clickAndEnterDataInSearch();

        }
        catch (Exception exp) {
            System.out.println(exp);
        }
    }

}