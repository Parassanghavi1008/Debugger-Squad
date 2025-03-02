package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage {

    public Login(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//input[@id=\"loginusername\"]")
    WebElement user;

    @FindBy(xpath = "//input[@id=\"loginpassword\"]")
    WebElement pass;

    @FindBy(xpath = "//button[text()=\"Log in\"]")
    WebElement login;

    @FindBy(xpath = "(//button[text()=\"Close\"])[3]")
    WebElement close;

    @FindBy(xpath = "//a[@id=\"login2\"]")
    WebElement loginbtn;

    @FindBy(xpath = "//a[text()=\"Log out\"]")
    WebElement logout;

    public void Userid(String username){
        user.sendKeys(username);
    }

    public void Pass(String password){
        pass.sendKeys(password);
    }

    public void loginBtn(){
        login.click();
    }

    public void Close(){
        close.click();
    }

    public void btn(){
        click(loginbtn);
    }

    public void Logout(){
        click(logout);
    }
}
