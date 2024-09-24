package Trivio.pages;

import Trivio.common.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class HomePages extends BasePage {
    @FindBy(xpath = "//div[@class='text-stroke-primary font-riffic text-5xl font-bold']")
    WebElement coinText;

    @FindBy(xpath = "//button[@class='w-[222px]']" )
    WebElement tapButton;

    @FindBy(id = "trivio")
    WebElement trivioURL;

    @FindBy(xpath = "//a[@class='flex items-center space-x-2']//p")
    WebElement nameText;

    @FindBy(xpath = "//div[@class='relative flex space-x-3']//following-sibling::button")
    WebElement claimButton;

    public void clickToURL() {
        waitUntilElementVisibleByExplicit(trivioURL);
        trivioURL.click();
    }

    public String getTextCoin() {
        waitUntilElementVisibleByExplicit(coinText);
        return coinText.getText();
    }

    public void clickToButton() {
        waitUntilElementVisibleByExplicit(tapButton);
        tapButton.click();
    }

    public String getNameText() {
        waitUntilElementVisibleByExplicit(nameText);
        return getTextToElement(nameText);
    }

    public boolean isDisplayedNameText() {
        waitUntilElementVisibleByExplicit(nameText);
        return nameText.isDisplayed();
    }

    public boolean isEnabledClaimButton() {
        waitUntilElementVisibleByExplicit(claimButton);
        return claimButton.isEnabled();
    }

    public boolean isNotEnabledClaimButton() {
        waitUntilElementVisibleByExplicit(claimButton);
        return !claimButton.isEnabled();
    }

    public void clickToClaimButton() {
        waitUntilElementClickableByExplicit(claimButton);
        clickToElement(claimButton);
    }
}