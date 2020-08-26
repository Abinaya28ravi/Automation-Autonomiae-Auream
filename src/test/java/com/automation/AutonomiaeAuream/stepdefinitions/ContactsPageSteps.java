package com.automation.AutonomiaeAuream.stepdefinitions;

import com.automation.AutonomiaeAuream.pages.ContactPage;
import com.automation.AutonomiaeAuream.utilities.CommonConfig;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

public class ContactsPageSteps extends CommonConfig {

ContactPage contactpage;
    @When("I enters contact details")
    public void iEnterContactDetails(List<Map<String, String>> contactDetails) throws Exception{
        contactpage.enterContactdetails(contactDetails);
    }

    @And("click submit in contact page")
    public void iClickContactSubmit() throws Exception{
        contactpage.clickSubmit();
    }

    @Then("^I verify \"([^\"]*)\" field is mandatory$")
    public void iverifyMandatory(String fieldName) throws Exception{
        System.out.println("fieldname" +fieldName);
        contactpage.validateMandatory(fieldName);
    }
}
