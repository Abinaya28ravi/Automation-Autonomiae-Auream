package com.automation.AutonomiaeAuream.stepdefinitions;

import com.automation.AutonomiaeAuream.pages.HomePage;
import com.automation.AutonomiaeAuream.pages.ContactPage;
import com.automation.AutonomiaeAuream.pages.InfoPage;
import com.automation.AutonomiaeAuream.utilities.CommonConfig;
import com.automation.AutonomiaeAuream.utilities.FileReaderUtil;
import io.cucumber.java.en.*;

import java.io.IOException;

public class InfoPageSteps extends CommonConfig {
    ContactPage contactPage;
    HomePage homePage;
    InfoPage infoPage;
    FileReaderUtil fileReader;

    @And("I click contact link")
    public void clickContactsLink() throws Exception{
        contactPage.clickContactLink();
    }
    @And("I click home link")
    public void clickHomeLink() throws Exception{
        homePage.clickHomeLinkInInfoPage();
    }

    @Then("all panel headings in the info page are of same dimension")
    public void allPanelHeadingsInThePageAreOfSameDimension()
    {
        infoPage.validatePanelHeadingSize();
    }

    @Then("all panel contents in the info page are same as mentioned in the JSON")
    public void allPanelContentsValidation() throws IOException {
        String panelData=fileReader.fileReaderMethod("infoPanelContent");
        infoPage.validatePanelContentWithJSON(panelData);
    }
}
