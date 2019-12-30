package com.petroandrushchak.tests.signin;

import com.petroandrushchak.pages.YourLogoLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignInTest {

    private WebDriver webDriver;

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @DataProvider(name = "signInEmailAddressValidation")
    public Object[][] dataProviderMethod() {
        return new Object[][]
                {
                        {"invalidEmailAddress", "Invalid email address."},
                        {"validButDoesnotExist@gmail.com", "Authentication failed."}
                };
    }

    @Test (dataProvider = "signInEmailAddressValidation")
    public void testSingInValidation(String emailAddressValue, String expectedErrorMessageText){

        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

        YourLogoLoginPage yourLogoLoginPage = new YourLogoLoginPage(webDriver);

        yourLogoLoginPage.inputUserName(emailAddressValue);
        yourLogoLoginPage.inputPassword("blablabal");
        yourLogoLoginPage.clickSingInButton();

        String actualText = yourLogoLoginPage.getErrorMessageText();
        Assert.assertEquals(expectedErrorMessageText, actualText);
    }
}




