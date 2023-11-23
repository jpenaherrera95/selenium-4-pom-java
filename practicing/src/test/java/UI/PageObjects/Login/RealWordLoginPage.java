package UI.PageObjects.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class RealWordLoginPage {

    WebDriver driver;

    @FindBy(css = "#username")
    WebElement inputUsername;
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.cssSelector("button[data-test='signin-submit']");


    public RealWordLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /*@BeforeMethod
    public void setUp(){
        driver.manage().window().maximize();
        String webTitle = driver.getTitle();
        Assert.assertEquals(webTitle,titleName);
    }*/

    /*@AfterMethod
    public void teardown(){
        driver.quit();
    }*/

    public void enterUsername(String username){
        inputUsername.isDisplayed();
        inputUsername.sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(inputPassword).isDisplayed();
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(buttonLogin).isDisplayed();
        driver.findElement(buttonLogin).isEnabled();
        driver.findElement(buttonLogin).click();
    }
}
