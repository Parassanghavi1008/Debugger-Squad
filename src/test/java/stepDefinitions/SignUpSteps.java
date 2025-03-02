package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SignUp;
import java.time.Duration;

public class SignUpSteps {
    WebDriver driver;
    SignUp signup;

    @Given("I am on the signup page")
    public void signup_page(){
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        signup = new SignUp(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[@id=\"signin2\"]")).click();
    }

    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword() {
        signup.User("hari23040");
        signup.Pass("hari@2304");
    }

    @And("I click on the signup button")
    public void signup_Button() throws InterruptedException {
        signup.Submit();
    }

    @Then("I should be redirected to the dashboard")
    public void iShouldBeRedirectedToTheDashboard() {
        String expectedUrl = "https://www.demoblaze.com/";
        String actualUrl = driver.getCurrentUrl();

        assert actualUrl != null;
        if (!actualUrl.equals(expectedUrl)) {
            throw new AssertionError("Login failed! Expected: " + expectedUrl + ", but got: " + actualUrl);
        }

        driver.quit();
    }
}
