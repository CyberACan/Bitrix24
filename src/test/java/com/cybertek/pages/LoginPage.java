package com.cybertek.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "USER_LOGIN")
    @CacheLookup
    public WebElement userNameElement;

    @FindBy(name = "USER_PASSWORD")
    @CacheLookup
    public WebElement passwordElement;

    @FindBy(className = "login-btn")
    public WebElement loginButtonElement;

    @FindBy(id = "USER_REMEMBER")
    public WebElement rememberMeElement;

    @FindBy(css = " #login-popup > form > div.log-popup-footer > a")
    public WebElement forgotPasswordElement;

    @FindBy(xpath = "//*[@id=\"logo_24_text\"]/span[1]")
    public WebElement pageTitle;

    @FindBy(xpath = "//*[@id=\"login-popup\"]/div[2]")
    public WebElement errorMessageElement;


    public void login(String username, String password) {
        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
    }

    public void login() {
        String username = ConfigurationReader.getProperty("helpdeskusername");
        String password = ConfigurationReader.getProperty("helpdeskpassword");
        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
    }


    public void login(String role) {
        String username = "";
        String password = "";
        if (role.equalsIgnoreCase("helpdesk")) {
            username = ConfigurationReader.getProperty("helpdeskusername");
            password = ConfigurationReader.getProperty("helpdeskpassword");
        } else if (role.equalsIgnoreCase("hr")) {
            username = ConfigurationReader.getProperty("hrusername");
            password = ConfigurationReader.getProperty("hrpassword");
        } else if (role.equalsIgnoreCase("marketing")) {
            username = ConfigurationReader.getProperty("marketingusername");
            password = ConfigurationReader.getProperty("marketingpassword");
        }
        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
    }

    public String getErrorMessage() {
        return errorMessageElement.getText();
    }

    public void clickRememberMe() {
        BrowserUtils.waitForClickablility(rememberMeElement, Integer.valueOf(ConfigurationReader.getProperty("SHORT_WAIT")));
        if (!rememberMeElement.isSelected()) {
            rememberMeElement.click();
        }
    }


    public void goToLandingPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url1"));
    }

    public String getPageSubTitle() {
        //ant time we are verifying page name, or page subtitle, loader mask appears
        BrowserUtils.waitForStaleElement(pageTitle);
        return pageTitle.getText();
    }




}
