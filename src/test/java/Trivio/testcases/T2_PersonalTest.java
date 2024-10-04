package Trivio.testcases;

import Trivio.common.BaseTest;
import Trivio.steps.HomeSteps;
import Trivio.steps.PersonalSteps;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.exceptions.NoSuchElementException;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static Trivio.testdatas.DataString.*;

@ExtendWith(SerenityJUnit5Extension.class)
class T2_PersonalTest extends BaseTest {
    @Steps
    HomeSteps homeSteps;

    @Steps
    PersonalSteps personalSteps;

    @BeforeEach
    public void openTrivioHomePage() {
        homeSteps.openPage();
        homeSteps.switchToWindowHandle();
    }

    @Test
    void TC01_testPersonalPage() {
        if (homeSteps.isDisplayedNameText()) {
            homeSteps.clickNameText();
        }

        if (verifyEquals(USER_NAME_TITLE, personalSteps.getUserNameText())){
            personalSteps.clickConnectTonWalletButton();
            if (personalSteps.isDisplayedWalletQrImage()) {
                personalSteps.clickWalletQrCloseButton();
            }
            personalSteps.clickFrensButton();
            verifyEquals(personalSteps.getFrensPageText(), FRENS_PAGE_TITLE);
        }
    }
}
