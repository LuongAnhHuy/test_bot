package Trivio.testcases;

import Trivio.common.BaseTest;
import Trivio.steps.HomeSteps;
import Trivio.steps.TasksSteps;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static Trivio.testdatas.DataString.*;

@ExtendWith(SerenityJUnit5Extension.class)
class TasksTest extends BaseTest{
    @Steps
    HomeSteps homeSteps;

    @Steps
    TasksSteps tasksSteps;
    HashMap<String, String> taskList;


    @BeforeEach
    public void openTrivioHomePage() {
        tasksSteps.clearTaskFromDB("1202434244");
        homeSteps.openPage();
        homeSteps.switchToWindowHandle();
    }

    @Test
    void TC_01_do_task_and_get_reward() {
        taskList = tasksSteps.getInformationInDB();
        List<String> getCoinsFromDB = new ArrayList<>(homeSteps.getInformationInDB().keySet());
        int currentCoinsUI = homeSteps.getDefaultCoin();
        int currentCoinsDB = Integer.parseInt(homeSteps.getInformationInDB().get(getCoinsFromDB.get(0)));
        verifyEquals(currentCoinsDB, currentCoinsUI);

        homeSteps.clickTasksButton();
        verifyEquals(TASK_PAGE_TITLE, tasksSteps.getTasksPageTitle());

        List<String> taskHashMap = new ArrayList<>(taskList.keySet());
        for (String taskName : taskHashMap) {
            String taskReward = taskList.get(taskName);
            tasksSteps.clickToChooseTask(taskName);
            verifyEquals(taskName, tasksSteps.getTaskNamePopupTitle());
            verifyTrue(tasksSteps.getTaskRewardText().contains(taskReward));

            tasksSteps.clickFollowButton();
            tasksSteps.clickCheckTaskButton();
            verifyEquals(TASK_STATUS_NOTIFICATION_COMPLETED, tasksSteps.getTaskNotificationText());
            waitForTaskDone(2500);
            tasksSteps.closeTasksPopup();
            homeSteps.clickHomeButton();
            verifyEquals(currentCoinsDB + Integer.parseInt(taskReward), Integer.parseInt(homeSteps.getInformationInDB().get(getCoinsFromDB.get(0))));
            currentCoinsDB = Integer.parseInt(homeSteps.getInformationInDB().get(getCoinsFromDB.get(0)));
            verifyEquals(currentCoinsUI + Integer.parseInt(taskReward), homeSteps.getDefaultCoin());
            currentCoinsUI = homeSteps.getDefaultCoin();
            homeSteps.clickTasksButton();
            verifyTrue(tasksSteps.checkTaskDone(taskName));
        }
    }


    void waitForTaskDone(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
