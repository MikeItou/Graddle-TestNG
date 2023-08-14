package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionPage {
    protected WebDriver driver;
    protected WebDriverWait explicitWait;
    protected Actions actions;

    public ActionPage(WebDriver driver){
        this.driver = driver;
        this.explicitWait = new WebDriverWait(this.driver, Duration.ofSeconds(1));
        this.actions = new Actions(this.driver);
        PageFactory.initElements(this.driver,this);

    }
    protected void waitForElementVisible(WebElement element){this.explicitWait.until(ExpectedConditions.visibilityOf(element));}
    protected void hoverElement(WebElement element){
        this.actions.moveToElement(element).perform();
    }
    protected void clickElement(WebElement element){
        this.actions.click(element).perform();
    }
    protected void fillField(WebElement element, String dataToUse){this.actions.sendKeys(element,dataToUse).perform();}
    public void closeBrowser(){this.driver.quit();}
}
