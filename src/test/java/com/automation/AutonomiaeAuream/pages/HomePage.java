package com.automation.AutonomiaeAuream.pages;



import com.automation.AutonomiaeAuream.utilities.*;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import java.util.List;
import java.util.Map;


public class HomePage extends CommonPageObject {


    @FindBy(id="email")
    private WebElement HomeEmailAddress;

    @FindBy(id="pwd")
    private WebElement HomePassword;

    @FindBy(id="home-submit")
    private WebElement HomeLoginSubmit;

    @FindBy(id="home-link")
    private WebElement HomeLinkElement;

    @FindBy(xpath="//*[@id=\"home-cover\"]")
    private WebElement homeCoverImg;

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
    public void validateEmailMandatory() throws InterruptedException {
        //Boolean isRequired = false;
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
           // isRequired = (Boolean) js.executeScript("return arguments[0].required;", HomeEmailAddress);
             Assert.assertTrue("****Email must be a mandatory field****",(Boolean) js.executeScript("return arguments[0].required;", HomeEmailAddress));
        }
    public void validatePwdMandatory() throws InterruptedException {
        //Boolean isRequired = false;
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//        isRequired = (Boolean) js.executeScript("return arguments[0].required;", HomePassword);
        Assert.assertTrue("****Password must be a mandatory field****", (Boolean) js.executeScript("return arguments[0].required;", HomePassword));
    }

    public void validateErrorMessage(String errorMessage)
    {
        Assert.assertEquals("****Email format validation failure****" ,errorMessage,HomeEmailAddress.getAttribute("validationMessage"));
    }

   public void clickHomeLinkInInfoPage() throws Exception
   {
       HomeLinkElement.click();
   }

    public void verifyAllImageloaded() throws InterruptedException {
        waitForPageLoaded();
        scrollToElement(homeCoverImg);
        Boolean isImageLoaded=false;
        isImageLoaded = (Boolean) ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",homeCoverImg);
        Assert.assertTrue("****Image not loaded please check: homecoverGIF****",isImageLoaded);
    }

}



