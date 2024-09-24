package Trivio.defs;

import Trivio.common.BaseTest;
import Trivio.steps.HomeSteps;
import Trivio.steps.PersonalSteps;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static Trivio.testdatas.DataString.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class PersonalTest extends BaseTest {
    @Steps
    HomeSteps homeSteps;

    @Steps
    PersonalSteps personalSteps;

    @Test
    public void openTrivioHomePage() throws InterruptedException {
        homeSteps.openPage();
        homeSteps.switchToWindowHandle();
        if (homeSteps.isDisplayedNameText()) {
            homeSteps.clickNameText();
        }

        if(personalSteps.getUserNameText().equals(USER_NAME_TITLE)){
            personalSteps.clickConnectTonWalletButton();
            if (personalSteps.isDisplayedWalletQrImage()) {
                personalSteps.clickWalletQrCloseButton();
            }
            personalSteps.clickFrensButton();
            verifyEquals(personalSteps.getFrensPageText(), FRENS_PAGE_TITLE);
        }
    }

}
