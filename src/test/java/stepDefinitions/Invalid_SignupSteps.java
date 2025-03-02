package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SignUp;

import java.time.Duration;

public class Invalid_SignupSteps {
    WebDriver driver;
    SignUp signup;

    @Given("I am on the Homepage")
    public void homepage(){
        driver = new ChromeDriver();
        signup = new SignUp(driver);
        driver.get("https://www.demoblaze.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[@id=\"signin2\"]")).click();
    }

    @When("I click on Signup & give duplicate data")
    public void iEnterValidUsernameAndPassword() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signup.User("hari2304");
        signup.Pass("hari@2304");
    }

    @And("Error message show")
    public void signup_Button() throws InterruptedException {
        signup.Submit();
        Thread.sleep(2000);
        Alert alt = driver.switchTo().alert();
        alt.accept();
        signup.Close();
    }

    @Then("I am unable to signup")
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
