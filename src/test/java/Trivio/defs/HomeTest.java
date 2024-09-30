package Trivio.defs;

import net.serenitybdd.core.exceptions.NoSuchElementException;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
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

    @Test
    public void openTrivioHomePage() {
        homeSteps.openPage();
        homeSteps.switchToWindowHandle();

        try {
            if (homeSteps.isDisplayedDailyHeader()) {
                homeSteps.clickToClaimDailyButton();
            }
        }catch (NoSuchElementException e) {
            e.printStackTrace();
        }
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
