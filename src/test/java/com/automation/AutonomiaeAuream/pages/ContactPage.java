package com.automation.AutonomiaeAuream.pages;



import com.automation.AutonomiaeAuream.utilities.*;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;


public class ContactPage extends CommonPageObject {


    @FindBy(id = "contact-link")
    private WebElement contactLink;

    @FindBy(id = "email")
    private WebElement emailElement;

    @FindBy(id = "name")
    private WebElement firstNameElement;

    @FindBy(id = "name")
    private WebElement lastNameElement;

    @FindBy(id = "tel")
    private WebElement phoneNumberElement;

    @FindBy(name = "requestType")
    private WebElement requestTypeElement;

    @FindBy(name = "message")
    private WebElement commentElement;

    //List<WebElement> li=getDriver().findElements(By.id("name"));

    @FindBy(id = "home-submit")
    private WebElement contactSubmitElement;

    @FindBy(id = "contact-cover")
    private WebElement contactCoverImageElement;

    public void clickContactLink() throws Exception {
        contactLink.click();
    }


    public void enterContactdetails(List<Map<String, String>> contactDetails) throws Exception {
        waitForPageLoaded();
        String email = contactDetails.get(0).get("Email");
        String firstName = contactDetails.get(0).get("Firstname");
        String lastName = contactDetails.get(0).get("Lastname");
        String phoneNumber = contactDetails.get(0).get("Phonenumber");
        String requestType = contactDetails.get(0).get("Requesttype");
        String comments = contactDetails.get(0).get("comment");
        emailElement.sendKeys(email);
        firstNameElement = getDriver().findElements(By.id("name")).get(0);
        lastNameElement = getDriver().findElements(By.id("name")).get(1);

        firstNameElement.sendKeys(firstName);
        lastNameElement.sendKeys(lastName);
        phoneNumberElement.sendKeys(phoneNumber);

        selectFromDropdown(requestTypeElement, requestType);
        commentElement.sendKeys(comments);
    }

    public void clickSubmit() throws Exception {
        contactSubmitElement.click();
    }

    public void validateMandatory(String fieldName) throws InterruptedException {
        //Boolean isRequired = false;
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        // isRequired = (Boolean) js.executeScript("return arguments[0].required;", HomeEmailAddress);
        switch (fieldName) {
            case "first name":
                String firstNameMessage = fieldName + " must be a mandatory field******";
                Assert.assertTrue(firstNameMessage, (Boolean) js.executeScript("return arguments[0].required;", firstNameElement));
                break;
            case "last name":
                String lastNameMessage = fieldName + " must be a mandatory field******";
                Assert.assertTrue(lastNameMessage, (Boolean) js.executeScript("return arguments[0].required;", lastNameElement));
                break;
            case "phone number":
                String phoneMessage = fieldName + " must be a mandatory field******";
                Assert.assertTrue(phoneMessage, (Boolean) js.executeScript("return arguments[0].required;", phoneNumberElement));
                break;

        }
    }

    public void verifyAllImageloaded() throws InterruptedException {
        waitForPageLoaded();
        SoftAssert softAssertion= new SoftAssert();
        Boolean isImageLoaded=false;
         isImageLoaded = (Boolean) ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", contactCoverImageElement);
        softAssertion.assertTrue(isImageLoaded,"****Image not loaded please check: ContactCoverPageGIF****");
        softAssertion.assertAll();
    }
}



