package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyLocationPage extends ActionPage {

    @FindBy(xpath = "//div[@class='modal-header']//button[@class='close']")
    WebElement closeSetHomeLocationButton;
    @FindBy(xpath = "//input[@id='ftztxt']")
    WebElement cityNameField;
    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancelButton;
    @FindBy(xpath = "//button[@id='tzq_save']")
    WebElement saveButton;
    @FindBy(xpath = "(//div[@class='row']//a[@href='#'])[1]")
    WebElement nearByHyperLink1;
    @FindBy(xpath = "(//div[@class='row']//a[@href='#'])[2]")
    WebElement nearByHyperLink2;
    @FindBy(xpath = "(//div[@class='row']//a[@href='#'])[3]")
    WebElement nearByHyperLink3;
    @FindBy(xpath = "(//div[@class='row']//a[@href='#'])[4]")
    WebElement nearByHyperLink4;
    @FindBy(xpath = "(//div[@class='row']//a[@href='#'])[5]")
    WebElement nearByHyperLink5;
    @FindBy(xpath = "(//div[@class='row']//a[@href='#'])[6]")
    WebElement nearByHyperLink6;
    @FindBy(xpath = "(//div[@class='row']//a[@href='#'])[7]")
    WebElement nearByHyperLink7;

    public MyLocationPage(WebDriver driver){super(driver);}

    public void clickCloseCrossButton(){
        waitForElementVisible(closeSetHomeLocationButton);
        clickElement(closeSetHomeLocationButton);
    }
}
