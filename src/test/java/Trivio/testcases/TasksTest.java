package Trivio.testcases;

import Trivio.common.BaseTest;
import Trivio.steps.HomeSteps;
import Trivio.steps.TasksSteps;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static Trivio.testdatas.DataString.*;

@ExtendWith(SerenityJUnit5Extension.class)
class TasksTest extends BaseTest{
    @Steps
    HomeSteps homeSteps;

    @Steps
    TasksSteps tasksSteps;

    @BeforeEach
    public void openTrivioHomePage() {
        homeSteps.openPage();
        homeSteps.switchToWindowHandle();
    }

    @Test
    void testTasksPage() {
        homeSteps.clickTasksButton();
        System.out.println("clicked tasks button");
        verifyEquals(TASK_PAGE_TITLE, tasksSteps.getTasksPageTitle());
        tasksSteps.clickToChooseTask(TASK_NAME_TELEGRAM);
        verifyEquals(TASK_NAME_TELEGRAM, tasksSteps.getTaskNamePopupTitle());
        verifyTrue(tasksSteps.getTaskRewardText().contains(TASK_REWARD_NUMBER));
        tasksSteps.clickFollowButton();
        tasksSteps.clickCheckTaskButton();
        verifyEquals(TASK_STATUS_NOTIFICATION_COMPLETED, tasksSteps.getTaskNotificationText());
//        verifyEquals(TASK_STATUS_POPUP_COMPLETED, tasksSteps.getTaskStatusPopupText());
        tasksSteps.closeTasksPopup();
//
        homeSteps.clickHomeButton();
        homeSteps.clickTasksButton();
        verifyTrue(tasksSteps.checkTaskDone(TASK_NAME_TELEGRAM));
    }

}
