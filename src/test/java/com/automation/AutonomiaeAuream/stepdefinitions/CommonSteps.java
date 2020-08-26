package com.automation.AutonomiaeAuream.stepdefinitions;

import com.automation.AutonomiaeAuream.pages.HomePage;
import com.automation.AutonomiaeAuream.pages.InfoPage;
import com.automation.AutonomiaeAuream.pages.ContactPage;
import com.automation.AutonomiaeAuream.utilities.CommonConfig;
import io.cucumber.java.en.*;

public class CommonSteps extends CommonConfig {
    public HomePage indexpage;
    public InfoPage infopage;
    public ContactPage contactPage;

    @Then("^I should be navigated to \"([^\"]*)\" page$")
    public void i_Verify_pagettile(String pageName) throws Exception {
        verifyTitleOfPage(pageName);
        //Given I access 'Autonomiae Auream' home page
    }

    @Then("^all images in the \"([^\"]*)\" page are loaded$")
    public void allImagesInThePageAreLoaded(String pagename) throws InterruptedException {
        switch(pagename)
        {
            case "contact":
                contactPage.verifyAllImageloaded();
            break;

            case "home":
                indexpage.verifyAllImageloaded();
                break;

            case "info":
                infopage.verifyAllImageloaded();
                break;
        }

    }


}
