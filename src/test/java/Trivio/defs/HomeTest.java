package Trivio.defs;

import net.serenitybdd.core.exceptions.NoSuchElementException;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import Trivio.common.BaseTest;
import Trivio.steps.HomeSteps;
import net.serenitybdd.annotations.Steps;
import org.junit.jupiter.api.Test;

//@RunWith(SerenityRunner.class)
@ExtendWith(SerenityJUnit5Extension.class)
public class HomeTest extends BaseTest {

    @Steps
    HomeSteps homeSteps;
    private int currentCoins;

    @BeforeEach
    public void openTrivioHomePage() {
        homeSteps.openPage();
        homeSteps.switchToWindowHandle();
    }

    @Test
    public void TC_01_Claim_Daily_Reward() throws InterruptedException {
        try {
            Thread.sleep(6000);
            if (homeSteps.isDisplayedDailyHeader()) {
                homeSteps.clickToClaimDailyButton();
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
        System.out.println(currentCoins);
        if (homeSteps.isDisplayedNameText()) {
            if (homeSteps.getNameText().equals("Anh Huy Luong")) {
                homeSteps.clickToButton();
            }
        }

        if (homeSteps.isEnabledClaimButton()) {
            homeSteps.clickToClaimButton();
            if (homeSteps.isDisplayedClaimAfterText()) {
                verifyEquals(currentCoins, homeSteps.getDefaultCoin());
            }
        }

    }
}
