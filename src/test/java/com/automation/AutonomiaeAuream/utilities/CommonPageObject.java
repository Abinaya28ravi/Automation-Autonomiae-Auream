package com.automation.AutonomiaeAuream.utilities;


import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;


public class CommonPageObject extends PageObject {

    public WebElement CurrentFrame;

    public void waitForPageLoaded() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        for (int wait = 0; wait < 25; wait++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            //To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
    }

    public void scrollToElement(WebElement objElem) {
        try {
            JavascriptExecutor objJS = (JavascriptExecutor) getDriver();
            objJS.executeScript("arguments[0].scrollIntoView();", objElem);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

}
