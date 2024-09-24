package Trivio.pages;

import Trivio.common.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class TasksPages extends BasePage {
    @FindBy(xpath = "//a[@href='#task']")
    WebElement taskButton;

}
