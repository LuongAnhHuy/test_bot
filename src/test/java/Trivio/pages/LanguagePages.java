package Trivio.pages;

import Trivio.common.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class LanguagePages extends BasePage{
    @FindBy(xpath = "//button[normalize-space()='en']")
    WebElement languageButton;

    @FindBy(xpath = "//h3[contains(@class, 'text-stroke-primary')]")
    WebElement languagePageTitle;

    // PENDING


}
