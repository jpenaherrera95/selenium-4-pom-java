package UI.PageObjects.Tests;

import UI.PageObjects.TestUtils;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import UI.PageObjects.Login.RealWordLoginPage;
import org.testng.Assert;

import java.io.IOException;
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
    public void login() throws IOException {
        JsonNode data = TestUtils.getTestData("./UI/data/loginData.json");
        String username = data.path("users").path("username").textValue();
        String password = data.path("users").path("password").textValue();
        objRealWordLoginPage = new RealWordLoginPage(driver);
        objRealWordLoginPage.loginOnPage(username,password);
    }


}
