package com.qa.reelshort.base;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.qa.reelshort.factory.PlaywrightFactory;
import com.qa.reelshort.pages.HomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected PlaywrightFactory pf;
    protected HomePage homePage;
    protected Properties prop;


    @BeforeTest
    public void setup(){
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop);
        homePage = new HomePage(page);
    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }


//    @BeforeMethod
//    public void setUp() {
//        playwright = Playwright.create();
//        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
//        page = browser.newPage();
//    }

//    @AfterMethod
//    public void tearDown() {
//        if(browser!=null) browser.close();
//        if(playwright!=null) playwright.close();
//    }


}
