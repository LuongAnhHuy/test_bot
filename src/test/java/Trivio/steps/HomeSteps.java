package Trivio.steps;

import Trivio.pages.HomePages;
import net.serenitybdd.annotations.Step;

public class HomeSteps {
    HomePages homePages;

    private final int coinMax = 1;

    @Step
    public int getDefaultCoin() {
        return Integer.parseInt(homePages.getTextCoin());
    }

    @Step
    public int currentCoins() {
        return getDefaultCoin() + coinMax;
    }

    @Step
    public void openPage() {
        homePages.openUrl("file:///C:/Users/huy.luong/Desktop/test-bot.html");
//        homePages.openUrl("file:///C:/Users/Asus%20ROG%20Strix%20GL703/OneDrive/Desktop/test-bot.html");
//        homePages.openUrl("file:///C:/Users/huy.luong/Desktop/test-bot.html");
        homePages.openUrl("file:///D:/telegram%20download/link.html");
        homePages.openUrl("file:///C:/Users/huy.luong/Desktop/test-bot.html");
//        homePages.openUrl("file:///C:/Users/Asus%20ROG%20Strix%20GL703/OneDrive/Desktop/test-bot.html");
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
    public void clickLanguageButton() {
        homePages.clickLanguageButton();
    }

    @Step
    public String getLanguageButtonText() {
        return homePages.getLanguageButtonText();
    }

}
