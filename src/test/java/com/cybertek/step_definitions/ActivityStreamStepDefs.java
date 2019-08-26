package com.cybertek.step_definitions;

import com.cybertek.pages.ActivityStreamPage;
import com.cybertek.utilities.BrowserUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ActivityStreamStepDefs {

    ActivityStreamPage activityStreamPage = new ActivityStreamPage();

    @Then("user clicks {string} on the top menu")
    public void user_clicks_on_the_top_menu(String string) {
    activityStreamPage.topMenuTaskBtn.click();
}

    @Then("enters a {string}")
    public void enters_a(String string) {
    activityStreamPage.taskInputBox.sendKeys(string);
    }

    @Then("user clicks {string} button")
    public void user_clicks_button(String string) {
    activityStreamPage.sendBtn.click();
    }

    @Then("{string} is listed on activity stream")
    public void is_listed_on_activity_stream(String expected) {
    String actual = activityStreamPage.visiblityOfTaskOnActStream.getText();
    System.out.println("Actual task is: " + actual);
    Assert.assertEquals(expected, actual);
    }

    @Then("User clicks Checklist")
    public void user_clicks_Checklist() {
        activityStreamPage.checkListBtn.click();
    }

    @Then("Checklist is displayed")
    public void checklist_is_displayed() {
        Assert.assertTrue(activityStreamPage.checkListPanel.isDisplayed());
    }

    @When("user enters a checklist item")
    public void user_enters_a_checklist_item() {
        activityStreamPage.checkListInputElement.sendKeys("Please do this job");
        activityStreamPage.checkListAddBtn.click();
    }

    @Then("checklist item is added to Checklist")
    public void checklist_item_is_added_to_Checklist() {
        String actual = activityStreamPage.checkListItems.getText();
        Assert.assertTrue(actual.contains("Please do this job"));
    }

    @Then("user clicks deadline field")
    public void user_clicks_deadline_field() {
        BrowserUtils.waitFor(2);
        activityStreamPage.deadLineInput.click();
        activityStreamPage.getRandomDate().click();
        activityStreamPage.calendarSelectBtn.click();
    }

    @Then("selected date is displayed on Deadline field")
    public void selected_date_is_displayed_on_Deadline_field() {
        BrowserUtils.waitFor(2);
        String actual = activityStreamPage.deadlineField.getAttribute("value");
        System.out.println(actual);

    }

}
