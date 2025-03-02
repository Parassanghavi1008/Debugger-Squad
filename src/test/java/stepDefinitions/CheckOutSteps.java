package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Cart;
import pages.CheckOut;

import java.time.Duration;

public class CheckOutSteps {
    WebDriver driver;
    CheckOut checkout;
    Cart cart;

    @Given("I am on homepage")
    public void homepage(){
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        checkout = new CheckOut(driver);
        cart = new Cart(driver);
    }

    @When("I add products to the cart")
    public void Addproduct() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        cart.addProductToCart(0);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        cart.addToCart();
        Thread.sleep(2000);
        Alert alt = driver.switchTo().alert();
        alt.accept();
    }

    @Then("I go to cart & click on purchase")
    public void goToCart() throws InterruptedException {
        cart.CartVisit();
        Thread.sleep(2000);
        checkout.Place();
    }

    @Then("I give details")
    public void Details(){
        checkout.Name("Satya");
        checkout.Country("India");
        checkout.City("Angul");
        checkout.Card("12364589");
        checkout.Month("June");
        checkout.Year("2028");
        checkout.buy();
    }

    @Then("I successfully purchased")
    public void successMsg(){
        boolean visible = checkout.Msg();
        if(visible){
            checkout.Ok();
        }
        driver.quit();
    }
}
