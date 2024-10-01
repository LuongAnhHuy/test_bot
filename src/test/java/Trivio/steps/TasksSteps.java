package Trivio.steps;

import Trivio.pages.TasksPages;
import net.serenitybdd.annotations.Step;


public class TasksSteps {
    TasksPages tasksPages;

    @Step
    public String getTasksPageTitle() {
        return tasksPages.getTaskPageTitle();
    }

    @Step
    public void clickToChooseTask(String taskName) {
        tasksPages.clickTasks(taskName);
    }

    @Step
    public String getTaskNamePopupTitle() {
        return tasksPages.getTaskPopupNameTitle();
    }

    @Step
    public void clickFollowButton() {
        tasksPages.clickFollowButton();
    }

    @Step
    public void clickCheckTaskButton() {
        tasksPages.clickCheckTaskButton();
    }

    @Step
    public String getTaskStatusPopupText() {
        return tasksPages.getTaskStatusPopupText();
    }

    @Step
    public String getTaskNotificationText() {
        return tasksPages.getTaskNotificationText();
    }

    @Step
    public String getTaskRewardText() {
        return tasksPages.getTaskRewardText();
    }

    @Step
    public void clickCloseTaskPopupButton() {
        tasksPages.clickCloseTaskPopupButton();
    }

    @Step
    public boolean checkTaskDone(String taskName) {
        return tasksPages.checkTaskDone(taskName);
    }

}
