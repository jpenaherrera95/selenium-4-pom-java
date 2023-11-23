package UI.PageObjects.Login;

import UI.PageObjects.TestUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class RealWordLoginPage {

    private final WebDriver driver;
    @FindBy(css = "#username")
    private WebElement inputUsername;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;
    @FindBy (css = "button[data-test='signin-submit']")
    private WebElement buttonLogin;

    public RealWordLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void loginOnPage(String username, String password){
        TestUtils.typeOnElement(inputUsername,username);
        TestUtils.typeOnElement(inputPassword,password);
        TestUtils.clickOnButton(buttonLogin);
    }

}
