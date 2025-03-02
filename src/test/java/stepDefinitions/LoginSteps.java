package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Login;
import java.time.Duration;

public class LoginSteps {
    WebDriver driver;
    Login login;

    @Given("I am on the login page")
    public void login_page(){
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        login = new Login(driver);
        login.btn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @When("I enter valid username & password")
    public void input_details(){
        login.Userid("hari231");
        login.Pass("hari@123");
    }

    @And("I click on the login button")
    public void Submit() {
        login.loginBtn();
    }

    @Then("I should be redirected to the homepage")
    public void validcheck() throws InterruptedException {
        String expectedUrl = "https://www.demoblaze.com/";
        String actualUrl = driver.getCurrentUrl();

        assert actualUrl != null;
        if (!actualUrl.equals(expectedUrl)) {
            throw new AssertionError("Login failed! Expected: " + expectedUrl + ", but got: " + actualUrl);
        }
        Thread.sleep(2000);
        login.Logout();
        driver.quit();
    }
}
