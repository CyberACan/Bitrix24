package com.cybertek.pages;

import com.cybertek.utilities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ActivityStreamPage extends BasePage {

    LoginPage loginPage = new LoginPage();

    @FindBy(xpath = "//*[@id=\"feed-add-post-form-tab-tasks\"]/span")
    public WebElement topMenuTaskBtn;

    @FindBy(css = "input[data-bx-id='task-edit-title']")
    public WebElement taskInputBox;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendBtn;

    @FindBy(xpath = "//div[@class='feed-task-info-text-item']/span[1]/a") // "//*[@class="feed-post-text-block-inner-inner"]"
    public WebElement visiblityOfTaskOnActStream;

    @FindBy(xpath = "(//*[@data-target='checklist'])[1]")
    public WebElement checkListBtn;

    @FindBy(css = "[data-bx-id='task-edit-checklist']")
    public WebElement checkListPanel;

    @FindBy(xpath = "(//*[@placeholder=\"Things to do\"])[2]")
    public WebElement checkListInputElement;

    @FindBy(css = "[class^=\"js-id-checklist-is-open\"]")
    public WebElement checkListAddBtn;

    @FindBy(xpath = "(//span[@class='js-id-checklist-is-i-title '])[1]")
    public WebElement checkListItems;

    @FindBy(xpath = "(//input[@class='task-options-inp'][@type='text'])[1]")
    public WebElement deadLineInput;

    @FindBy(xpath = "//div[@class='bx-calendar-range']//a[@class='bx-calendar-cell' or @class='bx-calendar-cell bx-calendar-weekend']")
    public List<WebElement> dayElements;

    //  @FindBy(linkText = "Select")
    @FindBy(xpath = "(//span[@class='bx-calendar-button-text'])[1]")
    public WebElement calendarSelectBtn;

    @FindBy(xpath = "(//input[@class=\"task-options-inp\"])[1]")
    public WebElement deadlineField;

    public WebElement getRandomDate(){
        Random random = new Random();
        int index = 1+ random.nextInt(30);

        return dayElements.get(index);
    }





}
