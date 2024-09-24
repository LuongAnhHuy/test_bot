package Trivio.steps;

import Trivio.pages.PersonalPages;
import net.serenitybdd.annotations.Step;

public class PersonalSteps {
    PersonalPages personalPages;

    @Step
    public String getUserNameText() {
        return personalPages.getUserNameText();
    }

    @Step
    public void clickConnectTonWalletButton() {
        personalPages.clickConnectTonWalletButton();
    }

    @Step
    public boolean isDisplayedWalletQrImage() {
        return personalPages.isDisplayedWalletQrImage();
    }

    @Step
    public void clickWalletQrCloseButton() {
        personalPages.clickWalletQrCloseButton();
    }

    @Step
    public void clickFrensButton() {
        personalPages.clickFrensButton();
    }

    @Step
    public String getFrensPageText() {
        return personalPages.getFrensPageText();
    }
}
