package com.automation.AutonomiaeAuream.stepdefinitions;

import com.automation.AutonomiaeAuream.pages.HomePage;
import com.automation.AutonomiaeAuream.utilities.CommonConfig;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

public class HomePageSteps extends CommonConfig {
    public HomePage indexpage;

    @Given("^I access \"([^\"]*)\" page$")
    public void i_acess_homepage(String pageName) throws Exception {
        navigateToUrl(pageName);
        //Given I access 'Autonomiae Auream' home page
    }



    @When("I enter email address and password")
    public void iEnterEmailAddressAndPassword(List<Map<String, String>> loginDetails) throws Exception{
        indexpage.enterLogindetails(loginDetails);
    }

    @And("click submit in home page")
    public void clickSubmitInHomePage() throws Exception{
        indexpage.setHomeLoginSubmit();
    }


    @When("I verify emailID and Password are mandatory")
    public void iverifyEmailPwdMandatory() throws Exception{
        indexpage.validateEmailMandatory();
        indexpage.validatePwdMandatory();
    }
    @When("I verify emailID is mandatory")
    public void iverifyEmailMandatory() throws Exception{
        indexpage.validateEmailMandatory();
    }
    @When("I verify password is mandatory")
    public void iverifyPwdMandatory() throws Exception{
        indexpage.validatePwdMandatory();
    }

    @Then("^I should see error message \"([^\"]*)\"$")
    public void iShouldSeeErrorMessage(String errormessage)
    {
      indexpage.validateErrorMessage(errormessage);
    }
}
