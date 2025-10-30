package com.qa.reelshort.tests;

import com.qa.reelshort.base.BaseTest;
import com.qa.reelshort.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testdata.testdata;

public class HomePageTest extends BaseTest {

    @Test
    public void homePageTitleTest(){
        String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

//    @Test
//    public void homePageUrlTest(){
//        String actualUrl = homePage.getHomePageUrl();
//        Assert.assertEquals(actualUrl,prop.getProperty("url"));
//    }



    @Test(dataProvider = "ContentData", dataProviderClass = testdata.class)
    public void checkFullContentFlowOne(String emailData, String pass, String title, String region, String description, String subtitle, String age) {
        String actualAdminTxt= homePage.doLogin(emailData,pass);
        Assert.assertEquals(actualAdminTxt,"Admin Panel ");
        homePage.clickAdminPanel(title, region, description, subtitle, age);
        //System.out.println("URL after click: " + page.url());
    }
}