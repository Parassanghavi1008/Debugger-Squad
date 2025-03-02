package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Login;

import java.time.Duration;

public class InvalidLoginSteps {
    WebDriver driver;
    Login login;

    @Given("I am on Homepage")
    public void homepage(){
        driver = new ChromeDriver();
        login = new Login(driver);
        driver.get("https://www.demoblaze.com/");
    }

    @When("I click on Login")
    public void login(){
        login.btn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Then("I enter invalid data")
    public void data(){
        login.Userid("hari23");
        login.Pass("hari@12");
        login.loginBtn();
    }

    @Then("Error message shown")
    public void error() throws InterruptedException {
        Thread.sleep(2000);
        Alert alt = driver.switchTo().alert();
        alt.accept();
        login.Close();
    }

    @Then("I am not able to login")
    public void not_login(){
        driver.quit();
    }
}
