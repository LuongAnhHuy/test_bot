package Trivio.pages;

import Trivio.common.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class PersonalPages extends BasePage{
    @FindBy(xpath = "//span[@class='text-stroke-primary font-riffic text-2xl font-bold text-white']")
    WebElement nameText;

    @FindBy(xpath = "//button[contains(@class, 'flex items-center justify-center gap-2 rounded-xl')]")
    WebElement connectTonWalletButton;

    @FindBy(xpath = "//div[contains(@style, 'transform')]//div[1]//*[name()='svg']")
    WebElement walletQrImage;

    @FindBy(xpath = "//button[@data-tc-icon-button='true']//*[name()='svg']")
    WebElement walletQrCloseButton;

    @FindBy(xpath = "//button[contains(@class, 'flex w-full items-center justify-center gap-2')]")
    WebElement frensButton;

    @FindBy(xpath = "//span[@class='text-stroke-primary font-riffic text-32 font-bold']")
    WebElement frensPageText;

    public String getUserNameText() {
        waitUntilElementVisibleByExplicit(nameText);
        return nameText.getText();
    }

    public void clickConnectTonWalletButton() {
        waitUntilElementVisibleByExplicit(connectTonWalletButton);
        connectTonWalletButton.click();
    }

    public boolean isDisplayedWalletQrImage() {
        waitUntilElementVisibleByExplicit(walletQrImage);
        return walletQrImage.isDisplayed();
    }

    public void clickWalletQrCloseButton() {
        waitUntilElementVisibleByExplicit(walletQrCloseButton);
        walletQrCloseButton.click();
    }

    public void clickFrensButton() {
        waitUntilElementVisibleByExplicit(frensButton);
        frensButton.click();
    }

    public String getFrensPageText() {
        waitUntilElementVisibleByExplicit(frensPageText);
        return frensPageText.getText();
    }

}
