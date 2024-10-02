package Trivio.pages;

import Trivio.common.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class TasksPages extends BasePage {
    @FindBy(xpath = "//h1[@class='text-stroke-primary font-riffic text-32']")
    WebElement taskPageTitle;

    @FindBy(xpath = "//div[@class = 'rounded-2xl']/div[@aria-haspopup = 'dialog']")
    List<WebElement> taskList;

    @FindBy(xpath = "//span[@class='text-stroke-primary font-riffic text-32 font-bold text-white']")
    WebElement taskPopupNameTitle;

    @FindBy(xpath = "//span[@class = 'font-poppins text-32 font-bold text-white']")
    WebElement taskRewardText;

    @FindBy(xpath = "//span[normalize-space() = 'Follow']")
    WebElement followButton;

    @FindBy(xpath = "//span[normalize-space() = 'Check the Task']")
    WebElement checkTaskButton;

    @FindBy(xpath = "//span[@class = 'font-poppins text-xs font-medium text-[#DCFAE6]']")
    WebElement taskStatusPopupText;

    @FindBy(xpath = "//div[@class = 'text-sm font-semibold']")
    WebElement taskNotificationText;

//    @FindBy(xpath = "//button[@type]")
//    WebElement closeTaskPopupButton;

    @FindBy(xpath = "//html")
    WebElement outSidePopup;

    public String getTaskPageTitle() {
        waitUntilElementVisibleByExplicit(taskPageTitle);
        return taskPageTitle.getText();
    }

    public void clickTasks(String taskName){
        for (WebElement task : taskList) {
            if (task.getText().contains(taskName)) {
                task.click();
                break;
            }
        }
    }

    public boolean checkTaskDone(String taskName) {
        for (WebElement task : taskList) {
            if (task.getText().contains(taskName)) {
                waitUntilElementVisibleByExplicit(task.findElement(xpath(".//img")));
                System.out.println("Task is done");
                return true;
            }
        }
        return false;
    }

    public String getTaskPopupNameTitle() {
        waitUntilElementVisibleByExplicit(taskPopupNameTitle);
        return taskPopupNameTitle.getText();
    }

    public void clickFollowButton() {
        waitUntilElementVisibleByExplicit(followButton);
        followButton.click();
    }

    public void clickCheckTaskButton() {
        waitUntilElementVisibleByExplicit(checkTaskButton);
        checkTaskButton.click();
    }

    public String getTaskStatusPopupText() {
        waitUntilElementVisibleByExplicit(taskStatusPopupText);
        return taskStatusPopupText.getText();
    }

    public String getTaskNotificationText() {
        waitUntilElementVisibleByExplicit(taskNotificationText);
        return taskNotificationText.getText();
    }

    public void closeTaskPopupButton() {
        waitUntilElementVisibleByExplicit(outSidePopup);
        outSidePopup.click();
    }

    public String getTaskRewardText() {
        waitUntilElementVisibleByExplicit(taskRewardText);
        return taskRewardText.getText();
    }


}
