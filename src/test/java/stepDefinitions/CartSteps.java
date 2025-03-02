package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Cart;
import pages.Login;

import java.time.Duration;

public class CartSteps {
    WebDriver driver;
    Cart cart;
    Login login;
    int expectedTotal = 0;

    @Given("I am on the homepage")
    public void i_am_on_the_homepage(){
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        cart = new Cart(driver);
        login = new Login(driver);
        login.btn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @When("I am login to my account")
    public void login() throws InterruptedException {
        login.Userid("hari231");
        login.Pass("hari@123");
        login.loginBtn();
        Thread.sleep(3000);
    }

    @Then("I am click on product & add to cart")
    public void i_click_on_product() throws InterruptedException {
        int price1 = cart.getProductPrice(0);
        expectedTotal+=price1;
        cart.addProductToCart(0);
        Thread.sleep(2000);
        cart.addToCart();
        Thread.sleep(2000);
        Alert alt = driver.switchTo().alert();
        alt.accept();
        cart.Home();
        Thread.sleep(2000);
    }

    @Then("I click another product and add to cart")
    public void i_click_on_product1() throws InterruptedException {
        int price = cart.getProductPrice(1);
        expectedTotal+=price;
        cart.addProductToCart(1);
        Thread.sleep(2000);
        cart.addToCart();
        Thread.sleep(2000);
        Alert alt = driver.switchTo().alert();
        alt.accept();
        cart.Home();
    }

    @Then("I visit the cart and check total price")
    public void totalCartPrice() throws InterruptedException {
        cart.CartVisit();
        Thread.sleep(2000);
        int actualPrice = cart.getCartTotal();
        Assert.assertEquals(actualPrice,expectedTotal);
    }

    @Then("I remove one product")
    public void remove() {
        cart.removeProduct(0);
        expectedTotal -= cart.price(0);
    }

    @Then("I check the cart total again")
    public void check() throws InterruptedException {
        Thread.sleep(3000);
        int actualprice = cart.getCartTotal();
        Assert.assertEquals(actualprice,expectedTotal);
        login.Logout();
        driver.quit();
    }
}
