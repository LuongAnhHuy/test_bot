package Trivio.steps;

import Trivio.common.ExecuteDatabase;
import Trivio.common.PostgreJDBC;
import Trivio.pages.HomePages;
import net.serenitybdd.annotations.Step;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class HomeSteps implements ExecuteDatabase {
    HomePages homePages;

    private final Integer coinMax = 1;

    @Step
    public Integer getDefaultCoin() {
        return Integer.parseInt(homePages.getTextCoin().replace(",",""));
    }

    @Step
    public Integer currentCoins() {
        return getDefaultCoin() + coinMax;
    }

    @Step
    public void openPage() {
        homePages.openUrl("file:///C:/Users/huy.luong/Desktop/test-bot.html");
//        homePages.openUrl("file:///C:/Users/Asus%20ROG%20Strix%20GL703/OneDrive/Desktop/test-bot.html");
//        homePages.openUrl("D:\\telegram download\\link.html");
        homePages.clickToURL();
    }

    @Step
    public void switchToWindowHandle() {
        homePages.getWindowHandles();
    }

    @Step
    public void clickToButton() {
        for (int i = 0; i <= coinMax; i++) {
            homePages.clickToButton();
        }
    }

    @Step
    public String getNameText() {
        return homePages.getNameText();
    }

    @Step
    public void clickNameText() {
        homePages.clickNameText();
    }

    @Step
    public boolean isDisplayedNameText() {
        return homePages.isDisplayedNameText();
    }

    @Step
    public boolean isEnabledClaimButton() {
        return homePages.isEnabledClaimButton();
    }

    @Step
    public boolean isNotEnabledClaimButton() {
        return homePages.isNotEnabledClaimButton();
    }

    @Step
    public void clickToClaimButton() {
        homePages.clickToClaimButton();
    }

    @Step
    public boolean isDisplayedDailyHeader() {
        return homePages.isDisplayedDailyHeader();
    }

    @Step
    public void clickToClaimDailyButton() {
        homePages.clickToClaimDailyButton();
    }

    @Step
    public boolean isDisplayedClaimAfterText() {
        return homePages.isDisplayedClaimAfterText();
    }

    @Step
    public void clickLanguageButton() {
        homePages.clickLanguageButton();
    }

    @Step
    public String getLanguageButtonText() {
        return homePages.getLanguageButtonText();
    }

    @Step
    public void clickTasksButton() {
        homePages.clickTasksButton();
    }

    @Step
    public void clickHomeButton() {
        homePages.clickHomeButton();
    }

    @Step
    @Override
    public ArrayList<String> getInformationInDB() {
        ArrayList<String> listNumber = new ArrayList<>();
        String sql = """
                select username, current_point
                from "user"
                where username like 'bruno20699'
                """;
        try {
            Connection conn = PostgreJDBC.getPostgreConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                listNumber.add(rs.getString("username"));
                listNumber.add(rs.getString("current_point"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNumber;
    }
}
