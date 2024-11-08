package Trivio.pages;

import Trivio.common.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    @FindBy(xpath = "//h2[@id='radix-:r4:']")
    List<WebElementFacade> dailyHeader;

    @FindBy(xpath = "//div[@class='mt-7 flex items-center justify-center']//button")
    WebElement claimDailyButton;

    @FindBy(xpath = "//p[@class='text-sm' and text()='Claim after']")
    WebElement claimAfterText;

    @FindBy(xpath = "//div[@class='flex space-x-[6px]']/button[last()]")
    WebElement languageButton;

    @FindBy(xpath = "//a[@href='#']")
    WebElement homeButton;

    @FindBy(xpath = "//a[@href='#task']")
    WebElement taskButton;

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
        clickToElement(tapButton);
    }

    public String getNameText() {
        waitUntilElementVisibleByExplicit(nameText);
        return getTextToElement(nameText);
    }

    public void clickNameText() {
        waitUntilElementVisibleByExplicit(nameText);
        nameText.click();
    }

    public boolean isDisplayedNameText() {
        waitUntilElementVisibleByExplicit(nameText);
        return nameText.isDisplayed();
    }

    public boolean isEnabledClaimButton() {
        waitUntilElementVisibleByExplicit(claimButton);
        return claimButton.isEnabled();
    }

    public void clickToClaimButton() {
        waitUntilElementClickableByExplicit(claimButton);
        clickToElement(claimButton);
    }

    public boolean isDisplayedDailyHeader() {
        return dailyHeader.size() > 0;
    }

    public void clickToClaimDailyButton() {
        waitUntilElementClickableByExplicit(claimDailyButton);
        clickToElementByJS(claimDailyButton);
    }

    public boolean isDisplayedClaimAfterText() {
        waitUntilElementVisibleByExplicit(claimAfterText);
        return claimAfterText.isDisplayed();
    }

    public void clickLanguageButton() {
        waitUntilElementVisibleByExplicit(languageButton);
        clickToElement(languageButton);
    }

    public String getLanguageButtonText() {
        waitUntilElementVisibleByExplicit(languageButton);
        return getTextToElement(languageButton);
    }

    public void clickTasksButton() {
        waitUntilElementVisibleByExplicit(taskButton);
        clickToElement(taskButton);
    }

    public void clickHomeButton() {
        waitUntilElementVisibleByExplicit(homeButton);
        clickToElement(homeButton);
    }

}
