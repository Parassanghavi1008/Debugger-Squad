package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUp extends BasePage{

    public SignUp(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id=\"sign-username\"]")
    WebElement userid;

    @FindBy(xpath = "//input[@id=\"sign-password\"]")
    WebElement pass;

    @FindBy(xpath = "//button[text()=\"Sign up\"]")
    WebElement submit;

    @FindBy(xpath = "(//button[text()=\"Close\"])[2]")
    WebElement close;

    public void User(String name){
        userid.sendKeys(name);
    }

    public void Pass(String password){
        pass.sendKeys(password);
    }

    public void Submit(){
        submit.click();
    }

    public void Close(){
        close.click();
    }

}
