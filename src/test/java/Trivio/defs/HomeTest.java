package Trivio.defs;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
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
    private boolean firstLogin = true;

    @Test
    public void openTrivioHomePage() {
        homeSteps.openPage();
        homeSteps.switchToWindowHandle();

        System.out.println(homeSteps.isDisplayedDailyHeader());
        if (firstLogin) {
            homeSteps.isDisplayedDailyHeader();
            homeSteps.clickToClaimDailyButton();
        } else {
            currentCoins = homeSteps.currentCoins();
            if (homeSteps.isDisplayedNameText()) {
                if (homeSteps.getNameText().equals("Anh Huy Luong")) {
                    homeSteps.clickToButton();
                }
            }
        }


//        currentCoins = homeSteps.currentCoins();
//        if (homeSteps.isDisplayedNameText()) {
//            if (homeSteps.getNameText().equals("Anh Huy Luong")) {
//                homeSteps.clickToButton();
//            }
//        }
        if (homeSteps.isEnabledClaimButton()) {
            homeSteps.clickToClaimButton();
            if (homeSteps.isNotEnabledClaimButton()) {
                verifyEquals(currentCoins, homeSteps.getDefaultCoin());
            }
        }
    }

}
