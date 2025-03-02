package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class Cart extends BasePage{
        public Cart(WebDriver driver) {
            super(driver);
        }

        @FindBy(xpath = "//h5[contains(text(),\"$\")]")
        List<WebElement> product1;

        @FindBy(className = "hrefch")
        List<WebElement> prod;

        @FindBy(xpath = "//a[text()=\"Add to cart\"]")
        WebElement add;

        @FindBy(xpath = "//a[@id=\"nava\"]")
        WebElement home;

        @FindBy(xpath = "//a[text()=\"Cart\"]")
        WebElement cartVisit;

        @FindBy(xpath = "//h3[@id=\"totalp\"]")
        WebElement totalPrice;

        @FindBy(xpath = "//a[text()=\"Delete\"]")
        List<WebElement> delete;

        @FindBy(xpath = "//tbody[@id=\"tbodyid\"]/tr/td[3]")
        List<WebElement> list;

        public int getProductPrice(int index) {
          String priceText = product1.get(index).getText().replace("$", "").trim();
          return Integer.parseInt(priceText);
        }

        public void addProductToCart(int index) {
          prod.get(index).click();
        }

        public void addToCart(){
            click(add);
        }

        public  void Home(){
            click(home);
        }

        public void CartVisit(){
            click(cartVisit);
        }

        public int getCartTotal() {
          String totalText = totalPrice.getText().replace("$", "").trim();
          return Integer.parseInt(totalText);
        }

        public int price(int ind){
            String p_price = list.get(ind).getText().replaceAll("[^0-9]", "").trim();
            return Integer.parseInt(p_price);
        }

        public void removeProduct(int index1){
            delete.get(index1).click();
        }

}
