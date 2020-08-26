package com.automation.AutonomiaeAuream.pages;

import org.json.JSONObject;

import com.automation.AutonomiaeAuream.utilities.*;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.testng.asserts.*;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;


public class InfoPage extends CommonPageObject {


    @FindBy(id="email")
    private WebElement HomeEmailAddress;

    @FindBy(id="pwd")
    private WebElement HomePassword;

    @FindBy(id="home-submit")
    private WebElement HomeLoginSubmit;

    @FindBy(xpath="/html/body/div[2]/div/div[2]/div/div[2]/img")
    private WebElement thinkingGIF;

    @FindBy(xpath="/html/body/div[3]/div/div[2]/div/div[2]/img")
    private WebElement overWorkingGIF;

    @FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[2]/img")
    private WebElement buildSystemErrorGIF;

    @FindBy(id="panel-1-heading")
    private WebElement panelOneHeading;

    @FindBy(id="panel-main-heading")
    private WebElement panelTwoHeading;

    @FindBy(id="panel-conclusion-heading")
    private WebElement panelThreeHeading;

    @FindBy(id="panel-1-text-1")
    private WebElement panelOneTextOne;

    @FindBy(id="panel-1-text-2")
    private WebElement panelOneTextTwo;

    @FindBy(id="panel-1-text-3")
    private WebElement panelOneTextThree;

    @FindBy(id="panel-2-text-1")
    private WebElement panelTwoTextOne;

    @FindBy(id="panel-2-text-2")
    private WebElement panelTwoTextTwo;

    @FindBy(id="panel-2-text-3")
    private WebElement panelTwoTextThree;

    @FindBy(id="panel-3-text-1")
    private WebElement panelThreeTextOne;

    @FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[1]/div[2]")
    private WebElement panelThreeTextTwo;

    @FindBy(id="panel-3-text-3")
    private WebElement panelThreeTextThree;


    public void enterLogindetails(List<Map<String,String>> loginDetails) throws Exception
    {
        waitForPageLoaded();
        String emailAddress = loginDetails.get(0).get("Email");
        String password = loginDetails.get(0).get("Password");
        HomePassword.clear();
        HomeEmailAddress.clear();
        HomeEmailAddress.sendKeys(emailAddress);
        HomePassword.sendKeys(password);
    }

    public void setHomeLoginSubmit() throws InterruptedException {
        HomeLoginSubmit.click();
    }

    public void verifyAllImageloaded() throws InterruptedException {
        SoftAssert softAssertion= new SoftAssert();
        waitForPageLoaded();
        Boolean isImageLoaded1=false;
        Boolean isImageLoaded2=false;
        Boolean isImageLoaded3=false;
         isImageLoaded1 = (Boolean) ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", thinkingGIF);
        softAssertion.assertTrue(isImageLoaded1,"****Image not loaded please check: thinkingGIF****");

         isImageLoaded2 = (Boolean) ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", overWorkingGIF);
        softAssertion.assertTrue(isImageLoaded2,"****Image not loaded please check: thinkingGIF****");

         isImageLoaded3 = (Boolean) ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", buildSystemErrorGIF);
        softAssertion.assertTrue(isImageLoaded3,"****Image not loaded please check: thinkingGIF****");

        softAssertion.assertAll();
    }
    public void validatePanelHeadingSize()
    {
        SoftAssert softAssertion= new SoftAssert();
        softAssertion.assertEquals(panelOneHeading.getSize(),panelTwoHeading.getSize(),"****Dimesion inconsistency:Panel 1 heading size not matched with panel 2 size****");
        softAssertion.assertEquals(panelTwoHeading.getSize(),panelThreeHeading.getSize(),"****Dimesion inconsistency:Panel 2 heading size not matched with panel 3 size****");
        softAssertion.assertEquals(panelOneHeading.getSize(),panelThreeHeading.getSize(),"****Dimesion inconsistency:Panel 1 heading size not matched with panel 3 size****");
        softAssertion.assertAll();
    }

    public void validatePanelContentWithJSON(String JSONContent)
    {
        SoftAssert softAssertion= new SoftAssert();
        JSONObject obj = new JSONObject(JSONContent);
        waitForPageLoaded();
        String PanelOneParaOne = obj.getJSONObject("panel-1").getString("paragraph-1");
        String PanelOneParaTwo = obj.getJSONObject("panel-1").getString("paragraph-2");
        String PanelOneParaThree = obj.getJSONObject("panel-1").getString("paragraph-3");
        String PanelTwoParaOne = obj.getJSONObject("panel-2").getString("paragraph-1");
        String PanelTwoParaTwo = obj.getJSONObject("panel-2").getString("paragraph-2");
        String PanelTwoParaThree = obj.getJSONObject("panel-2").getString("paragraph-3");
        String PanelThreeParaOne = obj.getJSONObject("panel-3").getString("paragraph-1");
        String PanelThreeParaTwo = obj.getJSONObject("panel-3").getString("paragraph-2");
        String PanelThreeParaThree = obj.getJSONObject("panel-3").getString("paragraph-3");

        softAssertion.assertEquals(panelOneTextOne.getText(),PanelOneParaOne,"****PanelOneParaOne mismatch****");
        softAssertion.assertEquals(panelOneTextTwo.getText(),PanelOneParaTwo,"****PanelOneParaTwo mismatch****");
        softAssertion.assertEquals(panelOneTextThree.getText(),PanelOneParaThree,"****PanelOneParaThree mismatch****");
        softAssertion.assertEquals(panelTwoTextOne.getText(),PanelTwoParaOne,"****PanelTwoParaOne mismatch****");
        softAssertion.assertEquals(panelTwoTextTwo.getText(),PanelTwoParaTwo,"****PanelTwoParaTwo mismatch****");
        softAssertion.assertEquals(panelTwoTextThree.getText(),PanelTwoParaThree,"****PanelTwoParaThree mismatch****");
        softAssertion.assertEquals(panelThreeTextOne.getText(),PanelThreeParaOne,"****PanelThreeParaOne mismatch****");
        softAssertion.assertEquals(panelThreeTextTwo.getText(),PanelThreeParaTwo,"****PanelThreeParaTwo mismatch****");
        softAssertion.assertEquals(panelThreeTextThree.getText(),PanelThreeParaThree,"****PanelThreeParaThree mismatch****");
        softAssertion.assertAll();

    }

}



