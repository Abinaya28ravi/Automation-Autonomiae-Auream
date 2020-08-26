package com.automation.AutonomiaeAuream.utilities;


import com.automation.AutonomiaeAuream.pages.HomePage;

import org.openqa.selenium.*;


public class CommonMethods {
    HomePage dummyPageObject;

    public WebDriver getDriver() {
        return dummyPageObject.getDriver();
    }

    public static void main(String[] args) {

    }


}
