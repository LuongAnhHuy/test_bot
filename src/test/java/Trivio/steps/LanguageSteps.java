package Trivio.steps;

import Trivio.pages.LanguagePages;
import net.serenitybdd.annotations.Step;
public class LanguageSteps {
    LanguagePages languagePages;

    @Step
    public String getLanguagePageTitle() {
        return languagePages.getLanguagePageTitle();
    }

    @Step
    public void clickToChooseLanguage(String language) {
        languagePages.clickLanguageButton(language);
    }
}
