package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends ActionPage {

    @FindBy(xpath = "//div[@class='modal-header']//button[@class='close']")
    WebElement closeSignInButton;
    public SignInPage(WebDriver driver){super(driver);}

    public void clickCloseCrossButton(){
        waitForElementVisible(closeSignInButton);
        clickElement(closeSignInButton);
    }
}
