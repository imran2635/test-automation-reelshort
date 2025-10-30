package testdata;

import org.testng.annotations.DataProvider;

public class testdata {
    @DataProvider(name = "ContentData")
    public Object[][] getLoginData() {
        return new Object[][] {
                { "imranhossain2222345@gmail.com", "imranhossain2222345@", "Title Hello", "CA, AU, US, UK", "the content created for test purpose of automation", "en, bn, es", "18, 19" }
                // { "user2@example.com", "password456", "Home" }
        };
    }
}
