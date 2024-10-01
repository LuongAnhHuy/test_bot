package Trivio.defs;

import Trivio.common.BaseTest;
import Trivio.steps.HomeSteps;
import Trivio.steps.LanguageSteps;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static Trivio.testdatas.DataString.*;

@ExtendWith(SerenityJUnit5Extension.class)
class LanguageTest extends BaseTest {
    @Steps
    HomeSteps homeSteps;

    @Steps
    LanguageSteps languageSteps;

    @BeforeEach
    public void openTrivioHomePage() {
        homeSteps.openPage();
        homeSteps.switchToWindowHandle();
    }

    @Test
    void testVietnameseLanguage() {
        homeSteps.clickLanguageButton();
        languageSteps.clickToChooseLanguage(LANGUAGE_VIETNAMESE[0]);
        verifyEquals(homeSteps.getLanguageButtonText(), LANGUAGE_VIETNAMESE[1]);
    }

    @Test
    void testEnglishLanguage() {
        homeSteps.clickLanguageButton();
        languageSteps.clickToChooseLanguage(LANGUAGE_ENGLISH[0]);
        verifyEquals(homeSteps.getLanguageButtonText(), LANGUAGE_ENGLISH[1]);
    }

    @Test
    void testRussiaLanguage() {
        homeSteps.clickLanguageButton();
        languageSteps.clickToChooseLanguage(LANGUAGE_RUSSIA[0]);
        verifyEquals(homeSteps.getLanguageButtonText(), LANGUAGE_RUSSIA[1]);
    }

}
