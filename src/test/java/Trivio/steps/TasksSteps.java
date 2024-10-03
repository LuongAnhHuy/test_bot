package Trivio.steps;


import Trivio.common.DatabaseUtil;
import Trivio.common.PostgreJDBC;
import Trivio.pages.TasksPages;
import net.serenitybdd.annotations.Step;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;


public class TasksSteps{
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
    public void closeTasksPopup() {
        tasksPages.closeTaskPopupButton();
    }

    @Step
    public boolean checkTaskDone(String taskName) {
        return tasksPages.checkTaskDone(taskName);
    }

    @Step
    public void clearTaskFromDB(String userID) {
        Connection conn = PostgreJDBC.getPostgreConnection();
        try {
            Statement statement = conn.createStatement();
            String query = "DELETE FROM \"trivio-be\".public.user_task_finished WHERE user_id = " + userID;
            statement.executeUpdate(query);
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Step
    public HashMap<String, String> getInformationInDB() {
        DatabaseUtil databaseUtil = new DatabaseUtil();
        return databaseUtil.executeQuery(
                "SELECT title, reward_number FROM \"trivio-be\".public.task",
                rs -> {
                    HashMap<String, String> result = new HashMap<>();
                    while (rs.next()) {
                        result.put(rs.getString("title"), rs.getString("reward_number"));
                    }
                    return result;
                }
        );
    }

}
