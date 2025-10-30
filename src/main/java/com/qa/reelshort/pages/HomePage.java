package com.qa.reelshort.pages;

import com.google.gson.internal.bind.JsonTreeReader;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage {
    private Page page;

    // 1.String Locators - OR
    private String profilIcon = "a[data-slot='hover-card-trigger']";
    private String loginButton = "a[href='/en/sign-in']";
    private String emailAddress = "input#identifier-field";
    private String password = "input#password-field";
    private String continueButton = "button[data-localization-key='formButtonPrimary']";
    private String adminPanelText = "//button[normalize-space()='Admin Panel']";


    //2. Page Constructor
    public HomePage(Page page) {
        this.page = page;
    }


    //3. Page actions/methods
    public String getHomePageTitle() {
        String title = page.title();
        System.out.println("Title is:" + title);
        return title;
    }

    public String getHomePageUrl() {
        String url = page.url();
        System.out.println("URL is:" + url);
        return url;
    }

    public String doLogin(String email, String pass) {
        page.click(profilIcon);
        page.waitForTimeout(1000);
        page.click(loginButton);
        page.fill(emailAddress, email);
        page.click(continueButton);
        page.fill(password, pass);
        page.click(continueButton);
        //page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        String adminPanelTxt = page.textContent(adminPanelText);
        System.out.println("Text after Login:" + adminPanelTxt);
        return adminPanelTxt;
    }
    public void clickAdminPanel(String title, String region, String description, String subtitle, String age){
        //page.click(adminPanelText);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Admin Panel")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Content Management")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Content List")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("New")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Title *")).fill(title);
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Region Locks")).click();
//        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Region Locks")).press("CapsLock");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Region Locks")).fill(region);
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Description")).click();
//        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Description")).fill("JUST CHECKED THE ");
//        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Description")).press("CapsLock");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Description")).fill(description);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Select release date")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Go to the Next Month")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Go to the Next Month")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Saturday, December 20th,")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Subtitle Languages")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Subtitle Languages")).fill(subtitle);
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Age Rating")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Age Rating")).fill(age);
        page.getByRole(AriaRole.COMBOBOX).filter(new Locator.FilterOptions().setHasText("Select Genres")).click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Action")).click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Comedy")).click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Family")).click();
        page.getByRole(AriaRole.COMBOBOX).filter(new Locator.FilterOptions().setHasText("Select Tags")).click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Comedy")).click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Family")).click();
        page.locator("input[type='file']").nth(0).setInputFiles(Paths.get("F:/Image-1.jpg"));
        page.locator("input[type='file']").last().setInputFiles(Paths.get("F:/Image-2.jpg"));
//        page.getByText("browse").first().click();
//        page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Add Content")).setInputFiles(Paths.get("download (1).jpg"));
//        page.getByText("browse").click();
//        page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Add Content")).setInputFiles(Paths.get("download.jpg"));
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
        assertThat(page.getByText("Content created successfully").first()).isVisible();







//        page.getByRole(AriaRole.COMBOBOX).filter(new Locator.FilterOptions().setHasText("Select language")).click();
//        page.getByText("Bengali").click();
//        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Subtitle Languages")).click();
//        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Subtitle Languages")).fill("bn,en,ur");
//        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Age Rating")).click();
//        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Age Rating")).fill("pg-13");
//        page.getByRole(AriaRole.COMBOBOX).filter(new Locator.FilterOptions().setHasText("Select Genres")).click();
//        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Family")).click();
//        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Comedy")).click();
//        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Fantasy").setExact(true)).click();
//        page.getByRole(AriaRole.COMBOBOX).filter(new Locator.FilterOptions().setHasText("Select Tags")).click();
//       // page.getByPlaceholder("Search...").fill("family");
//        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Family")).click();
//      //  page.getByPlaceholder("Search...").click();
//       // page.getByPlaceholder("Search...").fill("comedy");
//       // page.getByPlaceholder("Search...").press("Enter");
//        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Comedy")).click();
//        //page.getByText("Poster Image").click();
//        //page.getByText("browse").first().click();
//        page.locator(".lucide.lucide-upload").first().click();
//        //page.getByText("Drag and drop an image, or").first().click();
//        page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Add Content")).setInputFiles(Paths.get("C:/Users/DCL/Pictures/download.jpg"));
//        page.getByText("browse").last().click();
//        page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Add Content")).setInputFiles(Paths.get("C:/Users/DCL/Pictures/download (1).jpg"));
////        page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Add Content")).press("ControlOrMeta+=");
////        page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Add Content")).press("ControlOrMeta+-");
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
//        page.locator("#radix-_r_42_").click();
//        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("View")).click();
//        page.navigate("https://bangla-reels-frontend-production.up.railway.app/en/super-admin/dashboard/content-management/content-list");
//        page.locator("#radix-_r_5k_").click();
//        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Edit")).click();
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close")).click();
//        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Episode List")).click();
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("New")).click();
//        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Title *")).click();
//        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Title *")).fill("jack");
//        page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Number *")).click();
//        page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("Number *")).fill("5");
//        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Description")).click();
//        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Description")).fill("just check the episode with automation flow");
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("-10-27")).click();
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Go to the Next Month")).click();
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Go to the Next Month")).click();
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Wednesday, December 31st,")).click();
//        page.locator("label").filter(new Locator.FilterOptions().setHasText("Monetization*")).click();
//        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Mood Tags")).click();
//        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Mood Tags")).fill("dramatic");
//        page.getByRole(AriaRole.COMBOBOX).click();
//        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Coin")).click();
//        page.getByRole(AriaRole.COMBOBOX).click();
//        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Free")).click();
//        page.getByRole(AriaRole.SWITCH, new Page.GetByRoleOptions().setName("Is Trailer?")).click();
//        page.getByRole(AriaRole.SWITCH, new Page.GetByRoleOptions().setName("AI Dubbed?")).click();
//        page.getByText("Drag and drop an MP4 video, or browse to uploadMax 500MB. Only MP4 format").click();
//        page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Add Episode")).setInputFiles(Paths.get("demo_video_reel.mp4"));
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
//        page.getByText("browse").click();
//        page.getByText("browse").click();
//        page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Add Episode")).setInputFiles(Paths.get("sebl_bin_1010.mp4"));
//        page.getByText("browse").click();
//        page.getByRole(AriaRole.DIALOG, new Page.GetByRoleOptions().setName("Add Episode")).setInputFiles(Paths.get("demo_video_reel.mp4"));
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close")).click();
    }




}
