package com.automation.AutonomiaeAuream.utilities;

import net.thucydides.core.webdriver.DriverConfigurationError;
import org.junit.Assert;

public class CommonConfig extends CommonMethods {
    private String url;
    public void navigateToUrl(String pageName) throws Exception{

        switch(pageName)
        {
            case "Autonomiae Auream home":
              url  ="file:///Users/abinaya.ravi/Downloads/Automation_Handout_Bundle/index.html";
              break;
        }
        try {
            maximizeWindow();
        } catch ( DriverConfigurationError  driverConfigurationError) {
            // looks like, it failed to get Driver on first attempt
            driverConfigurationError.printStackTrace();
            //try again
            System.err.println("**Try again to reach webdriver**");
            maximizeWindow();
        }
        getDriver().manage().deleteAllCookies();
        System.out.println("Navigating to URL - "+url);
        getDriver().get(url);
        getDriver().get(url);
    }
    public void maximizeWindow() {
        getDriver().manage().window().maximize();
    }
    public void verifyTitleOfPage(String pageName) throws Exception
    {
        String text;
        switch(pageName) {
            case "Autonomiae Auream home":
                 text = "Home";
                Assert.assertEquals(text,getDriver().getTitle());
                break;
            case "Information station":
                 text = "Automation Information Station";
                Assert.assertEquals(text,getDriver().getTitle());
                break;
            case "Contact":
                text = "Contact";
                Assert.assertEquals(text,getDriver().getTitle());
                break;
        }

    }
}
