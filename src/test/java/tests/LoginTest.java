package tests;


import base.BaseTest;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void login() {
        page.navigate("https://bangla-reels-frontend.vercel.app/en/sign-in");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email address")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email address")).fill(" mabubokor133@gmail.com");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("@supera@dmin@1");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
    }

}