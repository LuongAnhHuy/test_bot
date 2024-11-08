package Trivio.testcases;

import net.serenitybdd.core.exceptions.NoSuchElementException;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import Trivio.common.BaseTest;
import Trivio.steps.HomeSteps;
import net.serenitybdd.annotations.Steps;
import org.junit.jupiter.api.Test;

//@RunWith(SerenityRunner.class)
@ExtendWith(SerenityJUnit5Extension.class)
public class T1_HomeTest extends BaseTest {

    @Steps
    HomeSteps homeSteps;
    private Integer currentCoins;

    @BeforeEach
    public void openTrivioHomePage() {
        homeSteps.openPage();
        homeSteps.switchToWindowHandle();
    }

    @Test
    public void TC_01_Claim_Daily_Reward() throws InterruptedException {
        try {
            Thread.sleep(3000);
            if (homeSteps.isDisplayedDailyHeader()) {
                homeSteps.clickToClaimDailyButton();
                Thread.sleep(3000);
            } else {
                throw new NoSuchElementException("There is no daily header");
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TC_02_Tap_and_Get_Coins() {
        currentCoins = homeSteps.currentCoins();
        if (homeSteps.isDisplayedNameText() && verifyEquals("Anh Huy Luong", homeSteps.getNameText())) {
            homeSteps.clickToButton();
        }

        if (homeSteps.isEnabledClaimButton()) {
            homeSteps.clickToClaimButton();
            if (homeSteps.isDisplayedClaimAfterText()) {
                verifyEquals(currentCoins, homeSteps.getDefaultCoin());
            }
        }
    }

    @Test
    public void TC_03_Tap_and_Get_Coins_When_Not_Full_Time() {
        currentCoins = homeSteps.currentCoins();
        if (homeSteps.isDisplayedNameText() && verifyEquals("Anh Huy Luong", homeSteps.getNameText())) {
            homeSteps.clickToButton();
        }
        if (homeSteps.isDisplayedClaimAfterText()) {
            verifyFalse(homeSteps.isEnabledClaimButton());
        }
    }
}
