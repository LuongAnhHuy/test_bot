package Trivio.pages;

import Trivio.common.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;


import java.util.List;

public class LanguagePages extends BasePage{
    @FindBy(xpath = "//h3[contains(@class, 'text-stroke-primary')]")
    WebElement languagePageTitle;


    @FindBy(xpath = "//button[p]")
    List<WebElement> languageButtons;

    public String getLanguagePageTitle() {
        waitUntilElementVisibleByExplicit(languagePageTitle);
        return getTextToElement(languagePageTitle);
    }

    public void clickLanguageButton(String language) {
        for (WebElement languageButton : languageButtons) {
            if (languageButton.getText().equals(language)) {
                clickToElement(languageButton);
                break;
            }
        }
    }

}
