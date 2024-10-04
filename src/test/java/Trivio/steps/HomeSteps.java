package Trivio.steps;

import Trivio.database.PostgreJDBC;
import Trivio.pages.HomePages;
import net.serenitybdd.annotations.Step;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class HomeSteps {
    HomePages homePages;

    private final Integer coinMax = 1;

    @Step
    public Integer getDefaultCoin() {
        return Integer.parseInt(getDefaultCoinInDatabase().get("bruno20699").replace(",",""));
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

    public HashMap<String, String> getDefaultCoinInDatabase() {
        HashMap<String, String> listNumber = new HashMap<>();
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
                String username = rs.getString("username");
                String currentPoint = rs.getString("current_point");
//                listNumber.put("username", username);
//                listNumber.put("current_point", currentPoint);
                listNumber.put(username, currentPoint);
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listNumber;
    }
}
