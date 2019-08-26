package com.cybertek.step_definitions;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
 //   DashboardPage dashboardPage = new DashboardPage();

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
       loginPage.goToLandingPage();
    }

    @When("user logs in as a hr")
    public void user_logs_in_as_a_hr() {
        String username = ConfigurationReader.getProperty("hrusername");
        String password = ConfigurationReader.getProperty("hrpassword");
        loginPage.login(username, password);
    }

    @Then("user verifies that {string} page name is displayed")
    public void user_verifies_that_page_name_is_displayed(String expected) {
        Assert.assertEquals(expected,  loginPage.getPageSubTitle());
    }

    @When("user logs in with {string} username and {string} password")
    public void user_logs_in_with_username_and_password(String string, String string2) {
        loginPage.login(string, string2);
    }

    @When("user verifies that {string} warning message is displayed")
    public void user_verifies_that_warning_message_is_displayed(String expected) {
        Assert.assertEquals(expected, loginPage.getErrorMessage());
    }

}
