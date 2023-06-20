package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage  extends ActionPage{

    @FindBy(xpath = "//div[@class='modal-header']//button[@class='close']")
    WebElement closeRegisterANewAccountButton;
    @FindBy(xpath = "//div[@class='form-row']//input[@name='fullname']")
    WebElement fullNameField;
    @FindBy(xpath = "//div[@class='form-row']//input[@placeholder='Email address...']")
    WebElement emailAdressField;
    @FindBy(xpath = "//div[@class='form-row']//input[@id='password']")
    WebElement passwordField;
    @FindBy(xpath = "//div[@class='form-row']//input[@id='password1']")
    WebElement confirmPasswordField;
    @FindBy(xpath = "//div[@class='modal-footer']//input[@id='create']")
    WebElement createAccountButton;
    @FindBy(xpath = "//div[@class='modal-footer']//button[@class='submit ghost fl']")
    WebElement cancelButton;
    public RegisterPage(WebDriver driver){super(driver);}
    public void clickCloseCrossButton(){
        waitForElementVisible(closeRegisterANewAccountButton);
        clickElement(closeRegisterANewAccountButton);
    }
    public void fillNameFiled(String name){
        waitForElementVisible(fullNameField);
        fillField(fullNameField,name);
    }
    public void fillEmailField(String email){
        fillField(emailAdressField,email);
    }
    public void fillPasswordField(String password){
        fillField(passwordField,password);
    }
    public void fillConfirmPasswordField(String confirmPassword){
        fillField(confirmPasswordField,confirmPassword);
    }
    public void clickCreateAccount(){
        clickElement(createAccountButton);
    }
    public void clickCancelButton(){
        clickElement(cancelButton);
    }
}
