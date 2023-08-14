package testSuites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.*;

public class BaseTest {
    protected WebDriver driver;
    protected SignInPage signInPage;
    protected HeaderPage headerPage;
    protected MyLocationPage myLocationPage;
    protected RegisterPage registerPage;
    protected ActionPage actionPage;
    public void setupWebPage(String browser, String url){
        switch (browser){
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "safari" -> driver = new SafariDriver();
            case "edge" -> driver = new EdgeDriver();
        }
        this.driver.manage().window().maximize();
        this.driver.get(url);
        //los metodos de cada pagina van aqui
        actionPage = new ActionPage(driver);
        headerPage = new HeaderPage(driver);
        myLocationPage = new MyLocationPage(driver);
        registerPage = new RegisterPage(driver);
        signInPage = new SignInPage(driver);
    }
}
