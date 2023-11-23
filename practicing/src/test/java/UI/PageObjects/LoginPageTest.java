package UI.PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import UI.PageObjects.Login.RealWordLoginPage;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    WebDriver driver;
    RealWordLoginPage objRealWordLoginPage;
    String titleName = "Cypress Real World App";
    @BeforeTest
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        //ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:3000/signin");
        String webTitle = driver.getTitle();
        Assert.assertEquals(webTitle,titleName);
    }

    @Test(description = "Be able to login", priority = 0)
    public void login(){
        objRealWordLoginPage = new RealWordLoginPage(driver);
        objRealWordLoginPage.enterUsername("Katharina_Bernier");
        objRealWordLoginPage.enterPassword("s3cret");
        objRealWordLoginPage.clickLoginButton();
    }


}
