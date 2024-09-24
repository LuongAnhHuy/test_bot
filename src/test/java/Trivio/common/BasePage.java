package Trivio.common;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;


public class BasePage extends PageObject {
    private Logger log;
    private Select select;
    private JavascriptExecutor jsExecutor;
    private int longTimeout = 30;
    private WebDriverWait explicitWait;
    String projectPath = System.getProperty("user.dir");

    public BasePage() {
        log = LogManager.getLogger(getClass());
    }

    public void getWindowHandles() {
        String mainWindowHandle = getDriver().getWindowHandle();
        Set<String> allWindowHandles = getDriver().getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                getDriver().switchTo().window(handle);
            }
        }
    }

    public void sendKeysToElement(WebElementFacade item, String value) {
        item.clear();
        item.sendKeys(value);
    }

    public void clickToElement(WebElementFacade item) {
        item.click();
    }

    public void clickToElement(WebElement item) {
        item.click();
    }

    public void clickToElementByJS(WebElementFacade element) {
        jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public void clickToElementByJS(WebElement element) {
        jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public void sendKeyToElementByJS(WebElementFacade element, String value) {
        jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].setAttribute('value'," + value + "'))", element);
    }

    public void scrollIntoViewByJS(WebElementFacade element) {
        jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollIntoViewByJS(String element) {
        jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollIntoViewByJS(WebElement element) {
        jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String getTextToElement(WebElementFacade item) {
        return item.getText();
    }

    public String getTextToElement(WebElement item) {
        return item.getText();
    }

    public void selectItemInDropdown(WebElementFacade item, String itemValue) {
        select = new Select(item);
        select.selectByVisibleText(itemValue);
    }

    public String getFirstSelectedItemInDropdown(WebElementFacade item) {
        select = new Select(item);
        return select.getFirstSelectedOption().getText();
    }

//    public void clickItemInListItems(List<WebElementFacade> allItem, String expected){
//        for (WebElementFacade item : allItem ){
//            if(item.getText().equals(expected)){
//                item.click();
//                break;
//            }
//        }
//    }

    public void clickItemInListItems(List<WebElement> allItem, String expected) {
        for (WebElement item : allItem) {
            if (item.getText().equals(expected)) {
                item.click();
                break;
            }
        }
    }

    public boolean isEnabledElement(WebElementFacade item) {
        return item.isEnabled();
    }

    public boolean isEnabledElement(WebElement item) {
        return item.isEnabled();
    }

    public boolean isDisplayedElement(WebElement item) {
        return item.isDisplayed();
    }

    public void clickItemInListItem(List<WebElement> allItem, String expected) {
        for (WebElement item : allItem) {
            if (item.getText().equals(expected)) {
                item.click();
                break;
            }
        }
    }

    public void checkToCheckbox(WebElementFacade item) {
        if (item.isSelected()) {
            item.click();
        }
    }

    public void unCheckToCheckbox(WebElementFacade item) {
        if (!item.isSelected()) {
            item.click();
        }
    }

    public void waitASeconds(int miliseconds) {
        waitABit(miliseconds);
    }

    public void waitUntilElementVisible(WebElementFacade e) {
        try {
            FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                    .withTimeout(Duration.of(longTimeout, ChronoUnit.SECONDS))
                    .pollingEvery(Duration.of(50, ChronoUnit.MILLIS));

            wait.until((ExpectedCondition<Boolean>) d -> e.isVisible());
        } catch (Exception ex) {
            log.info("" + ex);
        }
    }

    public void waitUntilElementClickable(WebElementFacade e) {
        try {
            FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                    .withTimeout(Duration.of(longTimeout, ChronoUnit.SECONDS))
                    .pollingEvery(Duration.of(50, ChronoUnit.MILLIS));

            wait.until((ExpectedCondition<Boolean>) d -> e.isClickable());
        } catch (Exception ex) {
            log.info("" + ex);
        }
    }

    public void waitUntilElementPresence(WebElementFacade e) {
        try {
            FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                    .withTimeout(Duration.of(longTimeout, ChronoUnit.SECONDS))
                    .pollingEvery(Duration.of(50, ChronoUnit.MILLIS));

            wait.until((ExpectedCondition<Boolean>) d -> e.isPresent());
        } catch (Exception ex) {
            log.info("" + ex);
        }
    }

    public void waitUntilElementVisibleByExplicit(WebElement locator) {
        explicitWait = new WebDriverWait(getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.visibilityOf(locator));
    }

    public void waitUntilElementVisibleByExplicit(WebElementFacade locator) {
        explicitWait = new WebDriverWait(getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.visibilityOf(locator));
    }

    public void waitUntilElementVisibleByExplicit(List<WebElement> locator) {
        explicitWait = new WebDriverWait(getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(locator));
    }

    public void waitUntilElementInvisibleByExplicit(WebElementFacade locator) {
        explicitWait = new WebDriverWait(getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.invisibilityOf(locator));
    }

    public void waitUntilElementClickableByExplicit(WebElementFacade locator) {
        explicitWait = new WebDriverWait(getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilElementClickableByExplicit(WebElement locator) {
        explicitWait = new WebDriverWait(getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void uploadFile(WebElementFacade item, String imageName) {
        item.sendKeys(projectPath + "\\uploadFiles\\" + imageName);
    }

    protected String getDynamicXpath(String locatorType, String... dynamicValue) {
        if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH") || locatorType.startsWith("Xpath")) {
            locatorType = String.format(locatorType, (Object[]) dynamicValue);
        }
        return locatorType;
    }

    protected void uploadFileTest(WebElementFacade elemt, String imageName) {
        File file = new File(projectPath + "\\uploadFiles\\" + imageName);
        elemt.sendKeys(file.getAbsolutePath());
    }

    protected void setAttribute(WebElementFacade element, String attributeName, String attributeValue) {
        jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }

    protected void setAttribute(WebElement element, String value) {
        jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].setAttribute('class'," + value + ")", element);
    }

    protected void removeAttributeInDOM(WebElementFacade element, String attributeName) {
        jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeName + "')", element);
    }

    public void setValueUsingJavaScript(WebElementFacade element, String value) {
        jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].class = arguments[1];", element, value);
    }

}
