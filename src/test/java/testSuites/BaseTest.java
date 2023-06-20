package testSuites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import pages.*;

public class BaseTest {
    protected WebDriver driver;
    protected SignInPage signInPage;
    protected HeaderPage headerPage;
    protected MyLocationPage myLocationPage;
    protected RegisterPage registerPage;
    public void setupWebPage(String browser, String url){
        switch (browser){
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "safari" -> driver = new SafariDriver();
            case "edge" -> driver = new EdgeDriver();
        }
        this.driver.manage().window().maximize();
        this.driver.get(url);
        //your methods for each pages goes here
        signInPage = new SignInPage(driver);
        headerPage = new HeaderPage(driver);
        myLocationPage = new MyLocationPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @AfterTest
    public void after(){
        //this.driver.quit();
    }
}
