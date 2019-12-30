package com.petroandrushchak.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourLogoLoginPage {

    @FindBy(id = "email")
    private WebElement emailAddress;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement login;

    @FindBy(css = ".center_column > .alert li")
    private WebElement errorMessage;

    private static final Logger LOG = LogManager.getLogger(YourLogoLoginPage.class);

    public YourLogoLoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void inputUserName(String email) {
        LOG.info("Entering user name value : " + email);
        emailAddress.sendKeys(email);
    }

    public void inputPassword(String passwordValue){
        LOG.info("Entering password value : " + passwordValue);
        password.sendKeys(passwordValue);
    }

    public void clickSingInButton(){
        LOG.info("Clicking on sign in button");
        login.click();
    }

    public String getErrorMessageText(){
       return errorMessage.getText();
    }
}

