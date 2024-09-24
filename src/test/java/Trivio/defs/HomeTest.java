package Trivio.defs;
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
        currentCoins = homeSteps.currentCoins();
        if (homeSteps.isDisplayedNameText()) {
            if (homeSteps.getNameText().equals("Anh Huy Luong")) {
                homeSteps.clickToButton();
            }
        }

        try {
            if (homeSteps.isEnabledClaimButton()) {
                homeSteps.clickToClaimButton();
                if (homeSteps.isNotEnabledClaimButton()){
                    verifyEquals(currentCoins, homeSteps.getDefaultCoin());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
